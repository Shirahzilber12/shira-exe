package com.company;

import java.io.*;
import java.util.Random;

/**
 * Created by hackeru on 3/16/2017.
 */
public class Caesar extends OperationOnTheAlgorithm {


    @Override
    int operationEncryption(int oneByte, int key) {
        return oneByte+key;
    }

    @Override
    int operationDecryption(int oneByte, int key) {
        return oneByte-key;
    }
}
