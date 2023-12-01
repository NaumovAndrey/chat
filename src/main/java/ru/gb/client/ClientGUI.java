package ru.gb.client;

import ru.gb.server.Log;
import ru.gb.server.SettingsServerGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class ClientGUI extends JFrame {
    //region Константы, размеры окна
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 500;
    //endregion

    //region Пременные, кнопки
    SetingsClientGUI setingsClientGUI;
    JTextField userTextField;
    JButton btnSendMessage;
    JButton btnOptions;
    static JTextArea textArea;

    //endregion

    public ClientGUI() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Client");
        setResizable(true);
        //setLocationRelativeTo(null);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        //region Окно настроек сервера (ip,  port).
        setingsClientGUI = new SetingsClientGUI(this);
        setingsClientGUI.setVisible(true);
        //endregion

        //region Кнопка "Опции" выводит окно настроек сервера
        btnOptions = new JButton("Опции");

        JPanel panelSetings = new JPanel(new BorderLayout());
        panelSetings.add(btnOptions, BorderLayout.WEST);
        add(panelSetings, BorderLayout.NORTH);

        btnOptions.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setingsClientGUI.setVisible(true);
            }
        });
        //endregion

        //region Текстовое поле. Ввод с клавиатуры запрещён.
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);
        add(scrollPane);
        //endregion

        //region кнопка отправить сообщение и поле ввода сообщения
        btnSendMessage = new JButton("Отправить");
        userTextField = new JTextField();

        JPanel messageSendingPanel = new JPanel(new BorderLayout());
        messageSendingPanel.add(userTextField, BorderLayout.CENTER);
        messageSendingPanel.add(btnSendMessage, BorderLayout.EAST);
        add(messageSendingPanel, BorderLayout.SOUTH);

        btnSendMessage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        //endregion

        setVisible(false);
    }
    public void sendMessage(){
        if (!userTextField.getText().isEmpty()){
            appendLog(userTextField.getText());

            new Log().saveLog(userTextField.getText());
        }
    }

    public static void appendLog(String text) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        String message = currentDateTime.toString();
        textArea.append("[" + message + "] "  + text + "\n");
    }
}
