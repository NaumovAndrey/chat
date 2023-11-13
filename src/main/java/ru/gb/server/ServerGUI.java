package ru.gb.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ServerGUI extends JFrame {
    public static final int POSITION_X = 800;
    public static final int POSITION_Y = 300;
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 500;

    JButton btnExit;
    JToggleButton btnStart;
    JTextArea textArea;

    public ServerGUI() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Server");
        setResizable(true);
        setLocation(POSITION_X, POSITION_Y);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        btnStart = new JToggleButton("Включить");
        btnStart.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (btnStart.isSelected()) {
                    btnStart.setText("Отключить");
                } else {
                    btnStart.setText("Включить");
                }
            }
        });

        btnExit = new JButton("Выход");

        JPanel panBotton = new JPanel(new GridLayout(1, 2));
        panBotton.add(btnStart);
        panBotton.add(btnExit);
        add(panBotton, BorderLayout.SOUTH);

        setVisible(true);
    }


}
