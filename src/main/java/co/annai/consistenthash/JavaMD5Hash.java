package co.annai.consistenthash;


import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class JavaMD5Hash implements Hasher {

    @Override
    public BigInteger getHash(String value) {
        BigInteger bigInt = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte [] bytes = value.getBytes(Charset.forName("UTF-8"));
            md.update(bytes);
            byte[] out = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : out) {
                sb.append(String.format("%02x", b));
            }
            bigInt = new BigInteger(sb.toString(), 16);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return bigInt;
    }
}
