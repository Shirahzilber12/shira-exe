package com.company;

import java.io.*;
import java.util.Random;

//פענוח
public class Decryption implements Operation {

    @Override
    public void caesar(File encryption,int key){

        String newName=encryption.getPath().substring(0,encryption.getPath().lastIndexOf('.'))+".decrypted.txt";
        File decryption = new File(newName);
        OutputStream outputStream = null;
        InputStream inputStream = null;
        int oneByte;
        try {
            //decryption
            inputStream = new FileInputStream(encryption);
            outputStream = new FileOutputStream(decryption);
            while ((oneByte = inputStream.read())!=-1)
                outputStream.write(oneByte-key);
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





}
