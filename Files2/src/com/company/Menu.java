package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static java.awt.SystemColor.menu;


public class Menu {

    static UserInterface userInterface;

    public static void start() {
        String select ="";
        userInterface.output("please enter your choice:");
        userInterface.output("1: encryption  \n2: decryption   \n3: exit");
        select = userInterface.input();
        menu(select);
    }


    static void menu(String mySelect) {
        switch (mySelect) {
            case "1":
                getFile();
                Encryption.encryptionCaesar();
                start2();
                break;
            case "2":
                getFile();
                Decryption.decryption();
                start2();
                break;
            case "3":
                userInterface.output("bye bye");;
                break;
            default:
                userInterface.output("incorrect option");
                start();
        }
    }


    public static void start2(){
        userInterface.output("if you have more files you want to test press 1");
        String answer = userInterface.input();
        int num = Integer.parseInt(answer);
        if(num == 1)
            start();
        else
        System.out.println("bye bye");
    }
    //C:\Users\hackeru.HACKERU3\Documents\GitHubC:\Users\hackeru.HACKERU3\Documents\GitHub\Int.txt
    public static void getFile() {
        MyFile myFile = new MyFile("");
        userInterface.output("enter your path");
        myFile = new MyFile(userInterface.input());
        if (!myFile.check(myFile)){
            getFile();
        }
    }



    public interface UserInterface {
        void output(String s);
        String input();
    }


}