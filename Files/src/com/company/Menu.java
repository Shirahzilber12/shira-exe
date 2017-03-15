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
public static void scan() {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    try {
        bufferedReader.readLine();
    } catch (IOException e) {
        e.printStackTrace();
    }
}

    static void menu(String mySelect) {
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


    public static void start2(){
        System.out.println("if you have more files you want to test press 1");
        Scanner s=new Scanner(System.in);
        int answer=s.nextInt();
        if(answer==1)
            start();
        System.out.println("bye bye");
    }
    //C:\Users\hackeru.HACKERU3\Documents\GitHubC:\Users\hackeru.HACKERU3\Documents\GitHub
    public static void getFile() {
        MyFile myFile = new MyFile("");
        System.out.println("enter your path");
        Scanner s=new Scanner(System.in);
        myFile = new MyFile(s.next());
        while (!myFile.check(myFile)) {
            getFile();
        }
    }
}