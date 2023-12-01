package ru.gb.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    void connectClient(){
        try {
            ServerSocket serverSocket = new ServerSocket(8080); // Создание серверного сокета

            Socket clientSocket = serverSocket.accept(); // Ожидание подключения клиента

            BufferedReader inputFromClient = new BufferedReader(new InputStreamReader(((Socket) clientSocket).getInputStream()));

            String clientText = inputFromClient.readLine();
            System.out.println("Получено от клиента: " + clientText);


            PrintWriter outputToClient = new PrintWriter(clientSocket.getOutputStream(), true);
            outputToClient.println("Привет, клиент!");

            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
