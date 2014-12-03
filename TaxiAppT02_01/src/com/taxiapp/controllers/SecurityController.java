package com.taxiapp.controllers;

import org.apache.commons.codec.binary.Base64;

public class SecurityController {
    
    public String encrypt(String string) {
        byte[] encryptByteArray = Base64.encodeBase64(string.getBytes());
        String encryptString = new String(encryptByteArray);
        return encryptString;
    }
    
    public String decrypt(String encryptedString) {
        byte[] decryptByteArray = Base64.decodeBase64(encryptedString.getBytes());
        String decryptString = new String(decryptByteArray);
        return decryptString;
    }
}
