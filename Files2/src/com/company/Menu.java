package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

import static java.awt.SystemColor.menu;


public class Menu {

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
            case "1":
                File file =getFile();
                Random random = new Random(System.currentTimeMillis());
                int key = random.nextInt(255);
                userInterface.output("Your key is: " + key);
                Operation encryption=new Caesar();
                encryption.encryption(file,key);
                userInterface.output("your encryption succeed ");
                start2();
                break;
            case "2":
                //פענוח
                File file1 =getFile();
                int myKey = insertKey();
                Operation decryption=new Caesar();
                decryption.decryption(file1,myKey);
                userInterface.output("your decryption succeed ");
                start2();
                break;
            case "0":
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


    public static void start2(){
        userInterface.output("Press 1 to return to main menu");
        String answer = userInterface.input();

        if(answer.equals("1"))
            start();
        else
        userInterface.output("bye bye");
    }

    public static MyFile getFile() {

        userInterface.output("enter your path");
        MyFile myFile = new MyFile(userInterface.input());
        if (!myFile.check(myFile)){
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