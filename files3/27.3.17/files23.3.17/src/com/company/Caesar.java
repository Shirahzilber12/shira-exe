package com.company;

import java.io.*;

/**
 * Created by hackeru on 3/16/2017.
 */
public class Caesar extends AlgorithmOperation<Integer> {

    @Override
    public int operationEncryption(byte oneByte, Integer key) {
        return oneByte + key;
    }

    @Override
    public int operationDecryption(byte oneByte, Integer key) {
        return oneByte - key;
    }


    }
