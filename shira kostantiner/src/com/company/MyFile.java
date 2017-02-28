package com.company;

import java.io.File;
import java.net.URI;
import java.util.Scanner;


public class MyFile extends File{



    public MyFile(String pathname) {
        super(pathname);
        //this.exists();
    }
    public boolean check() {
            if (!exists()) {
                System.out.println("Wrong path ");
                return false;
            }
            else
                return true;
        }
}
