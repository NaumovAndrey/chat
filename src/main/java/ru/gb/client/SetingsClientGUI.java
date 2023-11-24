package ru.gb.client;

import ru.gb.Message;
import ru.gb.gui.InfoGUI;
import ru.gb.server.ServerGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class SetingsClientGUI extends JFrame  implements Message {

    //region Константы
    public static final int WINDOW_WIDTH = 500;
    public static final int WINDOW_HEIGHT = 180;
    //endregion

    JButton btnExit;
    JToggleButton btnStart;
    JTextField inputFieldIP;
    JTextField inputFieldPORT;
    JTextField inputFieldLogin;
    JPasswordField inputFieldPassword;

    public SetingsClientGUI(ClientGUI clientGUI) throws HeadlessException {
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Settings client");
        setLocationRelativeTo(clientGUI);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);

        //region Панель для ввода данных ip, port, login, password
        JPanel configurationPanel = new JPanel(new GridLayout(4, 2));

        configurationPanel.add(new InfoGUI("Введите ip: "));
        inputFieldIP = new JTextField(19);
        configurationPanel.add(inputFieldIP);

        configurationPanel.add(new InfoGUI("Введите PORT: "));
        inputFieldPORT =new JTextField(10);
        configurationPanel.add(inputFieldPORT);

        configurationPanel.add(new InfoGUI("Введите логин: "));
        inputFieldLogin = new JTextField(20);
        configurationPanel.add(inputFieldLogin);

        configurationPanel.add(new InfoGUI("Введите пароль: "));
        inputFieldPassword = new JPasswordField(15);
        configurationPanel.add(inputFieldPassword);

        add(configurationPanel, BorderLayout.WEST);
        //endregion

        //region Кнопка "Включить", запускает сервер. Название кнопки изменяется на отключить.
        btnStart = new JToggleButton("Подключить");
        btnStart.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (btnStart.isSelected()) {
                    btnStart.setText("Отключить");
                    clientGUI.setVisible(true);
                    readingMessage("Подключение к серверу");
                    setVisible(false);
                } else {
                    btnStart.setText("Включить");
                    readingMessage("Отключение от сервера");
                }
            }
        });
        //todo Реализовать действие по нажатию кнопки "Включить/выключить" (блокировать данные на изменение в окне настроек)
        //endregion

        //region Кнопка "Выход"
        btnExit = new JButton("Выход");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        //todo Реализовать действие (уведомление клиента "Статус ofline") по нажатию кнопки "выход"
        //endregion

        //region Панель.  Две кнопки "Выход и подключить/отключить"
        JPanel panBotton = new JPanel(new GridLayout(1, 2));
        panBotton.add(btnStart);
        panBotton.add(btnExit);
        add(panBotton, BorderLayout.SOUTH);
        //endregion
    }

    @Override
    public void readingMessage(String text) {
        ClientGUI.appendLog(text);
    }

}
