package com.company;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.Random;

public class Main {


    public static void main(String[] args) {
        // write your code here
        Menu menu = new Menu();

        AlgorithmOperation.setListener(menu);
        menu.menu();
    }











}
