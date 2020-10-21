package com.gui;

import javax.swing.*;

public class GetUser {
    JFrame frame;
    JLabel showAllUsers;
    JButton getAllusers;


    public GetUser()
    {
        frame = new JFrame("Login to account");
        frame.setResizable(false);
        frame.setBounds(200,200,300,400);


        frame.setVisible(true);
    }
}
