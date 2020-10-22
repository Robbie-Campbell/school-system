package com.gui;

import com.SQLQueries.SearchForUser;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class FindUser implements ActionListener {
    JFrame frame;
    JPanel mainPanel, resultPanel, buttonPanel;
    JTextArea result;
    JLabel inputPrompt;
    JComboBox searchType, positionType;
    JTextField searchArea;
    JButton search, returnToHome;
    Border raised;
    Color darkBlue, white, darkRed, darkGreen;
    Font titleFont, buttonFont;

    public FindUser()
    {
        // Create style elements
        raised = BorderFactory.createRaisedBevelBorder();
        darkBlue = new Color(10,10,49);
        darkGreen = new Color(10,49,10);
        darkRed = new Color(49,10,10);
        white = new Color(240,240,240);
        titleFont = new Font("Helvetica", Font.BOLD, 31);
        buttonFont = new Font("Helvetica", Font.BOLD, 18);

        // Create a frame
        frame = new JFrame("Find A User");
        frame.setResizable(false);
        frame.setBounds(200,200,300,400);

        // Add the panel to the frame
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        frame.add(mainPanel);

        // Create a panel for the results
        resultPanel = new JPanel();
        resultPanel.setBounds(0,0,300,100);
        resultPanel.setLayout(null);
        mainPanel.add(resultPanel);

        // Create a panel for the buttons
        buttonPanel = new JPanel();
        buttonPanel.setBounds(0,290,284,70);
        buttonPanel.setLayout(new BorderLayout(0,0));
        buttonPanel.setBorder(raised);
        mainPanel.add(buttonPanel);

        // Create the result label
        result = new JTextArea("");
        result.setBounds(0,0,290,80);
        result.setEditable(false);
        resultPanel.add(result);

        // Create the textfield
        searchArea = new JTextField();
        searchArea.setBounds(10,130, 270,30);
        mainPanel.add(searchArea);

        // Create the label for prompting user input
        inputPrompt = new JLabel("Search for user by first name");
        inputPrompt.setBounds(10,100,270,30);
        mainPanel.add(inputPrompt);

        // Create the combobox for search parameter
        String[] searchParameter = {"first_name","last_name", "age", "institute_number", "email", "position", "role"};
        searchType = new JComboBox(searchParameter);
        searchType.setBounds(10,170,270,30);
        searchType.addActionListener(this);
        mainPanel.add(searchType);

        // Create the combobox
        String[] position = {"teacher","student", "admin"};
        positionType = new JComboBox(position);
        positionType.setBounds(10,210,270,30);
        mainPanel.add(positionType);

        // Create the button to search and add event listeners
        search = new JButton("Search for user");
        search.addActionListener(this);
        search.setFont(buttonFont);
        search.setBackground(darkBlue);
        search.setForeground(white);
        buttonPanel.add(search, BorderLayout.NORTH);

        // Create the button to return to the directory
        returnToHome = new JButton("Return home");
        returnToHome.addActionListener(this);
        returnToHome.setFont(buttonFont);
        returnToHome.setBackground(darkGreen);
        returnToHome.setForeground(white);
        buttonPanel.add(returnToHome, BorderLayout.SOUTH);

        // Show the frame
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == search)
        {
            try {
                SearchForUser sfu = new SearchForUser(searchArea.getText(), searchType.getSelectedItem().toString(),
                        positionType.getSelectedItem().toString());
                result.setText(sfu.returnValue);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        else if (e.getSource() == searchType)
        {
            inputPrompt.setText("Search for user by " + searchType.getSelectedItem().toString().toLowerCase());
        }
        else if (e.getSource() == returnToHome)
        {
            frame.dispose();
            Directory home = new Directory();
        }
    }
}