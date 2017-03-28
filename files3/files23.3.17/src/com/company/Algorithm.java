package com.company;

import java.io.File;

/**
 * Created by hackeru on 3/14/2017.
 */
public interface Algorithm {
    public void decryption(File file,File rFILE,int key);
    public void encryption(File file,File rFILE,int key);
}
