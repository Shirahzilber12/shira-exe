package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import static java.awt.SystemColor.menu;


public class Menu {

    public static void start() {
        String select ="";
        Scanner s = new Scanner(System.in);
        System.out.println("please enter your choose:");
        System.out.println("1: encryption file \n2: decryption file  ");
        select = s.next();
        menu(select);
    }

    private static void menu(String mySelect) {
        try {
            switch (Integer.parseInt(mySelect)) {
                case 1:
                    getFile();
                    Encryption.encryption();
                    start2();
                    break;
                case 2:
                    getFile();
                    Decryption.decryption();
                    start2();
                    break;
                default:
                    System.out.println("מס לא נכון ");
                    start();
            }
        }
        catch (Exception e){
            System.out.println("הקשת תו לא נכון ");
            start();
        }
    }
    private static void start2(){
        System.out.println("if you have more files you want to test press 1");
        Scanner s=new Scanner(System.in);
        int answer=s.nextInt();
        if(answer==1)
            start();
        System.out.println("bye bye");
    }
    public static void getFile() {
        Scanner s=new Scanner(System.in);
        MyFile myFile = new MyFile("");
        while (myFile.check()) {
            System.out.println("enter your path");
            myFile = new MyFile(s.next());

        }
    }
}
