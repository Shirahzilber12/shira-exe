package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


public class Menu {

    public static final String encryption = "1";
    public static final String decryption = "2";
    public static final String EXIT = "0";
    static UserInterface userInterface;

    public static void start() {
        String select ="";
        userInterface.output("please enter your choice:");
        userInterface.output("1: encryption  \n2: decryption   \n0: exit");
        select = userInterface.input();
        menu(select);
    }


    static void menu(String mySelect) {
        switch (mySelect) {
            case encryption:
                File file =getFile();
                Random random = new Random(System.currentTimeMillis());
                int key = random.nextInt(255);
                userInterface.output("Your key is: " + key);
                Algorithm encryption=new Caesar();
                encryption.encryption(file,key);
                userInterface.output("your encryption succeed ");
                start();
                break;
            case decryption:
                File file1 =getFile();
                int myKey = insertKey();
                Algorithm decryption=new Caesar();
                decryption.decryption(file1,myKey);
                userInterface.output("your decryption succeed ");
                start();
                break;
            case EXIT:
                userInterface.output("bye bye");;
                break;
            default:
                userInterface.output("incorrect option");
                start();
        }
    }
    static int insertKey(){
        int key = 0;
        try {
            userInterface.output("please enter your key");
            String keyTemp = scan();
            key = Integer.parseInt(keyTemp);
        }
        catch (NumberFormatException e){
            userInterface.output("you not enter num ");
            insertKey();
        }
        return key;
    }




    public static MyFile getFile() {
        userInterface.output("enter your path");
        MyFile myFile = new MyFile(userInterface.input());
        while (!myFile.check(myFile))
        {
        userInterface.output("enter your path");
        myFile = new MyFile(userInterface.input());
            getFile();
        }
        return myFile;
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

    public interface UserInterface {
        void output(String s);
        String input();
    }




}