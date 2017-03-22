package com.company;

import java.io.File;
import java.net.URI;
import java.util.Scanner;

public class MyFile extends File{



    public MyFile(String pathname) {
        super(pathname);
       // this.exists();
    }
    public boolean check(MyFile myFile) {
        if (myFile.exists()) {
            if (myFile.isFile()){
                return true;
            }
            else
                System.out.println("not file");
            return false;
        }
        else
            System.out.println("Wrong path ");
        return false;
    }
}
