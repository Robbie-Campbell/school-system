package com.school;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

// This is the super class for all of the positions in the school
public class SchoolMember {

    // Keep track of total number of people at the school
    private static int numberOfSchoolMembers;

    // Declare all variables
    private final int instituteNumber;
    public String position;
    public String firstName;
    public String lastName;
    public String email;
    private String password;
    public int age;
    public SchoolMember(String firstName, String lastName, int age)
    {

        // Increment the number of people at the school
        numberOfSchoolMembers++;

        // Set default variables
        this.position = "Undefined";
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;


        // Set the number of the student at the school
        this.instituteNumber = (int)(Math.random() * 10000) + 1000;
    }

    // Get the name of the person
    public String getNames()
    {
        return String.format("%s %s\n", this.firstName, this.lastName);
    }

    // Set the email address of the person
    protected void setEmail()
    {
        this.email = this.firstName + this.lastName + this.instituteNumber + "@" + this.position.toLowerCase() + ".school.com";
    }

    // Return the email address of the person
    public String getEmail()
    {
        return String.format("The institute email of %s %s is: %s\n", this.firstName, this.lastName, this.email);
    }

    // Return the total number of the school members
    public static String getNumberOfSchoolMembers()
    {
        return "The total number of people at the school is: " + numberOfSchoolMembers;
    }

    // Create a password for the email of the user
    public String setPassword() throws NoSuchAlgorithmException {

        // Create variables for hash
        String algorithm = "MD5";
        System.out.println("Please enter your new password");
        Scanner enterPass = new Scanner(System.in);
        String enteredPass = enterPass.nextLine();
        String EncPass = generateHash(enteredPass, algorithm);

        // Set the password as the hashed value
        return this.password = EncPass;
    }

    // Converts the given password into a hash
    private static String generateHash(String enteredPass, String algorithm) throws NoSuchAlgorithmException {
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

    public String checkPass() throws NoSuchAlgorithmException {

        // Create variables for hash
        String algorithm = "MD5";
        System.out.println("Please enter your password");
        Scanner enterPass = new Scanner(System.in);
        String enteredPass = enterPass.nextLine();
        String EncPass = generateHash(enteredPass, algorithm);
        if (EncPass.equals(this.password))
        {
            return "That was the correct password! Well done!";
        }
        else
            return "That was the incorrect password";

    }
}
