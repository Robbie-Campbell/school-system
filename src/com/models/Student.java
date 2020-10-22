package com.models;

import java.sql.SQLException;

// Create the class for a student object
public class Student extends SchoolMember{

    // Keeps track of all of the students
    static int numberOfStudents;

    // Extends the base SchoolMember class
    public Student(String firstName, String lastName, int age) throws SQLException {
        super(firstName, lastName, age);

        // Increment the number of students
        numberOfStudents++;

        // Set the defaults
        this.position = "Student";
        setEmail();
    }

    // Return the total number of students at the school
    public static String getStudentNumbers()
    {
        return "Number of Students: " + numberOfStudents;
    }
}
