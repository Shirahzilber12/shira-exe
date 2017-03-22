package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;


public class Menu implements AlgorithmOperation.Listener ,UserInterface {

    public static final String ENCRYPTION = "1";
    public static final String DECRYPTION = "2";
    public static final String EXIT = "0";

    Factory factory ;
    File file ;

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

        Algorithm algorithm = chooseOption();
        /*if(algorithm == null) {
            output("your choose is not correct,please enter again");
            algorithm =chooseOption();
        }*/
        file = getFilePath();
        int key = RandomKey.randomKey();
        output("Your key is: " + key);
        algorithm.encryption(file, key);
        output("your encryption succeed ");
        menu();
    }

    private void decryption() {
        Algorithm algorithm = chooseOption();
        file = getFilePath();
        int myKey = insertKey();
        algorithm.decryption(file, myKey);
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

    /*private Algorithm chooseOption(){
        output("1: caesar Algorithm\n2: Xor Algorithm\n3: Multiplication Algorithm\n4: ReversAlgorithm");
        String choice = input();
        factory = new Factory();
        if(choice.equals("4")){
            return chooseRevers();
        }
        else
            //output("your choose is not correct,please enter again");
            return factory.chooseAlgorithm(choice);
    }
     Algorithm chooseRevers(){
        output("you need to choose type of reverse:\n1: caesar Algorithm\n2: Xor Algorithm\n3: Multiplication Algorithm");
        return factory.chooseRevers(input());}
*/
    private Algorithm chooseOption(){
        output("1: caesar Algorithm\n2: Xor Algorithm\n3: Multiplication Algorithm\n4: ReversAlgorithm");
        String choice = input();
        factory = new Factory();
        switch (choice){
            case "1":
                return factory.chooseAlgorithm(choice);
            case "2":
                return factory.chooseAlgorithm(choice);
            case "3":
                return factory.chooseAlgorithm(choice);
            case "4":
                output("you need to choose type of reverse:\n1: caesar Algorithm\n2: Xor Algorithm\n3: Multiplication Algorithm");
                return factory.chooseRevers(input());
            default: {
                output("your choose is not correct,please enter again");
                return chooseOption();}

        }
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