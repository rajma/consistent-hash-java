package co.annai.consistenthash;

import org.apache.commons.codec.digest.DigestUtils;

import java.math.BigInteger;
import java.nio.charset.Charset;

public class CommonsMD5Hash implements Hasher{

    @Override
    public BigInteger getHash(String value) {
        String hexMD5 = DigestUtils.md5Hex(value.getBytes(Charset.forName("UTF-8")));
        return new BigInteger(hexMD5, 16);
    }
}
