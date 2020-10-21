package com.models;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import static com.functions.PasswordHasher.generateHash;

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

    public String getInstituteNumber()
    {
        return String.valueOf(this.instituteNumber);
    }

    // Get the name of the person
    public String getNames()
    {
        return String.format("%s %s ", this.firstName, this.lastName);
    }

    // Set the email address of the person
    protected void setEmail()
    {
        this.email = this.firstName.toLowerCase() + this.lastName.toLowerCase() + this.instituteNumber + "@" + this.position.toLowerCase() + ".school.com";
    }

    // Return the email address of the person
    public String getEmail()
    {
        return String.format("The institute email of %s %s is: \n%s\n", this.firstName, this.lastName, this.email);
    }

    // Return the total number of the school members
    public static int getNumberOfSchoolMembers()
    {
        return numberOfSchoolMembers;
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
