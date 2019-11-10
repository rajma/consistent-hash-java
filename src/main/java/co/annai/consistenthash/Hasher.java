package co.annai.consistenthash;

import java.math.BigInteger;

/**
 * Interface to use for different implementations
 */
public interface Hasher {

    public BigInteger getHash(String value);
}
