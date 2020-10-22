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

    public void submitToDatabase() throws SQLException {
        System.out.println(this.getInstituteNumber());
        String adminData = String.format("(%d, '%s','%s',%d,'%s',NULL,'%s', NULL);", this.getInstituteNumber(), this.firstName, this.lastName,
                this.age, this.email, this.position);
        String dataForInsert = "INSERT INTO admin VALUES" + adminData;
        stat.execute(dataForInsert);
    }
}
