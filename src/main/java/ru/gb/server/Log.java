package ru.gb.server;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Log {
    public void saveLog(String text) {

        try {
            FileWriter fw = new FileWriter("E:\\Документы\\Андрей\\Обучение\\GeekBrains\\java\\Java Development Kit\\Chat\\src\\main\\java\\ru\\gb\\log\\log.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(text);
            bw.newLine();
            bw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
