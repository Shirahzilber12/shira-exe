package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;


public class Menu {

    public static final String encryption = "1";
    public static final String decryption = "2";
    public static final String EXIT = "0";
    public static final String Caesar = "a";
    public static final String XorAlgorithm = "b";
    public static final String ReversAlgorithm = "c";

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
                if (Factory.flag)
                encryptionFunction();
                else
                    decryptionFunction();
                break;
            case decryption:
                if (Factory.flag)
                    decryptionFunction();
                else
                    encryptionFunction();
                break;
            case EXIT:
                userInterface.output("bye bye");;
                break;
            default:
                userInterface.output("incorrect option");
                start();
        }
    }

    private static void encryptionFunction() {
        File file =getFile();
        Algorithm algorithm = basicOperation();
        Key key = new KeyRandom();
        userInterface.output("Your key is: " + key.typeOfKeyKey());
        algorithm.encryption(file,key.typeOfKeyKey());
        userInterface.output("your encryption succeed ");
        start();
    }

    private static void decryptionFunction() {
        File file1 =getFile();
        Algorithm algorithm1 = basicOperation();
        int myKey = insertKey();
        algorithm1.decryption(file1,myKey);
        userInterface.output("your decryption succeed ");
        start();
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
     static Algorithm basicOperation(){
        Factory factory = new Factory();
        userInterface.output("choice types of cipher \n 1:caesar \n 2:xorAlgorithm \n 3:multiplicationAlgorithm");
        Algorithm algorithm = factory.chooseAlgorithm(userInterface.input());
        return algorithm;
    }


    public static MyFile getFile() {
        userInterface.output("enter your path");
        MyFile myFile = new MyFile(userInterface.input());
        while (!myFile.check(myFile)) {
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