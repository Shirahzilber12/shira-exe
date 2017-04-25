package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by hackeru on 4/6/2017.
 */
public class Menu {



    private static Set<String> words = new HashSet<>();
    public static void menu() {
      System.out.println("please enter your choice \n 1:enter word \n 2: print screen the words \n 3: enter path\n 4: exit  ");
      String choice  = getInputFromUser();
      switch (choice) {
          case "1":
              cheackWord();
              break;
          case "2":
              printWord();
              break;
          case "3":
              enterPath();
          case "exit":
              System.out.println("c u later!");
              return ;
          default:
              System.out.println("invalid choice. try again");
              menu();


      }
  }

    private static void enterPath() {
        boolean go = true;
        File file = new File("");
        while (go){
            System.out.println("enter path ");
            String path = getInputFromUser();
            file  = new File(path);
            if(!(cheackFile(file))){
                System.out.println("not correct file ");
            }
            else go  = false;
        }
       /* System.out.println("enter path ");
        String path = getInputFromUser();
        File file  = new File(path);
        if(!(cheackFile(file)){
            System.out.println("");
        }
*/
        Description description = new Description(file);
        description.getFile();

    }

    private static boolean cheackFile(File file) {
        if(file.exists()&&file.isFile())
            return true;
        else return false;
    }


    private static void cheackWord() {
        System.out.println("please enter word ");
        String word = getInputFromUser();
        String[] strings = word.split(",");
        for (int i = 0; i <strings.length ; i++) {
            if(!words.contains(strings[i])){
                words.add(strings[i]);}
                else {
                    System.out.println("the word:" + strings[i] +" is exists ");
                }
            }
            menu();
        }




    private static void printWord() {
        for (String word : words) {
            System.out.println(word);
        }
    }


    static String getInputFromUser(){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
