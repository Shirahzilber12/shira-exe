package com.company;

/**
 * Created by hackeru on 3/30/2017.
 */
public class Output implements Listener  {
     public void print (String output){
         System.out.println(output);
     }

    @Override
    public void printSautes(long percent) {
        System.out.println("upload "+ percent+"%");
    }
}
