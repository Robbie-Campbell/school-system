package com.SQLQueries;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TablesSchema {

    private static final String username = "root";
    private static final String pass = System.getenv("mysqlPass");
    public Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/school-system", username, pass);
    public Statement stat = conn.createStatement();

    public TablesSchema() throws SQLException {
        String createStudentTable = "CREATE TABLE student (" +
                "userID INT(5) PRIMARY KEY," +
                "first_name VARCHAR(50) NOT NULL," +
                "last_name VARCHAR(50) NOT NULL," +
                "age INT(2) NOT NULL," +
                "email VARCHAR(100) NOT NULL," +
                "password VARCHAR(40) NULL," +
                "position VARCHAR(10) NOT NULL," +
                "GPA FLOAT(1,1) NULL" +
                ")";
        String createAdminTable = "CREATE TABLE admin (" +
                "userID INT(5) PRIMARY KEY," +
                "first_name VARCHAR(50) NOT NULL," +
                "last_name VARCHAR(50) NOT NULL," +
                "age INT(2) NOT NULL," +
                "email VARCHAR(100) NOT NULL," +
                "password VARCHAR(40) NULL," +
                "position VARCHAR(10) NOT NULL," +
                "role VARCHAR(10) NULL " +
                ")";
//        stat.execute(createStudentTable);
        stat.execute(createAdminTable);
    }

//    public static void main(String[] args) throws SQLException {
//        TablesSchema create = new TablesSchema();
//    }

}
