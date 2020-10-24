package com.SQLQueries;

import java.security.NoSuchAlgorithmException;
import java.sql.*;

import static com.functions.PasswordHasher.generateHash;

public class AddPasswordToUser {
    // Declare variables for database
    private static final String username = "root";
    private static final String pass = System.getenv("mysqlPass");
    public static String success;

    // Set the password of the selected user
    public AddPasswordToUser(String table, String password, String firstName, String lastName, int IDCheck) throws SQLException, NoSuchAlgorithmException {
        String search = String.format("UPDATE %s SET password = '%s' WHERE first_name = '%s' AND last_name = '%s'",
                table, this.setPassword(password), firstName, lastName);
        String getuserID = String.format("SELECT userID FROM %s WHERE first_name = '%s' AND last_name = '%s'", table, firstName, lastName);
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school-system", username, pass);
        Statement stat = conn.createStatement();
        Connection conn2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/school-system", username, pass);
        Statement stat2 = conn2.createStatement();
        ResultSet rs = stat2.executeQuery(getuserID);
        rs.next();
        if (IDCheck == rs.getInt("userID")) {
            stat.executeUpdate(search);
            success = this.successfulUpdate(true);
        }
        else
        {
            success = this.successfulUpdate(false);
        }
    }

    // Create a password for the email of the user
    public String setPassword(String newPass) throws NoSuchAlgorithmException {

        // Create variables for hash
        String algorithm = "MD5";

        // Set the password as the hashed value
        return generateHash(newPass, algorithm);
    }

    public String successfulUpdate(boolean success)
    {
        return success ? "The password has been successfully updated!" : "The userID was incorrect";
    }
}
