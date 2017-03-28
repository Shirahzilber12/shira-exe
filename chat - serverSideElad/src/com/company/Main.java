package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static final int PORT = 3000;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(PORT);
            List<String> messages = new ArrayList<>();
            while(true){
                System.out.println("waiting for incoming communication...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("client connected");
                ClientThread clientThread = new ClientThread(clientSocket, messages);
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}