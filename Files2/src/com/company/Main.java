package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;

public class Main {


    public static void main(String[] args) {
	// write your code here

        Menu.userInterface = new Menu.UserInterface() {
            @Override
            public void output(String s) {
                System.out.println(s);
            }

            @Override
            public String input() {
                return scan();
            }
        };

        //Menu.start();
//        byte number = 20;
//        number = (byte)((int)number+150);
//        System.out.println("the num before"+ number);
//        number = (byte)((int)number-150);
//        System.out.println("num after"+number);

    }
    static String scan() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
