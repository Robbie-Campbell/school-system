package com.SQLQueries;

import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;

import static com.functions.PasswordHasher.generateHash;

public class AddPasswordToUser {
    // Declare variables for database
    private static final String username = "root";
    private static final String pass = System.getenv("mysqlPass");

    // Set the password of the selected user
    public AddPasswordToUser(String table, String password, String firstName, String lastName) throws SQLException, NoSuchAlgorithmException {
        String search = String.format("UPDATE %s SET password = '%s' WHERE first_name = '%s' AND last_name = '%s'",
                table, this.setPassword(password), firstName, lastName);
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school-system", username, pass);
        Statement stat = conn.createStatement();
        stat.executeUpdate(search);
    }

    // Create a password for the email of the user
    public String setPassword(String newPass) throws NoSuchAlgorithmException {

        // Create variables for hash
        String algorithm = "MD5";

        // Set the password as the hashed value
        return generateHash(newPass, algorithm);
    }
}
