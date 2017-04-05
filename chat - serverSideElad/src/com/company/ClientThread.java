package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by eladlavi on 08/03/2017.
 */
public class ClientThread extends Thread {

    Socket clientSocket;
    InputStream inputStream;
    OutputStream outputStream;
    public static final int PORT = 3000;
    public static final int SEND_MESSAGE = 100;
    public static final int GET_MESSAGES = 101;
    public static final int OKAY = 90;
    public static final int SIGN_UP = 102;
    public static final int LOGIN = 103;
    public static final String SERVER_IP = "127.0.0.1";

    public ClientThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            inputStream = clientSocket.getInputStream();
            outputStream = clientSocket.getOutputStream();
            clientSocket = new Socket(SERVER_IP,PORT);
            int action  = inputStream.read();
            switch (action){
                case SIGN_UP:
                    signUp();
                    break;
                case LOGIN:
                    login();
                    break;
                case GET_MESSAGES:
                    getMessage();
                    break;
                case SEND_MESSAGE:
                    sendMessage();
                    break;

            }



        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(outputStream != null)
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if(clientSocket != null)
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

    private void sendMessage() {

    }

    private void getMessage(InputStream inputStream) throws IOException {
        //int  lengthUserName = inputStream.read();





        }





    private void login() {
    }

    private void signUp() {
    }


}