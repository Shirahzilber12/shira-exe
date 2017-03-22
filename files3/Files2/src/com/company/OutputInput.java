package com.company;

/**
 * Created by hackeru on 3/19/2017.
 */
public class OutputInput implements UserInterface {

    @Override
     public void output(String s) {
        System.out.println(s);
    }

    @Override
    public String input() {
        return Menu.scan();
    }
}
