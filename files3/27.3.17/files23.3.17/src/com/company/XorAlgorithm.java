package com.company;

import java.io.File;

/**
 * Created by This_user on 19/03/2017.
 */
public class XorAlgorithm extends AlgorithmOperation<Integer> {


    @Override
    public int operationEncryption(byte oneByte, Integer key) {
        return (oneByte^key);
    }


    @Override
    public int operationDecryption(byte oneByte, Integer key) {
        return oneByte^key;
    }
}


