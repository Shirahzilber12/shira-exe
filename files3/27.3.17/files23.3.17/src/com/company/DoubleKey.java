package com.company;

import java.io.Serializable;

/**
 * Created by This_user on 26/03/2017.
 */
public class DoubleKey<T ,K> implements Serializable, Key<T> {
    Key<T> firstKey;
    Key<K> secondKey;


    @Override
    public T key() {
        return firstKey.key();
    }

    public Key<K> getSecondKey() {
        return secondKey;
    }

    public DoubleKey(Key<T> firstKey, Key<K> secondKey) {
        this.firstKey = firstKey;
        this.secondKey = secondKey;
    }

    public DoubleKey() {}

}
