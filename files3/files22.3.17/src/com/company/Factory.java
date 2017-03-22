package com.company;

/**
 * Created by This_user on 20/03/2017.
 */
public class Factory {
    public static final String CAESAR = "1";
    public static final String XOR = "2";
    public static final String MULTIPLICATION = "3";


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
        /*if(torev==null) {
           output("you need to choose type of reverse:\n1: caesar Algorithm\n2: Xor Algorithm\n3: Multiplication Algorithm");
           return factory.chooseRevers(input());}
        }*/
        return new ReversAlgorithm(torev);
    }
}
