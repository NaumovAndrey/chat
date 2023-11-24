package ru.gb.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class ServerGUI extends JFrame {
    //region Константы
    public static final int POSITION_X = 800;
    public static final int POSITION_Y = 300;
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 500;
    //endregion

    SettingsServerGUI settingsServerGUI;

    static JTextArea textArea;
    JButton btnSetings;


    public ServerGUI() throws HeadlessException {
        // TODO: 15.11.2023 как изменить кнопку при закрытии окна,т.е. отключить сервер в настройках и  отправить сообщение всем пользователям, что сервер недоступен 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Server");
        setResizable(true);
        setLocation(POSITION_X, POSITION_Y);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        //region Окно настроек сервера (ip,  port).
        settingsServerGUI = new SettingsServerGUI(this);
        settingsServerGUI.setVisible(true);
        //endregion

        //region Текстовое поле. Ввод с клавиатуры запрещён.
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);
        textArea.setEditable(false);
        //endregion

        //region Кнопка "Опции" выводит окно настроек сервера
        btnSetings = new JButton("Опции");
        add(btnSetings, BorderLayout.SOUTH);

        btnSetings.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsServerGUI.setVisible(true);
            }
        });
        //endregion

        setVisible(false);
    }

    public static void appendLog(String text) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        String message = currentDateTime.toString();
        textArea.append("[" + message + "]" + text + "\n");
    }

    // TODO: 15.11.2023 создать кнопку настройки (открыть окно настроек данного подключения) 
}
