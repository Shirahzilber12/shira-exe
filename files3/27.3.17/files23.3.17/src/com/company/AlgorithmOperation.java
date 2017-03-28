package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


public abstract class AlgorithmOperation<T> implements Algorithm<T> {

    public static final int encryption = 1;
    public static final int decryption = 2;

    static Listener listener;
    MyFile file;
    Key key;



    public void setKey(Key key) {
        this.key = key;
    }

    public Key getKey() {
        return key;
    }

    public static void setListener(Listener listener) {
        AlgorithmOperation.listener = listener;
    }

    void started() {
        if (listener != null)
            listener.StartDetect();
    }

    void ended() {
        if (listener != null)
            listener.EndDetect();
    }


    byte[] operationByKey(byte[] arrFile, int type,T key) {
        started();
        int i = 0;
           while (i<arrFile.length) {
               if (type == decryption) {
                   arrFile[i] = (byte) operationDecryption(arrFile[i], key);
                   i++;
               } else {
                   arrFile[i] = (byte) operationEncryption(arrFile[i], key);//, key
                   i++;
               }
           }
           ended();
           return  arrFile;

    }


    @Override
    public void decryption(byte[] content,int type,T key) {
        operationByKey(content, decryption, key);
    }


    @Override
    public void encryption(byte[] content,int type,T key) {
        operationByKey(content, encryption, key);
    }

    public int operationEncryption(byte oneByte, T key) {
        return oneByte;
    }

    public int operationDecryption(byte oneByte, T key) {
        return oneByte;
    }

    public static String fileExtension(File file, int type)
    {
        String prefix = file.getPath().substring(0, file.getPath().lastIndexOf('.'));
        String fullPath;

        if (type == encryption) {
            fullPath = prefix + ".encrypted.txt";
        }
        else
            fullPath  = prefix + ".decrypted.txt";

        return fullPath;
    }


    interface Listener {
        void StartDetect();

        void EndDetect();
    }

}

