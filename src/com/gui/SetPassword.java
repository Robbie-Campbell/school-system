package com.gui;

import com.SQLQueries.AddPasswordToUser;
import com.SQLQueries.GetUsersOfType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class SetPassword implements ActionListener {

    JFrame frame;
    JPanel mainPanel;
    JComboBox typeOfUser, users;
    JLabel enterNewPass;
    JTextField newPassword;
    JButton submit;

    public SetPassword()
    {

        // Create the frame to create account
        frame = new JFrame("Set Account Password");
        frame.setResizable(false);
        frame.setBounds(200,200,300,400);

        // Create mainpanel
        mainPanel = new JPanel();
        frame.add(mainPanel);

        // Create table type combobox
        String[] tableTitle = {"teacher", "admin", "student"};
        typeOfUser = new JComboBox(tableTitle);
        typeOfUser.addActionListener(this);
        mainPanel.add(typeOfUser);

        // Create default users combobox
        users = new JComboBox();
        users.addItem("Please select a user type");
        users.setEnabled(false);
        users.addActionListener(this);
        mainPanel.add(users);

        // Create password prompt
        enterNewPass = new JLabel("Please enter your new password: ");
        mainPanel.add(enterNewPass);

        // Add the password input area
        newPassword = new JTextField();
        newPassword.setColumns(20);
        mainPanel.add(newPassword);

        // Create password button
        submit = new JButton("Submit new password");
        submit.addActionListener(this);
        submit.setEnabled(false);
        mainPanel.add(submit);

        // Make frame visible
        frame.setVisible(true);
    }

    // Update the users available to be edited in the combo box
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == typeOfUser)
        {
            users.removeAllItems();
            users.setEnabled(true);
            try
            {
                GetUsersOfType allUsersOfType = new GetUsersOfType((String) typeOfUser.getSelectedItem());
                for (int i = 0; i < allUsersOfType.getResult().size(); i++)
                {
                    users.addItem(allUsersOfType.getResult().get(i));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        // Allow the submit button to be interactive
        else if (e.getSource() == users)
        {
            submit.setEnabled(true);
        }

        // Put it in the database
        else if (e.getSource() == submit)
        {
            try {
                String[] names = String.valueOf(users.getSelectedItem()).split(" ");
                AddPasswordToUser submitToDB = new AddPasswordToUser((String) typeOfUser.getSelectedItem(),
                    newPassword.getText(), names[0], names[1]);
            } catch (SQLException | NoSuchAlgorithmException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}
