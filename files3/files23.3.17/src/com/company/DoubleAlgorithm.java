package com.company;

import java.io.File;


public class DoubleAlgorithm  extends AlgorithmOperation {
    Algorithm firstAlgorithm;
    Algorithm secondAlgorithm2;
    Integer secondKey;

    public DoubleAlgorithm(Algorithm firstAlgorithm, Algorithm secondAlgorithm2) {
        this.firstAlgorithm = firstAlgorithm;
        this.secondAlgorithm2 = secondAlgorithm2;

    }

    public void setSecondKey(int secondKey) {
        this.secondKey = secondKey;
    }

    @Override
    public void encryption(File file, File returnFile, int key) {
        String newName = file.getPath().substring(0, file.getPath().lastIndexOf('.')) + ".encrypted.temp.txt";
        File temp = new File(newName);
        reverseDouble(key);
        firstAlgorithm.encryption(file, temp, key);
        secondAlgorithm2.encryption(temp, returnFile, secondKey);
        temp.delete();
    }


    @Override
    public void decryption(File file, File returnFile, int key) {
        String newName = file.getPath().substring(0, file.getPath().lastIndexOf('.')) + ".decrypted.temp.txt";
        File temp = new File(newName);
        reverseDouble(key);
        secondAlgorithm2.decryption(file, temp, key);
        firstAlgorithm.decryption(temp, returnFile, secondKey);
        temp.delete();
    }

    private void reverseDouble(int key) {
        if (secondKey == null)
            secondKey = key;
    }
}
