package com.gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Directory implements ActionListener {

    // Initialise variables
    JFrame frame;
    JPanel mainPanel, titlePanel;
    JLabel title, image;
    ImageIcon imageIcon;
    Border raised;
    JButton registerUser, setPass, findUser;
    Color darkBlue, white, darkRed, darkGreen;
    GridBagLayout mainPanelLayout;
    GridBagConstraints c;
    Font titleFont, buttonFont;

    public Directory()
    {

        // Create style elements
        raised = BorderFactory.createRaisedBevelBorder();
        darkBlue = new Color(10,10,49);
        darkGreen = new Color(10,49,10);
        darkRed = new Color(49,10,10);
        white = new Color(240,240,240);
        titleFont = new Font("Helvetica", Font.BOLD, 31);
        buttonFont = new Font("Helvetica", Font.BOLD, 22);

        // Set the layout parameters
        mainPanelLayout = new GridBagLayout();
        c = new GridBagConstraints();

        // Create the frame
        frame = new JFrame("Blank School");
        frame.setBounds(200,200,500,270);
        frame.setResizable(false);

        // Add main panel to the frame
        mainPanel = new JPanel();
        mainPanel.setLayout(mainPanelLayout);
        frame.add(mainPanel);

        // Add title panel to the frame
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        titlePanel = new JPanel();
        titlePanel.setBorder(raised);
        titlePanel.setBackground(darkBlue);
        mainPanel.add(titlePanel, c);

        // Add a label to the title panel
        title = new JLabel("Welcome to blank school".toUpperCase());
        title.setForeground(white);
        title.setFont(titleFont);
        titlePanel.add(title);

        // Add the image to the left hand side of the screen
        c.gridwidth = 1;
        c.gridheight = 3;
        c.gridy = 1;
        imageIcon = new ImageIcon("src/com/images/GillinghamSchool.jpg");
        image = new JLabel(imageIcon);
        mainPanel.add(image, c);

        // Create the register button and add it to the panel
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 20;
        c.gridheight = 1;
        c.gridx = 1;
        registerUser = new JButton("Register A New User");
        registerUser.setBackground(darkRed);
        registerUser.setForeground(white);
        registerUser.setFont(buttonFont);
        mainPanel.add(registerUser, c);

        // Create the findUser button and add it to the panel
        c.gridy = 2;
        findUser = new JButton("Find a user");
        findUser.setBackground(darkGreen);
        findUser.setForeground(white);
        findUser.setFont(buttonFont);
        mainPanel.add(findUser, c);

        // Create the set password button and add it to the panel
        c.gridy = 3;
        setPass = new JButton("Set Password");
        setPass.setBackground(darkBlue);
        setPass.setForeground(white);
        setPass.setFont(buttonFont);
        mainPanel.add(setPass, c);

        // Add action listeners to the button objects
        registerUser.addActionListener(this);
        setPass.addActionListener(this);
        findUser.addActionListener(this);

        // Set the frame to visible
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
        if (e.getSource() == registerUser)
        {
            try {
                RegisterUser run = new RegisterUser();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        else if (e.getSource() == setPass)
        {
            SetPassword run = new SetPassword();
        }
        if (e.getSource() == findUser)
        {
          FindUser run = new FindUser();
        }
    }
}
