package com.gui;

import com.models.Admin;
import com.models.SchoolMember;
import com.models.Student;
import com.models.Teacher;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class RegisterUser implements ActionListener {

    // Initialise variables
    JFrame frame;
    JPanel mainPanel, titlePanel, buttonPanel;
    Border raised;
    JLabel title, memberPrompt, firstNamePrompt, lastNamePrompt, agePrompt, numberOfUsers;
    JComboBox schoolMemberType;
    JTextField enterFirstName, enterLastName, enterAge;
    JTextArea nameValue;
    JButton createStaffMember, returnToHome;
    Color darkBlue, white, darkRed, darkGreen;
    Font titleFont, buttonFont;

    public RegisterUser () throws SQLException {

        // Create the frame object
        frame = new JFrame("School Project");
        frame.setResizable(false);
        frame.setBounds(200,200,600,500);

        // Create style elements
        raised = BorderFactory.createRaisedBevelBorder();
        darkBlue = new Color(10,10,49);
        darkGreen = new Color(10,49,10);
        darkRed = new Color(49,10,10);
        white = new Color(240,240,240);
        titleFont = new Font("Helvetica", Font.BOLD, 31);
        buttonFont = new Font("Helvetica", Font.BOLD, 22);

        // Add the panel to the frame
        mainPanel = new JPanel();
        mainPanel.setBorder(raised);
        mainPanel.setLayout(null);
        mainPanel.setBackground(white);
        frame.add(mainPanel);

        // Create the title Panel and label
        titlePanel = new JPanel();
        titlePanel.setBounds(0,0,600,50);
        titlePanel.setBackground(darkBlue);
        mainPanel.add(titlePanel);

        title = new JLabel("Register a user".toUpperCase());
        title.setFont(titleFont);
        title.setForeground(white);
        titlePanel.add(title);

        // Create a button Panel
        buttonPanel = new JPanel();
        buttonPanel.setBounds(0,400,585,65);
        buttonPanel.setLayout(new BorderLayout(0,0));
        mainPanel.add(buttonPanel);

        // Create the label objects
        memberPrompt = new JLabel("Enter school member type:");
        memberPrompt.setBounds(300, 75, 200, 30);
        mainPanel.add(memberPrompt);

        // Labels for textfield prompts
        firstNamePrompt = new JLabel("Enter first name:");
        firstNamePrompt.setBounds(50,75,200,30);
        mainPanel.add(firstNamePrompt);
        lastNamePrompt = new JLabel("Enter last name:");
        lastNamePrompt.setBounds(50,125,200,30);
        mainPanel.add(lastNamePrompt);
        agePrompt = new JLabel("Enter age:");
        agePrompt.setBounds(50,175, 200,30);
        mainPanel.add(agePrompt);

        // Keep count of users
//        numberOfUsers = new JLabel("Total users: " + totalUsers);
//        numberOfUsers.setBounds(300, 170, 200, 50);
//        numberOfUsers.setFont(buttonFont);
//        mainPanel.add(numberOfUsers);

        // Create create staff button object
        createStaffMember = new JButton("Create member".toUpperCase());
        createStaffMember.addActionListener(this);
        createStaffMember.setBackground(darkBlue);
        createStaffMember.setFont(buttonFont);
        createStaffMember.setForeground(white);
        buttonPanel.add(createStaffMember, BorderLayout.CENTER);

        // Create a return home button object
        returnToHome = new JButton("Return to homepage".toUpperCase());
        returnToHome.addActionListener(this);
        returnToHome.setBackground(darkBlue);
        returnToHome.setForeground(white);
        returnToHome.setFont(buttonFont);
        buttonPanel.add(returnToHome, BorderLayout.EAST);

        // Create the combobox for person type
        String[] personType = {"Teacher","Admin", "Student"};
        schoolMemberType = new JComboBox(personType);
        schoolMemberType.setBounds(300,100,200,30);
        mainPanel.add(schoolMemberType);

        // Create textinput objects
        enterFirstName = new JTextField();
        enterFirstName.setBounds(50,100,200,30);
        mainPanel.add(enterFirstName);
        enterLastName= new JTextField();
        enterLastName.setBounds(50, 150,200,30);
        mainPanel.add(enterLastName);
        enterAge = new JTextField();
        enterAge.setBounds(50,200,200,30);
        mainPanel.add(enterAge);

        // Create the area which returns the new values set by the account creation
        nameValue = new JTextArea();
        nameValue.setEditable(false);
        nameValue.setBounds(50, 250, 480, 130);
        mainPanel.add(nameValue);

        // Show the frame
        frame.setVisible(true);
    }


    // Determines which kind of account is to be made
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createStaffMember)
        {

            switch (schoolMemberType.getSelectedIndex()) {
                case 0:
                    // Teacher acc
                    try{
                        Teacher teacher = new Teacher(enterFirstName.getText(), enterLastName.getText(),
                                Integer.parseInt(enterAge.getText()), false);

                    nameValue.setText(String.format("%s: %ssuccessfully created!\n" +
                            "%sYour institute number is: %s",
                            teacher.position, teacher.getNames(), teacher.getEmail(), teacher.getInstituteNumber()));
                        teacher.submitToDatabase();
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                    break;
                case 1:
                    // Admin acc
                    try {
                        Admin admin = new Admin(enterFirstName.getText(), enterLastName.getText(),
                                Integer.parseInt(enterAge.getText()));
                        nameValue.setText(String.format("%s: %ssuccessfully created!\n" +
                                        "%sYour institute number is: %s",
                                admin.position, admin.getNames(), admin.getEmail(), admin.getInstituteNumber()));
                    } catch (SQLException throwables)
                    {
                        throwables.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        // Student acc
                        Student student = new Student(enterFirstName.getText(), enterLastName.getText(),
                                Integer.parseInt(enterAge.getText()));
                        nameValue.setText(String.format("%s: %ssuccessfully created!\n" +
                                        "%sYour institute number is: %s",
                                student.position, student.getNames(), student.getEmail(), student.getInstituteNumber()));
                    }catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                    break;
            }
        }

        // Returns the user back to the home directory
        if (e.getSource() == returnToHome)
        {
            frame.dispose();
            Directory run = new Directory();
        }
    }
}
