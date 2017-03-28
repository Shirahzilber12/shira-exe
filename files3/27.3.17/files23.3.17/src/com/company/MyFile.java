package com.company;

import java.io.*;

/**
 * Created by This_user on 23/03/2017.
 */
public class MyFile extends File {

    public MyFile(String pathname) {
        super(pathname);
    }

    MyFile myFile;

    public MyFile(String pathname, MyFile myFile) {
        super(pathname);
        this.myFile = myFile;
    }

    public void writeObjectToFile (Serializable toWrite){
        ObjectOutputStream objectOutputStream = null;
        OutputStream outputStream = null;
        try{
            outputStream = new FileOutputStream(this);
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(toWrite);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            closeObjectOutputStream(objectOutputStream);
            closeOutputStream(outputStream);
        }
    }

    private void closeObjectOutputStream(ObjectOutputStream objectOutputStream) {
        if(objectOutputStream != null)
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public Serializable readObjectFromFile (){
        InputStream inputStream = null;
        ObjectInputStream objectInputStream = null;
        Serializable toRead = null;
        try{
            inputStream = new FileInputStream(this);
            objectInputStream = new ObjectInputStream(inputStream);
            toRead = (Serializable) objectInputStream.readObject();
            //return toRead;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            closeObjectStream(objectInputStream);
            closeInputStream(inputStream);

        }
        return toRead;
    }

    void closeObjectStream(ObjectInputStream objectInputStream) {
         if (objectInputStream != null)
             try {
                 objectInputStream.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
     }

    void closeOutputStream(OutputStream outputStream){
        if(outputStream != null)
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    void closeInputStream(InputStream inputStream) {
        if (inputStream != null)
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    OutputStream openOutput(){
        OutputStream outputStream = null;

        try {
            outputStream = new FileOutputStream(this);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return outputStream;
    }

    InputStream openInput(){
        InputStream inputStream = null;

        try {
            inputStream= new FileInputStream(this);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return inputStream;
    }

}
