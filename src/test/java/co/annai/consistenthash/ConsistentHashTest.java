package co.annai.consistenthash;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class ConsistentHashTest {


    @Test
    public void testConsistentHashJavaMD5(){
        ArrayList<String> al = new ArrayList<String>();
        al.add("redis1");
        al.add("redis2");
        al.add("redis3");
        al.add("redis4");

        String[] userIds =
                {"-84942321036308",
                        "-76029520310209",
                        "-68343931116147",
                        "-54921760962352"
                };
        Hasher hf = new JavaMD5Hash();
        ConsistentHash<String> consistentHash = new ConsistentHash<String>(hf, 100, al);
        String [] shards = new String[userIds.length];
        for(int i =0; i < userIds.length; i++) {
            shards[i] = consistentHash.get(userIds[i]);
        }
        String [] expected = {"redis4", "redis4", "redis2","redis3"};
        Assert.assertArrayEquals(expected,shards);
    }

    @Test
    public void testConsistentHashGuavaMD5Hash(){
        ArrayList<String> al = new ArrayList<String>();
        al.add("redis1");
        al.add("redis2");
        al.add("redis3");
        al.add("redis4");
        String[] userIds =
                {"-84942321036308",
                        "-76029520310209",
                        "-68343931116147",
                        "-54921760962352"
                };
        Hasher hf = new GuavaMD5Hash();
        ConsistentHash<String> consistentHash = new ConsistentHash<String>(hf, 100, al);
        String [] shards = new String[userIds.length];
        for(int i =0; i < userIds.length; i++) {
            shards[i] = consistentHash.get(userIds[i]);
        }
        String [] expected = {"redis4", "redis4", "redis2","redis3"};
        Assert.assertArrayEquals(expected,shards);
    }

    @Test
    public void testConsistentHashCommonsMD5Hash(){
        ArrayList<String> al = new ArrayList<String>();
        al.add("redis1");
        al.add("redis2");
        al.add("redis3");
        al.add("redis4");
        String[] userIds =
                {"-84942321036308",
                        "-76029520310209",
                        "-68343931116147",
                        "-54921760962352"
                };
        Hasher hf = new CommonsMD5Hash();
        ConsistentHash<String> consistentHash = new ConsistentHash<String>(hf, 100, al);
        String [] shards = new String[userIds.length];
        for(int i =0; i < userIds.length; i++) {
            shards[i] = consistentHash.get(userIds[i]);
        }
        String [] expected = {"redis4", "redis4", "redis2","redis3"};
        Assert.assertArrayEquals(expected,shards);
    }
}
