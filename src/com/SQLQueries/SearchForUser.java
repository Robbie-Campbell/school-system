package com.SQLQueries;

import java.sql.*;

public class SearchForUser {
    private static final String username = "root";
    private static final String pass = System.getenv("mysqlPass");
    public Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school-system", username, pass);
    public Statement stat = conn.createStatement();
    public String returnValue;

    public SearchForUser(String query, String column) throws SQLException {
        String search = String.format("SELECT * FROM teacher WHERE %s = '%s'", column, query);
        ResultSet rs = stat.executeQuery(search);
        while (rs.next()) {
            String id = rs.getString("userID");
            String email = rs.getString("email");
            String firstName = rs.getString("first_name");
            String lastName = rs.getString("last_name");
            int age = rs.getInt("age");
            returnValue = String.format("User ID: %s\nUser email:\n%s\nUser full name: %s %s\nUser age: %d",
                    id, email, firstName, lastName, age);
        }
    }

}
