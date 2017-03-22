package com.company;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.Random;

public class Main {


    public static void main(String[] args) {
	// write your code here


        Menu.userInterface= new Menu.UserInterface() {
            @Override
            public void output(String s) {
                System.out.println(s);
            }

            @Override
            public String input() {
                return Menu.scan();
            }
        };
        Menu.start();
    }











}
