package com.company;

import java.io.*;
import java.util.Random;


public class Menu implements AlgorithmOperation.Listener  {

    public static final String ENCRYPTION = "1";
    public static final String DECRYPTION = "2";
    public static final String EXIT = "0";


    MyFile file;
    RandomKey randomKey;
    MyFile myFile;
    static Input input = new OnScreen();
    static Output output = new OnScreen();
    DoubleAlgorithm doubleAlgorithm;
    static  DoubleKey doubleKey = new DoubleKey();

    void menu() {
        output.output("please enter your choice:\n1: encryption  \n2: decryption   \n0: exit");
        switch (input.input()) {
            case ENCRYPTION:
                encryption();
                break;
            case DECRYPTION:
                //decryption();
                break;
            case EXIT:
                output.output("bye bye");
                return;
            default:
                output.output("incorrect option");
                menu();
        }
    }


    private void encryption()  {
        DoubleAlgorithm<Integer,DoubleKey<Integer,Integer>> doubleAlgorithm = createAlgorithm();
        String filePath=  getFilePath();
        HandlerFile handlerFile = new HandlerFile();
        DoubleKey<Integer, DoubleKey<Integer, Integer>> doubleKey = getDoubleKey(doubleAlgorithm);
        try {
            handlerFile.readFromFiles(filePath,1,doubleKey,"");
        } catch (IOException e) {
            e.printStackTrace();
        }


        // MyFile fileEncrypt = new MyFile(AlgorithmOperation.fileExtension(file, 1));
       // doubleAlgorithm.encryption(file, fileEncrypt,doubleKey);
        output.output("your encryption succeed ");
        menu();

    }

    private DoubleKey<Integer,DoubleKey<Integer,Integer>> getDoubleKey(DoubleAlgorithm doubleAlgorithm) {
        randomKey = new RandomKey();
        DoubleKey<Integer,DoubleKey<Integer,Integer>> doubleKey = new DoubleKey<>();
        doubleKey.firstKey = randomKey;
        doubleKey.secondKey= new DoubleKey(new RandomKey(), new RandomKey());
        String prefix = file.getPath().substring(0, file.getPath().lastIndexOf('.'))+"key.bin";
        MyFile fileKey = new MyFile(prefix);
        fileKey.writeObjectToFile(doubleKey);
        return doubleKey;
    }



    private DoubleAlgorithm<Integer,DoubleKey<Integer,Integer>> createAlgorithm() {
        DoubleAlgorithm doubleAlgorithm= new DoubleAlgorithm(new XorAlgorithm(),new ReversAlgorithm(
                new DoubleAlgorithm(new Caesar(),new MultiplicationAlgorithm())));
        return doubleAlgorithm;
    }

    private void decryption() {
        DoubleAlgorithm doubleAlgorithm = createAlgorithm();
        String filePath=  getFilePath();
        output.output("enter key path");
        MyFile keyFile = new MyFile(input.input());
        DoubleKey doubleKey = (DoubleKey)keyFile.readObjectFromFile ();
        HandlerFile handlerFile = new HandlerFile();
        MyFile fileDecrypt = new MyFile(AlgorithmOperation.fileExtension(file, 2));
        handlerFile.readFromFiles(filePath,"",doubleKey);
        output.output("your decryption succeed ");
        menu();
    }
//054-3985292 ישי 

//regionInsert key
  /*  int insertKey() {
        int key = 0;
        try {
            output("please enter your key");
            key = Integer.parseInt(input());
        } catch (NumberFormatException e) {
            output("you not enter num ");
            insertKey();
        }
        return key;
    }*/
    //endregion

    public String getFilePath() {
        output.output("enter your path");
        String fileName = input.input();
        MyFile myFile = new MyFile(fileName);
        while (!checkFile(myFile)) {
            output.output("enter your path");
            myFile = new MyFile(input.input());
        }
        return fileName;
    }


    boolean checkFile(MyFile filePath) {
        if (filePath.exists()) {
            if (filePath.isFile())
                return true;
            else output.output("you not enter file");
        } else output.output("your path wrong");
        return false;

    }

    @Override
    public void StartDetect() {
        output.output("the cipher is start \nthe time now is" + System.nanoTime());
    }

    @Override
    public void EndDetect() {
        output.output("the cipher is end \nthe time now is" + System.nanoTime());
    }


}