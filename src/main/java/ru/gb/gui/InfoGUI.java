package ru.gb.gui;

import javax.swing.*;

public class InfoGUI extends JPanel{

    public InfoGUI(String message) {
        JLabel infoLabel = new JLabel(message);
        add(infoLabel);
    }
}
