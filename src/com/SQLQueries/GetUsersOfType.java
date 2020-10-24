package com.SQLQueries;

import java.sql.*;
import java.util.ArrayList;

// Class gets all users for the password update function in the gui, also only allows users with null passwords
public class GetUsersOfType {

    // Declare variables for database
    private static final String username = "root";
    private static final String pass = System.getenv("mysqlPass");
    private ArrayList<String> users;

    // Get all users
    public GetUsersOfType(String table) throws SQLException {
        String search = String.format("SELECT first_name, last_name FROM %s WHERE password IS NULL", table);
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school-system", username, pass);
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(search);
        rs.next();
        this.users.add(String.format("%s %s", rs.getString("first_name"), rs.getString("last_name")));
    }

    public ArrayList<String> getResult()
    {
        return this.users;
    }
}
