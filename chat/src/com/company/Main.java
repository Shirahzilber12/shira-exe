package com.company;

import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

public class Main {

    public static final String SERVER = "127.0.0.1";
    private static final int PORT = 3000;

    public static void main(String[] args) {
	// write your code here  
        
}
    private static int sendToServer(int action, int firstOperand, int secondOperand) throws Exception {
        byte[] xBytes = new byte[4];
        byte[] yBytes = new byte[4];
        ByteBuffer.wrap(xBytes).putInt(firstOperand);
        ByteBuffer.wrap(yBytes).putInt(secondOperand);

        Socket socket = null;
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try{
            socket = new Socket(SERVER, PORT);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            outputStream.write(action);
            outputStream.write(xBytes);
            outputStream.write(yBytes);
            byte[] resultBytes = new byte[4];
            int actuallyRead = inputStream.read(resultBytes);
            if(actuallyRead != 4)
                throw new Exception("something went wrong with the server");
            else{
                int result = ByteBuffer.wrap(resultBytes).getInt();
                return result;
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
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
            if(socket != null)
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        throw new Exception("something went wrong with the server");
    }
    private static void printMainMenu() {
        System.out.println("1: log in :");
        System.out.println("2: log out ");
        System.out.println("3: Register");
    }

}
