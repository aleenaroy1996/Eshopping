package com.shoppingapp.admin.util;

import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import org.apache.commons.codec.binary.Base64;

@Component
public class PasswordUtil {

    /**
     * Encrypt a string using AES encryption algorithm.
     *
     * @param pwd the password to be encrypted
     * @return the encrypted string
     */
    public static String encrypt(String pwd) {
        byte[] bytesEncoded = Base64.encodeBase64(pwd.getBytes());
        return new String(bytesEncoded);

    }

    /**
     * Decrypt a string with AES encryption algorithm.
     *
     * @param encryptedData the data to be decrypted
     * @return the decrypted string
     */
    public static String decrypt(String encryptedData) {
        byte[] valueDecoded = Base64.decodeBase64(encryptedData);
        return new String(valueDecoded);
    }

    /**
     * Generate a new encryption key.
     */

}
