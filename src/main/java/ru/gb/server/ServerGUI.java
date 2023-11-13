package ru.gb.server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ServerGUI extends JFrame {
    //region Константы
    public static final int POSITION_X = 800;
    public static final int POSITION_Y = 300;
    public static final int WINDOW_WIDTH = 800;
    public static final int WINDOW_HEIGHT = 500;
    //endregion

    JButton btnExit;
    JToggleButton btnStart;
    JTextArea textArea;

    public ServerGUI() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Server");
        setResizable(true);
        setLocation(POSITION_X, POSITION_Y);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);

        //region Текстовое поле. Ввод с клавиатуры запрещён.
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);
        textArea.setEditable(false);
        //endregion

        //region Кнопка "Включить", запускает сервер. Название кнопки изменяется на отключить.
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
        //todo Реализовать действие по нажатию кнопки "Включить/выключить"
        //endregion

        //region Кнопка "Выход"
        btnExit = new JButton("Выход");
        //todo Реализовать действие по нажатию кнопки "выход"
        //endregion

        //region Создана панель, в панель добавлено две кнопки "Выход и подключить/отключить"
        JPanel panBotton = new JPanel(new GridLayout(1, 2));
        panBotton.add(btnStart);
        panBotton.add(btnExit);
        add(panBotton, BorderLayout.SOUTH);
        //endregion

        setVisible(true);
    }


}
