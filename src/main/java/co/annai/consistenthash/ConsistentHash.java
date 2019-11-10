package co.annai.consistenthash;


import java.math.BigInteger;
import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHash <T>{

    private final Hasher hasher;

    private final int numberOfReplicas;

    private final SortedMap<BigInteger, T> circle = new TreeMap<BigInteger, T>();


    public ConsistentHash(Hasher hf, int numberOfReplicas, Collection<T> nodes){
        this.hasher = hf;
        this.numberOfReplicas = numberOfReplicas;
        for (T node: nodes){
            add(node);
        }
    }



    public void add(T node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            String node_replica = node.toString() + i;
            circle.put(hasher.getHash(node_replica),node);
        }
    }


    public void remove(T node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            String node_replica = node.toString() + i;
            circle.remove(hasher.getHash(node_replica));
        }
    }

    public T get(Object key){
        if(circle.isEmpty()){
            return null;
        }
        BigInteger hash = hasher.getHash(key.toString());
        if(!circle.containsKey(hash)){
            SortedMap<BigInteger, T> tailMap = circle.tailMap(hash);
            hash = tailMap.isEmpty()? circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hash);
    }

}
