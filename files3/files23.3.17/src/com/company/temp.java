package com.company;

/**
 * Created by hackeru on 3/22/2017.
 */
public class temp {
        /*private Algorithm chooseOption(){
        output("1: caesar Algorithm\n2: Xor Algorithm\n3: Multiplication Algorithm\n4: ReversAlgorithm");
        String choice = input();
        factory = new Factory();
        if(choice.equals("4")){
            return chooseRevers();
        }
        else
            //output("your choose is not correct,please enter again");
            return factory.chooseAlgorithm(choice);
    }
     Algorithm chooseRevers(){
        output("you need to choose type of reverse:\n1: caesar Algorithm\n2: Xor Algorithm\n3: Multiplication Algorithm");
        return factory.chooseRevers(input());}

   /* private Algorithm chooseOption(){
        output("1: caesar Algorithm\n2: Xor Algorithm\n3: Multiplication Algorithm\n4: ReversAlgorithm");
        String choice = input();
        factory = new Factory();
        switch (choice){
            case "1":
                return factory.chooseAlgorithm(choice);
            case "2":
                return factory.chooseAlgorithm(choice);
            case "3":
                return factory.chooseAlgorithm(choice);
            case "4":
                output("you need to choose type of reverse:\n1: caesar Algorithm\n2: Xor Algorithm\n3: Multiplication Algorithm");
                return factory.chooseRevers(input());
            default: {
                output("your choose is not correct,please enter again");
                return chooseOption();}

        }
    }
    /*Algorithm chooseRevers(){
        output("you need to choose type of reverse:\n1: caesar Algorithm\n2: Xor Algorithm\n3: Multiplication Algorithm");
        return factory.chooseRevers(input());
    }*/

         /*if(algorithm == null) {
            output("your choose is not correct,please enter again");
            algorithm =chooseOption();
        }*/

    /*   String chooseRevers(){
        output("you need to choose type of reverse:\n1: caesar Algorithm\n2: Xor Algorithm\n3: Multiplication Algorithm");
        return input();
    }*/

  /*  private DoubleAlgorithm doubleOption(){
        output("choose algorithm \n1: xor & revers\n2: casar & mult");
        DoubleAlgorithm doubleAlgorithm = new DoubleAlgorithm();
        Factory factory = new Factory();
        switch (input()){
            case "1":
                doubleAlgorithm.setFirstAlgorithm(factory.chooseAlgorithm("2"));
                output("you need to choose type of reverse:\n1: caesar Algorithm\n2: Xor Algorithm\n3: Multiplication Algorithm");
                doubleAlgorithm.setSecondAlgorithm2(factory.chooseRevers(input()));
                break;
            case "2":
                doubleAlgorithm.setFirstAlgorithm(factory.chooseAlgorithm("1"));
                doubleAlgorithm.setSecondAlgorithm2(factory.chooseAlgorithm("3"));
               // DoubleAlgorithm doubleAlgorithm1 = factory.chooseAlgorithm("1"),factory.chooseAlgorithm("3");
                break;
        }
        return doubleAlgorithm;


    }*/
 /* private DoubleAlgorithm createDecryptionAlgorithm() {
      DoubleAlgorithm tempDoubleAlgorithm = new DoubleAlgorithm();
      tempDoubleAlgorithm.setFirstAlgorithm(new MultiplicationAlgorithm());
      tempDoubleAlgorithm.setSecondAlgorithm2(new Caesar());
      DoubleAlgorithm doubleAlgorithm = new DoubleAlgorithm();
      doubleAlgorithm.setFirstAlgorithm(new ReversAlgorithm(tempDoubleAlgorithm));
      doubleAlgorithm.setSecondAlgorithm2(new XorAlgorithm());
      return doubleAlgorithm;
  }*/
}
