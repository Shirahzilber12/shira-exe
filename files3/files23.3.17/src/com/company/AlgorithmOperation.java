package com.company;

import java.io.*;


public abstract class AlgorithmOperation implements Algorithm {

    public static final int encryption = 1;
    public static final int decryption = 2;

    static Listener listener;
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


    /*void operationByKey(File file, File newFile, int type, int key) {
        started();
        OutputStream outputStream = null;
        InputStream inputStream = null;
        int oneByte;
        try {
            inputStream = new FileInputStream(file);
            outputStream = new FileOutputStream(newFile);
            while ((oneByte = inputStream.read()) != -1)
            {
                if (type == decryption)
                    oneByte = operationDecryption(oneByte, key);
                else
                    oneByte = operationEncryption(oneByte, key);
                outputStream.write(oneByte);
            }
            ended();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (outputStream != null)
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }*/

    public void operationByKey(File file, File newFile, int type, int key)
    {
        try {
            InputStream inputStream = new FileInputStream(file);
            OutputStream outputStream = new FileOutputStream(newFile);

            new FileTrafficHandler(outputStream, inputStream).readFromFileWriteToAnother(type);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void decryption(File file, File returnFile, int key) {
        operationByKey(file, returnFile, decryption, key);
    }

    @Override
    public void encryption(File file, File returnFile, int key) {
        operationByKey(file, returnFile, encryption, key);
    }

    public int operationEncryption(int oneByte, int key) {
        return oneByte;
    }

    public int operationDecryption(int oneByte, int key) {
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

