package org.com.nubes.security;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

public class KeyStore {
    private String STRING_AES_KEY = "2b7e151628aed2a6abf7158809cf4f3c";
    private SecretKeySpec aesKey;

    public KeyStore() {
        aesKey = new SecretKeySpec(DatatypeConverter.parseHexBinary(STRING_AES_KEY), "AES");

    }

    public SecretKeySpec getAesKey() {
        return aesKey;
    }
    
    public static void main(String[] args) {
    	KeyStore ks = new KeyStore();
    	System.out.println(ks.getAesKey());
	}
}
