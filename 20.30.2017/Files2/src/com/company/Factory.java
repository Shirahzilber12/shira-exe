package com.company;

/**
 * Created by hackeru on 3/20/2017.
 */
public class Factory {
    public static final String Caesar = "1";
    public static final String XorAlgorithm = "2";
    public static final String MultiplicationAlgorithm = "3";
    public static final String ReversAlgorithm = "4";
    static boolean flag = true;

    Algorithm chooseAlgorithm(String choice){
        switch (choice) {
            case Caesar:
                return new Caesar();
            case XorAlgorithm:
                return new XorAlgorithm();
            case MultiplicationAlgorithm:
                return new MultiplicationAlgorithm();
            case  ReversAlgorithm:
                flag = !flag;
                chooseAlgorithm(Menu.userInterface.input());
            default:
                   Menu.userInterface.output("your choose not correct enter again");
                    chooseAlgorithm(Menu.userInterface.input());
        }
        return new Caesar();
}
}
