package com.company;

/**
 * Created by hackeru on 3/20/2017.
 */
public class KeyRandom implements Key {

    @Override
    public int typeOfKeyKey() {
        int key;
        java.util.Random random = new java.util.Random(System.currentTimeMillis());
        return key = random.nextInt(255);
    }
}
