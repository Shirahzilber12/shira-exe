package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;


public class Menu implements AlgorithmOperation.Listener ,UserInterface {

    public static final String ENCRYPTION = "1";
    public static final String DECRYPTION = "2";
    public static final String EXIT = "0";

    Factory factory ;
    File file ;
    RandomKey randomKey;
    void menu() {
        output("please enter your choice:\n1: encryption  \n2: decryption   \n0: exit");
        switch (input()) {
            case ENCRYPTION:
                encryption();
                break;
            case DECRYPTION:
                    decryption();
                break;
            case EXIT:
                output("bye bye");
                return;
            default:
                output("incorrect option");
                menu();
        }
    }

    private void encryption() {
        DoubleAlgorithm doubleAlgorithm = doubleOption();
        file = getFilePath();
        randomKey = new RandomKey();
        int key1 = randomKey.key();
        int key2 = randomKey.key();
        output("Your key is: " + key1);
        output("Your key is: " + key2);
        doubleAlgorithm.setSecondKey(key2);
        doubleAlgorithm.encryption(file, key1);
        output("your encryption succeed ");
        menu();
    }

    private void decryption() {
        DoubleAlgorithm doubleAlgorithm =doubleOption();
        file = getFilePath();
        int myKey = insertKey();
        doubleAlgorithm.decryption(file, myKey);
        output("your decryption succeed ");
        menu();
    }

    int insertKey() {
        int key = 0;
        try {
            output("please enter your key");
            key = Integer.parseInt(input());
        } catch (NumberFormatException e) {
            output("you not enter num ");
            insertKey();
        }
        return key;
    }

    public File getFilePath() {
        output("enter your path");
        File myFile = new File(input());
        while (!checkFile(myFile)) {
            output("enter your path");
            myFile = new File(input());
        }
        return myFile;
    }

    boolean checkFile(File filePath) {
        if (filePath.exists()) {
            if (filePath.isFile())
                return true;
            else output("you not enter file");
        } else output("your path wrong");
        return false;

    }


       String chooseRevers(){
        output("you need to choose type of reverse:\n1: caesar Algorithm\n2: Xor Algorithm\n3: Multiplication Algorithm");
        return input();
    }

    private DoubleAlgorithm doubleOption(){
        output("choose algorithm \n1: xor & revers\n2: casar & mult");
        DoubleAlgorithm doubleAlgorithm = new DoubleAlgorithm();
        Factory factory = new Factory();
        switch (input()){
            case "1":
                doubleAlgorithm.setFirstAlgorithm(factory.chooseAlgorithm("2"));
                output("you need to choose type of reverse:\n1: caesar Algorithm\n2: Xor Algorithm\n3: Multiplication Algorithm");
                doubleAlgorithm.setSecondAlgorithm2(factory.chooseRevers(input()));
                break;
            case "2":
                doubleAlgorithm.setFirstAlgorithm(factory.chooseAlgorithm("1"));
                doubleAlgorithm.setSecondAlgorithm2(factory.chooseAlgorithm("3"));
               // DoubleAlgorithm doubleAlgorithm1 = factory.chooseAlgorithm("1"),factory.chooseAlgorithm("3");
                break;
        }
        return doubleAlgorithm;


    }

    @Override
    public void StartDetect() {
        output("the cipher is start \nthe time now is" + System.nanoTime());
    }

    @Override
    public void EndDetect() {
        output("the cipher is end \nthe time now is" + System.nanoTime());
    }

    @Override
    public void output(String s) {
        System.out.println(s);
    }

    @Override
    public String input() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}