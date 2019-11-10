package co.annai.consistenthash;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.math.BigInteger;
import java.nio.charset.Charset;

public class GuavaMD5Hash implements Hasher {

    @Override
    public BigInteger getHash(String value) {
        HashFunction hashFunction = Hashing.md5();
        HashCode hc = hashFunction.hashString(value, Charset.forName("UTF-8"));
        return new BigInteger(hc.toString(), 16);
    }
}
