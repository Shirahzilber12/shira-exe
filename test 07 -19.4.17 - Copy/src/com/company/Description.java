package com.company;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by hackeru on 4/6/2017.
 */
public class Description {


    File file;
    private static Set<String> commonWords = new HashSet<>();

    private void insertWord() {
        commonWords.add("the");
        commonWords.add("be");
        commonWords.add("to");
        commonWords.add("of");
        commonWords.add("and");
        commonWords.add("a");
        commonWords.add("in");
    }


    public Description(File file) {
        this.file = file;
    }

    ThreadCaesar threadCaesar1;
    ThreadCaesar threadCaesar2;


    void getFile() {
        insertWord();

        InputStream inputStream = null;
        int oneByte;
        int i = 0;
        try {
            inputStream = new FileInputStream(file);
            int l = (int) file.length();
            byte[] fileEncrypt = new byte[l];
            while ((oneByte = inputStream.read()) != -1) {
                fileEncrypt[i] = (byte) oneByte;
                i++;
            }


            ThreadCaesar.keyFoundListener listener = key -> {
                printFile(fileEncrypt, key);

            };

            ThreadCaesar threadCaesar1 = new ThreadCaesar(fileEncrypt, commonWords, 0, 127, listener);
            ThreadCaesar threadCaesar2 = new ThreadCaesar(fileEncrypt, commonWords, 128, 256, listener);
            threadCaesar1.run();
            threadCaesar2.run();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    private void printFile(byte[] fileDecrypt, int key) {
        System.out.println("the key is " + key);
        System.out.println("print the file ");
        String s = new String(fileDecrypt);
        System.out.println(s);
        return;
    }


}


