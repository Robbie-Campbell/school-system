package com.school;

import java.util.Scanner;

// The teacher class represents all of the teachers in the school.
public class Teacher extends SchoolMember{

    // This number keeps a track of the number of teachers, increments each time the class is instantiated
    private static int numberOfTeachers = 0;

    // Unique Variable
    private String role;

    private boolean hasLevel4;

    // Extends the SchoolMember Class
    public Teacher(String firstName, String lastName, int age, boolean hasLevel4) {
        super(firstName, lastName, age);

        // Keeps a track of how many teachers are in the school
        numberOfTeachers++;

        // Set the defaults of this class
        this.role = "not set";
        this.position = "Teacher";
        this.hasLevel4 = hasLevel4;
        setEmail();
    }

    // Determines what the role of the teacher is, if there is none available the option to put a new role in appears.
    public void getRole()
    {

        // Return the role
        if (!this.role.equals("not set"))
            System.out.printf("The role of %s %s is: %s\n", this.firstName, this.lastName, this.role);

        // Option to set the new role of the teacher
        else
        {
            System.out.printf("The role of teacher %s has not been set, would you like to do this now?\n", this.firstName);
            Scanner response = new Scanner(System.in);
            String setTeacher = response.nextLine();

            // Enter the teachers new role
            if (setTeacher.equals("yes"))
            {
                System.out.println("Please pass in the teacher role");
                Scanner setRole = new Scanner(System.in);
                String roleFinalised = setRole.nextLine();
                setRole(roleFinalised);
                System.out.printf("Thankyou, teacher %s has been assigned the role of: %s\n",this.firstName, this.role);
            }

            // Do not enter the teachers new role
            else
            {
                System.out.println("Please return when the role has been established.");
            }
        }
    }

    // Set the role of the teacher
    public void setRole(String role) {
        this.role = role;
    }

    // Get the level 4 status of the teacher and return whether they are qualified
    public void getLevel4Status()
    {
        if (this.hasLevel4)
            System.out.printf("Teacher: %s has their level 4 qualification\n", this.firstName);
        else
            System.out.printf("Teacher: %s does not have their level 4 qualification\n", this.firstName);
    }

    // Sets the new status of the level 4 for the teacher
    public boolean setLevel4Status(boolean level4)
    {
        return this.hasLevel4 = level4;
    }

    // Display the total number of teachers
    public static String getTeacherNumbers()
    {
        return "Number of teaching staff: " + numberOfTeachers;
    }
}
