package com.models;


import java.sql.SQLException;

// The Admin class of the school
public class Admin extends SchoolMember{

    // Keep track of the number of admin staff
    private static int numberOfAdmin;

    // Extends the SchoolMember class
    public Admin(String firstName, String lastName, int age) throws SQLException {
        super(firstName, lastName, age);

        // Increment the number of Admin staff
        numberOfAdmin++;

        // Set the defaults of this class
        this.position = "Admin";
        setEmail();
    }

    // Return the number of admin staff
    public static String getAdminNumbers()
    {
        return "Number of admin staff: " + numberOfAdmin;
    }
}
