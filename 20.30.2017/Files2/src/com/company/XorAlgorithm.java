package com.company;

import java.io.File;



public class XorAlgorithm extends OperationOnTheAlgorithm{


    @Override
    int operationEncryption(int oneByte, int key) {
        return (oneByte^key);
    }

    @Override
    int operationDecryption(int oneByte, int key) {
        return (oneByte^key);
    }



}
