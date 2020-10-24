package com.gui;

import javax.swing.*;

public class SetPassword {

    JFrame frame;
    JPanel mainPanel;
    JComboBox users;

    public SetPassword()
    {

        // Create the frame to create account
        frame = new JFrame("Set Account Password");
        frame.setResizable(false);
        frame.setBounds(200,200,300,400);


        frame.setVisible(true);
    }
}
