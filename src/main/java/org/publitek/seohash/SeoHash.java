package org.publitek.seohash;

import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;
import java.lang.IllegalArgumentException;
import java.security.MessageDigest;
import java.math.BigInteger;
import java.net.URLDecoder;


public class SeoHash {
    public static BigInteger getHash(String key) throws NoSuchAlgorithmException {
        MessageDigest MD5 = MessageDigest.getInstance("MD5");
        String decoded;
        try {
            decoded = URLDecoder.decode(key, "UTF-8");
        } catch (IllegalArgumentException e) {
            decoded = key;
        } catch (UnsupportedEncodingException e) {
            decoded = key;
        }
        byte[] hash = MD5.digest(decoded.getBytes());
        return new BigInteger(1, hash);
    }
}
