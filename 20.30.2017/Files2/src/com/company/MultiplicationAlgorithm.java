package com.company;

/**
 * Created by hackeru on 3/20/2017.
 */
public class MultiplicationAlgorithm extends OperationOnTheAlgorithm {



    @Override
    int operationEncryption(int oneByte, int key) {
        return oneByte*key;
    }

    @Override
    int operationDecryption(int oneByte, int key) {
        return oneByte/key;
    }
}
