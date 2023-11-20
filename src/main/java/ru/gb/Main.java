package ru.gb;

import ru.gb.server.ServerGUI;
import ru.gb.server.SettingsServerGUI;

public class Main {
    public static void main(String[] args) {
        new SettingsServerGUI(new ServerGUI());
    }
}