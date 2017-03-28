package com.company;

import java.io.File;

/**
 * Created by This_user on 19/03/2017.
 */
public class XorAlgorithm extends AlgorithmOperation {
    @Override
    public int operationEncryption(int oneByte, int key) {
        return oneByte^key;
    }

    @Override
    public int operationDecryption(int oneByte, int key) {
        return oneByte^key;
    }
}
