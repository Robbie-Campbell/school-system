package com.school;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;

public class Main implements ActionListener {

	// Initialise variables
	JFrame frame;
	JPanel mainPanel;
	Border raised;
	JLabel memberPrompt, nameValue, firstNamePrompt, lastNamePrompt, agePrompt;
	JComboBox schoolMemberType;
	JTextField enterFirstName, enterLastName, enterAge;
	JButton createStaffMember;

	public Main()
	{

		// Create the frame object
		frame = new JFrame("School Project");
		frame.setResizable(false);
		frame.setBounds(200,200,600,500);

		// Create the style objects
		raised = BorderFactory.createRaisedBevelBorder();

		// Add the panel to the frame
		mainPanel = new JPanel();
		mainPanel.setBorder(raised);
		mainPanel.setLayout(null);
		frame.add(mainPanel);

		// Create the label objects
		memberPrompt = new JLabel("Enter school member type:");
		memberPrompt.setBounds(300, 70, 200, 50);
		mainPanel.add(memberPrompt);
		nameValue = new JLabel("");
		nameValue.setBounds(50,300,500,50);
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
		createStaffMember = new JButton("Create member");
		createStaffMember.setBounds(350,400,200,30);
		createStaffMember.addActionListener(this);
		mainPanel.add(createStaffMember);

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

	@Override
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
	}

    public static void main(String[] args) throws NoSuchAlgorithmException {
    	Main run = new Main();
    }

}
