package com.SQLQueries;

import java.sql.*;
import java.util.ArrayList;

// Search for a user in the database function
public class SearchForUser {

    // Initialise variables
    private static final String username = "root";
    private static final String pass = System.getenv("mysqlPass");
    private final String column;
    private String value;
    private final ArrayList<String> values;
    private String firstName;

    // Initialises the query
    public SearchForUser(String query, String column, String position) throws SQLException {
        this.column = column;

        // Create the statement to search for the user
        String search = String.format("SELECT * FROM %s WHERE %s = '%s'", position, column, query);
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school-system", username, pass);
        Statement stat = conn.createStatement();
        ResultSet rs = stat.executeQuery(search);

        // return values, either one user or more than one user.
        value = "";
        values = new ArrayList<String>();

        // Fills in the data for the return values
         while (rs.next())
         {
             String id = rs.getString("userID");
             String email = rs.getString("email");
             firstName = rs.getString("first_name");
             String lastName = rs.getString("last_name");
             int age = rs.getInt("age");
             value = String.format("User ID: %s\nUser email:\n%s\nUser full name: %s %s\nUser age: %d",
                    id, email, firstName, lastName, age);
             values.add(String.format("%s: %s %s\n", id, firstName, lastName));
         }
    }

    // Get the string return values of this class
    public String returnUsers()
    {
        // No users returned
        if (this.values.size() == 0)
        {
            return String.format("No users with that %s could be found", this.column);
        }

        // Only one user returned
        else if (this.values.size() == 1)
        {
            return this.value;
        }

        // More than one user returned
        else
        {
            String names = "";
            for (String s : values) names += s;
            return String.format("There was more than one user with the %s:\n%s\n%s" +
                    "Please use the id to specify which you want.", this.column, this.firstName, names);
        }
    }
}
