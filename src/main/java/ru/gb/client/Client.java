package ru.gb.client;

import ru.gb.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class Client implements ClientView {
    private User user;
    private boolean connected;
    private Server server;
    private final ClientView clientView;
    Socket socket;

    public Client(ClientView clientView) {
        this.clientView = clientView;
    }

    public boolean connectToServer(User user) throws IOException {
        this.user = user;
        try {
            Socket socket = new Socket("localhost", 8080);
            PrintWriter outputToServer = new PrintWriter(socket.getOutputStream(), true);
            outputToServer.println("Привет, сервер!");

            BufferedReader inputFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverResponse = inputFromServer.readLine();


            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // TODO: 29.11.2023 Подключение к серверу
        return true;
    }

    public void sendMessage(String message) {
        showMessage(message);
        // TODO: 29.11.2023 Метод отправки сообщения 01.47
    }

    public void serverAnswer(String answer) {
        // TODO: 29.11.2023 сообщение от сервера
    }

    public void disconnect() {
        // TODO: 29.11.2023 отключение от сервера
    }

    public String getUser() {
        return user.getLogin();
    }

    private void printText(String text) {
        clientView.showMessage(text);
    }

    @Override
    public void showMessage(String text) {

    }
}
