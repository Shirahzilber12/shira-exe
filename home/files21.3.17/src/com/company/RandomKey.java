package com.company;

import java.util.Random;

/**
 * Created by This_user on 20/03/2017.
 */
public class RandomKey {
    static int randomKey(){
        Random random = new Random(System.currentTimeMillis());
        int key = random.nextInt(255);
        return key;
    }
}
