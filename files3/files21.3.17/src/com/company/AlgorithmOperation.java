package com.company;

import java.io.*;


public abstract class AlgorithmOperation implements Algorithm {

    public static final int encryption = 1;

    public static final int decryption = 2;
    ;
    static Listener listener;

    public static void setListener(Listener listener) {
        AlgorithmOperation.listener = listener;
    }
    void started(){
        if (listener!=null)
            listener.StartDetect();
    }
    void ended(){
        if (listener!=null)
            listener.EndDetect();
    }


    void operationByKey(File file, int type, int key){
        started();
        String newName = " ";
        if (type==decryption )
            newName = file.getPath().substring(0, file.getPath().lastIndexOf('.')) + ".decrypted.txt";
        else
            newName=file.getPath().substring(0,file.getPath().lastIndexOf('.'))+".encrypted.txt";
        File newFile = new File(newName);
        OutputStream outputStream = null;
        InputStream inputStream = null;
        int oneByte;
        try {
            //encryption
            inputStream = new FileInputStream(file);
            outputStream = new FileOutputStream(newFile);
            while ((oneByte = inputStream.read())!=-1) {
                if (type==decryption)
                    oneByte = operationDecryption(oneByte,key);
                else
                    oneByte = operationEncryption(oneByte,key);
                    outputStream.write(oneByte);
            }
            ended();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if( inputStream!=null)
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if( outputStream!=null)
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    @Override
    public void decryption(File file,int key) {
        operationByKey(file, decryption,key);
    }

    @Override
    public void encryption(File file,int key) {
        operationByKey(file, encryption,key);
    }

    public int operationEncryption(int oneByte,int key) {
        return oneByte;
    }

    public int operationDecryption(int oneByte,int key) {
        return oneByte;
    }


interface Listener {
    void StartDetect();
    void EndDetect();
}


}

