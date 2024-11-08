package com.spring.boot.encdec.encrypt_decrypt.service;

import org.springframework.stereotype.Service;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Service
public class EndecService {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";

    private final SecretKey secretKey;

    public EndecService() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");  // For AES encryption
        keyGenerator.init(256); // Set key size, e.g., 128, 192, or 256 bits for AES
        this.secretKey = keyGenerator.generateKey();  // Generate the key
    }

    //To Encrypt username
    public String encrypt(String username) throws Exception {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(username.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
    //To Decrypt username
    public String decrypt(String username) throws Exception {
        byte[]encryptedBytes=Base64.getDecoder().decode(username);
        Cipher cipher=Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE,secretKey);
        byte[]decryptBytes=cipher.doFinal(encryptedBytes);
        return new String(decryptBytes);
    }


}
