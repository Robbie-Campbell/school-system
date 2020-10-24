package com.models;

import org.w3c.dom.ls.LSOutput;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Scanner;

import static com.functions.PasswordHasher.generateHash;

// This is the super class for all of the positions in the school
public class SchoolMember {

    // Initialise database variables
    private static final String username = "root";
    private static final String pass = System.getenv("mysqlPass");
    private final Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school-system", username, pass);
    private final Connection conn1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/school-system", username, pass);
    private final Connection conn2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/school-system", username, pass);
    public Statement stat = conn.createStatement();
    public Statement stat1 = conn1.createStatement();
    public Statement stat2 = conn2.createStatement();
    ResultSet rs = stat.executeQuery("SELECT COUNT(*) FROM teacher");
    ResultSet rs1 = stat1.executeQuery("SELECT COUNT(*) FROM admin");
    ResultSet rs2 = stat2.executeQuery("SELECT COUNT(*) FROM student");

    // Keep track of total number of people at the school
    public static int numberOfSchoolMembers;

    // Declare all variables
    private final int instituteNumber;
    public String position;
    public String firstName;
    public String lastName;
    public String email;
    private String password;
    public int age;
    public SchoolMember(String firstName, String lastName, int age) throws SQLException
    {

        // Increment the number of people at the school
        rs.next();
        rs1.next();
        rs2.next();
        int getUsers = rs.getInt(1) + rs1.getInt(1) + rs2.getInt(1);
        numberOfSchoolMembers = getUsers;

        // Set default variables
        this.position = "Undefined";
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;

        // Set the number of the student at the school
        this.instituteNumber = 10001 + numberOfSchoolMembers;
    }

    // Get the institute number
    public int getInstituteNumber()
    {
        return this.instituteNumber;
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
