package com.functions;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class PasswordHasher {

    // Converts the given password into a hash
    public static String generateHash(String enteredPass, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.reset();
        byte[] hash = digest.digest(enteredPass.getBytes());
        return bytesToStringHex(hash);
    }

    // Permit hex encoding
    private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

    // Encrypts the hashed password
    private static String bytesToStringHex(byte[] bytes)
    {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0;j < bytes.length; j++)
        {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }

    // Check the user password input
    public static String checkPass(String pass) throws NoSuchAlgorithmException {

        // Create variables for hash
        String algorithm = "MD5";
        String EncPass = generateHash(pass, algorithm);
        if (EncPass.equals(pass))
            return "That is the correct password";
        else
            return "That was the incorrect password";

    }
}
