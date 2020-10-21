package com.gui;

import com.models.Admin;
import com.models.Student;
import com.models.Teacher;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterUser implements ActionListener {

    // Initialise variables
    JFrame frame;
    JPanel mainPanel, titlePanel, buttonPanel;
    Border raised;
    JLabel title, memberPrompt, nameValue, firstNamePrompt, lastNamePrompt, agePrompt;
    JComboBox schoolMemberType;
    JTextField enterFirstName, enterLastName, enterAge;
    JButton createStaffMember, returnToHome;
    Color darkBlue, white, darkRed, darkGreen;
    Font titleFont, buttonFont;

    public RegisterUser ()
    {

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
        memberPrompt.setBounds(300, 70, 200, 50);
        mainPanel.add(memberPrompt);
        nameValue = new JLabel("");
        nameValue.setBounds(50,300,500,60);
        mainPanel.add(nameValue);

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


        // Create button object
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
        schoolMemberType.setBounds(300,110,100,30);
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
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == createStaffMember)
        {
            switch (schoolMemberType.getSelectedIndex()) {
                case 0:
                    Teacher teacher = new Teacher(enterFirstName.getText(), enterLastName.getText(),
                            Integer.parseInt(enterAge.getText()), false);
                    nameValue.setText(String.format("%s: %s successfully created!", teacher.position, teacher.getNames()));
                    System.out.println(teacher.getEmail());
                    break;
                case 1:
                    Admin admin = new Admin(enterFirstName.getText(), enterLastName.getText(),
                            Integer.parseInt(enterAge.getText()));
                    nameValue.setText(String.format("%s: %s successfully created!", admin.position, admin.getNames()));
                    System.out.println(admin.getEmail());
                    break;
                case 2:
                    Student student = new Student(enterFirstName.getText(), enterLastName.getText(),
                            Integer.parseInt(enterAge.getText()));
                    nameValue.setText(String.format("%s: %s successfully created!", student.position, student.getNames()));
                    System.out.println(student.getEmail());
                    break;
            }
        }

        if (e.getSource() == returnToHome)
        {
            frame.dispose();
            Directory run = new Directory();
        }
    }
}
