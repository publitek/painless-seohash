/*
 * Copyright [2018] [Ben Youngblut]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.fotosearch.plugins.seohash;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


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
        byte[] hash = MD5.digest(decoded.getBytes(StandardCharsets.UTF_8));
        return new BigInteger(1, hash);
    }
}
