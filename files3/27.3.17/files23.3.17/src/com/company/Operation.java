package com.company;

import java.io.File;

/**
 * Created by hackeru on 3/14/2017.
 */
public interface Operation {
    //public void caesar(File file,int key);
    public void decryption(File file,int key);
    public void encryption(File file,int key);
}
