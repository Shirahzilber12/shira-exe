package com.company;

import java.io.*;
import java.util.Random;


public class Menu implements AlgorithmOperation.Listener ,UserInterface {

    public static final String ENCRYPTION = "1";
    public static final String DECRYPTION = "2";
    public static final String EXIT = "0";


    File file;
    RandomKey randomKey;
    MyFile myFile;

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
        DoubleAlgorithm doubleAlgorithm = createAlgorithm();
        file = getFilePath();
        randomKey = new RandomKey();
        int key1 = randomKey.key();
        int key2 = randomKey.key();

       /* createFile("","C:\\Users\\hackeru.HACKERU3\\Desktop\\test\\key1.bin",
                                        "C:\\Users\\hackeru.HACKERU3\\Desktop\\test\\key2.bin");
        myFile.writeObjectToFile(keyFile1,key1);
        myFile.writeObjectToFile(keyFile2,key2);
        doubleAlgorithm.setSecondKey(key2);
        File fileEncrypt = new File(AlgorithmOperation.fileExtension(file, 1));
        doubleAlgorithm.encryption(file, fileEncrypt, key1);
        output("your encryption succeed ");
        menu();
*/
    }
    /*public void createFile(String... paths)
    {

     for (String path : paths)
     {
         File keyFile = new File(path);
     }
    }*/


    private DoubleAlgorithm createAlgorithm() {
        DoubleAlgorithm doubleAlgorithm= new DoubleAlgorithm(new XorAlgorithm(),new ReversAlgorithm(
                new DoubleAlgorithm(new Caesar(),new MultiplicationAlgorithm())));


        return doubleAlgorithm;
    }

    private void decryption() {
        DoubleAlgorithm doubleAlgorithm = createAlgorithm();
        //output("enter your key  file path");
        //String key  = input();
        file = getFilePath();
        //int myKey = insertKey();
        //int mySecondKey = insertKey();
        MyFile myFile = new MyFile("");
        int myKey = (int)myFile.readObjectFromFile (new File("C:\\Users\\hackeru.HACKERU3\\Desktop\\test\\key2.bin"));
        int mySecondKey = (int)myFile.readObjectFromFile (new File("C:\\Users\\hackeru.HACKERU3\\Desktop\\test\\key1.bin"));
        doubleAlgorithm.setSecondKey(mySecondKey);
        File fileDecrypt = new File(AlgorithmOperation.fileExtension(file, 2));
        doubleAlgorithm.decryption(file, fileDecrypt, myKey);
        output("your decryption succeed ");
        menu();
    }
//054-3985292 ישי


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