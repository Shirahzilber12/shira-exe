package com.company;

import java.io.File;


public class DoubleAlgorithm  extends AlgorithmOperation {
    Algorithm firstAlgorithm;
    Algorithm secondAlgorithm2;
    int secondKey;



    public void setSecondKey(int secondKey) {
        this.secondKey = secondKey;
    }

    public void setFirstAlgorithm(Algorithm firstAlgorithm) {
        this.firstAlgorithm = firstAlgorithm;
    }

    public void setSecondAlgorithm2(Algorithm secondAlgorithm2) {
        this.secondAlgorithm2 = secondAlgorithm2;
    }

    @Override
    public void decryption(File file, int key) {
        firstAlgorithm.decryption(file,key);
        String newName = file.getPath().substring(0, file.getPath().lastIndexOf('.')) + ".decrypted.txt";
        File file1 = new File(newName);
        secondAlgorithm2.encryption(file1,secondKey);
    }

    @Override
    public void encryption(File file, int key) {
        firstAlgorithm.encryption(file,key);
        String newName = file.getPath().substring(0, file.getPath().lastIndexOf('.')) + ".encrypted.txt";
        File file1 = new File(newName);
        secondAlgorithm2.encryption(file1,secondKey);
    }
}
