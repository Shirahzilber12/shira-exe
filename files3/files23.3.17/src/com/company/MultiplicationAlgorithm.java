package com.company;

import java.io.File;

/**
 * Created by hackeru on 3/20/2017.
 */
public class MultiplicationAlgorithm extends AlgorithmOperation {



    @Override
    public int operationEncryption(int oneByte, int key) {
        return (key * oneByte) & 0x000000FF;
    }

    @Override
    public int operationDecryption(int oneByte, int key) {
       key = changeKey(key);
        return (key * oneByte) & 0x000000FF;
    }

    @Override
    public void decryption(File file, File returnFile, int key) {
        if(key%2 == 0)
        super.decryption(file, returnFile, key+1);
        else super.decryption(file, returnFile,key);
    }

    @Override
    public void encryption(File file, File returnFile, int key) {
        System.out.println("כפל ");
        System.out.println("המפתח השני :"+key);

        if(key%2 == 0)
        super.encryption(file, returnFile,key+1);
        else super.encryption(file, returnFile, key);

    }


 private int changeKey(int key){
      int decKey = 0;
        for (int i = 0; i < 256; i++) {
        if(((i * key)& 0x000000FF) == 1) {
        decKey = i;
        break;
        }
        }
        return decKey;
        }


}