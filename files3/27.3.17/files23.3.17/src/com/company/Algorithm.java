package com.company;

import java.io.File;

/**
 * Created by hackeru on 3/14/2017.
 */
public interface Algorithm<T> {
    public void decryption(byte[] input,int type,T key);
    public void encryption(byte[] input,int type,T key);
    //public byte[] encryption1(byte[] input,MyFile returnFile,T key);
}
