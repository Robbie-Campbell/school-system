package com.models;

import java.sql.SQLException;

// Create the class for a student object
public class Student extends SchoolMember{

    // Keeps track of all of the students
    static int numberOfStudents;
    private double GPA;

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

    public void submitToDatabase() throws SQLException {
        System.out.println(this.getInstituteNumber());
        String studentData = String.format("(%d, '%s','%s',%d,'%s',NULL, '%s' , NULL);", this.getInstituteNumber(), this.firstName, this.lastName,
                this.age, this.email, this.position);
        String dataForInsert = "INSERT INTO student VALUES" + studentData;
        stat.execute(dataForInsert);
    }
}
