package com.company;

import java.io.File;
import java.nio.file.OpenOption;


public class ReversAlgorithm extends AlgorithmOperation{

    private Algorithm algorithm;

    public ReversAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    @Override public void decryption(File file, int key) {
        algorithm.encryption(file,key);
    }

    @Override
    public void encryption(File file, int key) {
        algorithm.decryption(file,key);
    }

}
