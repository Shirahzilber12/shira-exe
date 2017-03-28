package com.company;

import java.io.File;


public class DoubleAlgorithm<T,K>  extends AlgorithmOperation<DoubleKey<T, K>> {
    Algorithm firstAlgorithm;
    Algorithm secondAlgorithm2;


    public DoubleAlgorithm(Algorithm firstAlgorithm, Algorithm secondAlgorithm2) {
        this.firstAlgorithm = firstAlgorithm;
        this.secondAlgorithm2 = secondAlgorithm2;

    }



    @Override
    public void encryption(byte[] content,int type, DoubleKey<T, K> key) {

        firstAlgorithm.encryption(content,type,key.firstKey);
        secondAlgorithm2.encryption(content, type, key.secondKey);

    }


    @Override
    public void decryption(byte[] content,int type, DoubleKey<T, K> key) {

        secondAlgorithm2.decryption(content,type,key.secondKey);
        firstAlgorithm.decryption(content, type, key.firstKey);

    }


}
