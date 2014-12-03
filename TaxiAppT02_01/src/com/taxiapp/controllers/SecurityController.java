package com.taxiapp.controllers;

import org.apache.commons.codec.binary.Base64;

public class SecurityController {
	
	public String encodeString(String string) {
		byte[] encodedByteArray = Base64.encodeBase64(string.getBytes());
		String encodedString = new String(encodedByteArray);
		return encodedString;
	}
	
	public String decodeString(String encryptedString) {
		byte[] decodedByteArray = Base64.decodeBase64(encryptedString.getBytes());
		String decodedString = new String(decodedByteArray);
		return decodedString;
	}
	
}