package com.company;

import java.io.File;
import java.nio.file.OpenOption;


public class ReversAlgorithm<T> extends AlgorithmOperation<T> {

    private Algorithm algorithm;

    public ReversAlgorithm(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public void decryption(byte[] input,int type,T key) {
        algorithm.encryption( input, type, key);
    }

    @Override
    public void encryption(byte[] input,int type,T key) {
        algorithm.decryption( input, type,key);
    }


}
