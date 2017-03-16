package com.company;

import java.io.*;

/**
 * Created by hackeru on 3/16/2017.
 */
public class Caesar implements Operation{

    void operationByKey(File file,int type,int key){
        String newName;
        if (type==1)
            newName = file.getPath().substring(0, file.getPath().lastIndexOf('.')) + ".decrypted.txt";
        else
        newName=file.getPath().substring(0,file.getPath().lastIndexOf('.'))+".encrypted.txt";
        File encryption = new File(newName);
        OutputStream outputStream = null;
        InputStream inputStream = null;
        int oneByte;
        try {
            //encryption
            inputStream = new FileInputStream(file);
            outputStream = new FileOutputStream(encryption);
            while ((oneByte = inputStream.read())!=-1) {
                if (type==1)
                outputStream.write(oneByte+key);
                else
                outputStream.write(oneByte-key);
            }

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
        operationByKey(file,1,key);

    }

    @Override
    public void encryption(File file,int key) {
        operationByKey(file,2,key);

    }
}
