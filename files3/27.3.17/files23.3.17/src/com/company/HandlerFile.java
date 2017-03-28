package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by hackeru on 3/27/2017.
 */
public class HandlerFile<T> {


    AlgorithmOperation algorithmOperation;


    public void readFromFiles(String fileName,int type, T key,String returnFile) throws IOException {
       byte[] content = Files.readAllBytes(Paths.get(fileName));
       content = algorithmOperation.operationByKey(content,1,key);
       writeToFiles(content,returnFile);
     }

     public void writeToFiles(byte[] fileContent ,String fileName) throws IOException {
       Files.write(Paths.get(fileName), fileContent);
   }
}






/*  byte[] content = Files.readAllBytes(Paths.get(""));
      Files.write(Paths.get(""), content);*/
