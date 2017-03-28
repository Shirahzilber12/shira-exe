package com.company;

import java.io.File;


public class MultiplicationAlgorithm extends AlgorithmOperation<Integer> {



    @Override
    public int operationEncryption(byte oneByte, Integer key) {
        return (key * oneByte) & 0x000000FF;
    }

    @Override
    public int operationDecryption(byte oneByte, Integer key) {
       key = changeKey(key);
        return (key * oneByte) & 0x000000FF;
    }

    @Override
    public void decryption(byte[] content,int type,Integer key) {
        if(key%2 == 0)
        super.decryption(content, 2,  key+1);
        else super.decryption(content, 2,key);
    }

    @Override
    public void encryption(byte[] content,int type,Integer key) {
        if(key%2 == 0)
        super.encryption(content, 1,key+1);
        else super.encryption(content, 1, key);

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