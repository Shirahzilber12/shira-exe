package com.company;

import java.util.Random;

/**
 * Created by This_user on 20/03/2017.
 */
public class RandomKey implements Key {
    private Random random;

    public RandomKey() {
        this.random = new Random(System.currentTimeMillis());
    }

    @Override
    public int key() {
        int key = random.nextInt(255);
        return key;
    }


}


