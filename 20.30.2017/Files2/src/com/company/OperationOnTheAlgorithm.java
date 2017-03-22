package com.company;

import java.io.*;

/**
 * Created by hackeru on 3/20/2017.
 */

public abstract class OperationOnTheAlgorithm implements Algorithm {

        public static final int encryption = 1;
        public static final int decryption = 2;


        void operationByKey(File file, int type, int key){
            OutputStream outputStream = null;
            InputStream inputStream = null;
            String newName = " ";
            if (type==encryption)
                newName = file.getPath().substring(0, file.getPath().lastIndexOf('.')) + ".encrypted.txt";
            else
                newName=file.getPath().substring(0,file.getPath().lastIndexOf('.'))+".decrypted.txt";
            File newFile = new File(newName);
            int oneByte;
            try {
                inputStream = new FileInputStream(file);
                outputStream = new FileOutputStream(newFile);
                while ((oneByte = inputStream.read())!=-1) {
                    if (type==encryption)
                         oneByte = operationEncryption(oneByte,key);
                    else
                        oneByte = operationDecryption(oneByte, key);
                    outputStream.write(oneByte);
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


          //הצפנה
         @Override
         public void encryption(File file,int key) {
         operationByKey(file, encryption,key);
        }
        //פיענוח
        @Override
        public void decryption(File file,int key) {
            operationByKey(file, decryption,key);

        }

        int operationEncryption(int oneByte,int key)  {
            return oneByte;
        }

        int operationDecryption(int oneByte,int key)  {
            return oneByte ;
        }



}
