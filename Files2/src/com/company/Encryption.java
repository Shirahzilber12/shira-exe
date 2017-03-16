package com.company;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.Random;

//הצפנה
public class Encryption  implements Operation  {

     public void caesar(File file ,int key){
         String newName=file.getPath().substring(0,file.getPath().lastIndexOf('.'))+".encrypted.txt";
         File encryption = new File(newName);
         OutputStream outputStream = null;
         InputStream inputStream = null;
         int oneByte;
        try {
            //encryption
            inputStream = new FileInputStream(file);
            outputStream = new FileOutputStream(encryption);
            while ((oneByte = inputStream.read())!=-1) {
                outputStream.write(oneByte+key);
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

}
