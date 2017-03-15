package com.company;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Random;

//הצפנה
public class Encryption implements Operation {

    public static void encryptionCaesar(){
        Random random = new Random(System.currentTimeMillis());
        int num = random.nextInt(255);
        File file = new File("C:\\Users\\hackeru.HACKERU3\\Documents\\GitHub\\shira-exe\\encryption.txt");
        OutputStream outputStream = null;
        InputStream inputStream = null;
        //tryyyy
        byte number = 20;
        byte[] buffer = new byte[1];
        System.out.println("the num before"+ number);
        int result = number+150;
        ByteBuffer.wrap(buffer).putInt(result);

        int c = (int)buffer[0];
        System.out.println("num after"+c);





       // while (buffer = inputStream.read()!=)

    }

}
