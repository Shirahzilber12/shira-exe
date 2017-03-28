package com.company;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/**
 * Created by eladlavi on 28/03/2017.
 */
public class ClientThread extends Thread {

    public static final int SEND_MESSAGE = 100;
    public static final int GET_MESSAGES = 101;
    public static final int OKAY = 90;
    public static final int SIGN_UP = 102;
    public static final int LOGIN = 104;
    public static final int LOGIN = 103;
    private Socket clientSocket;
    private InputStream inputStream;
    private OutputStream outputStream;
    private List<String> messages;
    private Map<String,String> users;

    public ClientThread(Socket clientSocket, List<String> messages) {
        this.clientSocket = clientSocket;
        this.messages = messages;
    }

    @Override
    public void run() {
        try {
            inputStream = clientSocket.getInputStream();
            outputStream = clientSocket.getOutputStream();
            int action = inputStream.read();
            switch (action){
                case SEND_MESSAGE:
                    sendMessage();
                    break;
                case GET_MESSAGES:
                    getMessages();
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

    private void sendMessage() throws IOException {
        int messageLength = inputStream.read();
        if(messageLength == -1)
            return;
        byte[] messageBytes = new byte[messageLength];
        int actuallyRead = inputStream.read(messageBytes);
        if(actuallyRead != messageLength)
            return;
        String message = new String(messageBytes);
        messages.add(message);
        outputStream.write(OKAY);
    }

    private void getMessages() throws IOException {
        byte[] messageFromBytes = new byte[4];
        int actuallyRead = inputStream.read(messageFromBytes);
        if(actuallyRead != 4)
            return;
        int messageFrom = ByteBuffer.wrap(messageFromBytes).getInt();
        for (int i = messageFrom; i < messages.size(); i++) {
            String message = messages.get(i);
            byte[] messageBytes = message.getBytes();
            outputStream.write(messageBytes.length);
            outputStream.write(messageBytes);
        }
    }
}