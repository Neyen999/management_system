package com.personal.system.utils;

import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

@Component
public class AesEncrypter {
    private static final String AES = "AES";
    private static final String UTF8 = "UTF8";
    private SecretKey secretKey;
    private IvParameterSpec iv;

    public AesEncrypter() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(AES);
        keyGenerator.init(128, new SecureRandom());
        secretKey = keyGenerator.generateKey();

        iv = new IvParameterSpec(new byte[16]);
    }

    public byte[] encrypt(String data) {
        try {
            Cipher cipher = Cipher.getInstance(AES + "/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
            byte[] encryptedData = cipher.doFinal(data.getBytes(StandardCharsets.UTF_8));
            return encryptedData;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String decrypt(String encryptedData) {
        try {
            Cipher cipher = Cipher.getInstance(AES + "/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
//            byte[] decodedData = Base64.getDecoder().decode(encryptedData); // decode from Base64 String
            byte[] decryptedData = cipher.doFinal();
            return new String(decryptedData, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
