package com.company;

/**
 * Created by This_user on 20/03/2017.
 */
public class Factory {
    public static final String CAESAR = "1";
    public static final String XOR = "2";
    public static final String MULTIPLICATION = "3";
    static boolean flag = true;
    Menu menu = new Menu();
    Algorithm chooseAlgorithm(String choose){
        switch (choose){
            case CAESAR:
                return new Caesar();
            case XOR:
                return new XorAlgorithm();
            case MULTIPLICATION:
                return new MultiplicationAlgorithm();

        }
        return null;
    }

    Algorithm chooseRevers(String choose){
        Algorithm torev = chooseAlgorithm(choose);
        return new ReversAlgorithm(torev);
    }
}
