/*
package com.company;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

*/
/**
 * Created by hackeru on 4/6/2017.
 *//*

public class Description  {


    File file;
    private static Set<String> commonWords = new HashSet<>();

    private void insertWord() {
        commonWords.add("the");//,"be","to","of","and", "a", "in");
        commonWords.add("be");
        commonWords.add("to");
        commonWords.add("of");
        commonWords.add("and");
        commonWords.add("a");
        commonWords.add("in");
    }


    public Description(File file) {
        this.file = file;
    }

    void getFile() {
        insertWord();
        char[] chars = new char[1000];
        InputStream inputStream = null;
        int oneByte;
        int i = 0;
        try {
            inputStream = new FileInputStream(file);
            while ((oneByte = inputStream.read()) != -1) {
                chars[i] = (char) oneByte;
                i++;
            }
            String s = new String(chars, 0, i);
            ThreadCaesar.keyFoundListener listener = new ThreadCaesar.keyFoundListener(){
                @Override
                public void keyFound(int key) {
                    //todo :stop thr other thread
                    printFile(s,key);
                }
            };
            ThreadCaesar threadCaesar1 = new ThreadCaesar(0,127,listener);
            ThreadCaesar threadCaesar2 = new ThreadCaesar(128,256,listener);
            threadCaesar1.start();
            threadCaesar2.start();
            //caesar(s);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


  */
/*  private String encryption(String word, int key) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            stringBuilder.append((char) (word.charAt(i) + 1));
        }
        String result = stringBuilder.toString();
        return result;
    }




    private void caesar(String s) {
        for (int key = 0; key < 256; key++) {
            int max = 0;
            for (String commonWord : commonWords) {
               String word = encryption(commonWord,key);
               if(s.indexOf(word)!=-1){
                   max++;
                   if (max > 3) {
                       printFile(s,key);
                       return;
                   }
               }
            }
        }
    }*//*


    private void printFile(String s,int key) {
        System.out.println("the key is "+key);
        System.out.println("print the file ");
        System.out.println(s+" ");
        return;
    }

}



   */
/* private String encryptWord(String word, int key) {
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i <word.length() ; i++) {
            stringBuilder.append((char)(word.charAt(i)+key));
        }
        String result=stringBuilder.toString();
        return result;
    }*//*



*/
