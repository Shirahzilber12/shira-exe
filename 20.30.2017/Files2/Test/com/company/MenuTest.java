/*
package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import java.io.File;
import static org.mockito.Mockito.*;


class MenuTest {

    @Test
    void TestIsInvalisInput() {
        Menu.UserInterface userInterface = mock(Menu.UserInterface.class);
        Menu.userInterface = userInterface;
        Menu.menu("a");
        verify(userInterface).output("incorrect option");
    }
    @Test
    void TestWhenTheInputIsSpace() {
        Menu.UserInterface userInterface = mock(Menu.UserInterface.class);
        Menu.userInterface = userInterface;
        Menu.menu("a");
        verify(userInterface).output("incorrect option");
    }

    //בודק אם הקלט הוא 1
    @Test
    void menuTest3() {
        Menu.UserInterface userInterface = mock(Menu.UserInterface.class);
        Menu.userInterface = userInterface;
        Menu.menu("1");
        verify(userInterface).output("enter your path" );
    }

   */
/* //בודק אם הקלט הוא 2
    @Test
    void menuTest4() {
        Menu.UserInterface userInterface = mock(Menu.UserInterface.class);
        Menu.userInterface = userInterface;
        when(userInterface.input()).thenReturn("2").thenReturn("C:\\Users\\hackeru.HACKERU3\\Documents\\GitHub\\shira-exe\\myFile.txt").thenReturn("1").thenReturn("0");//.thenThrow(new Exception());
        Menu.start();
        InOrder orderedOutput = inOrder(userInterface);
        orderedOutput.verify(userInterface).output("enter your path");
        orderedOutput.verify(userInterface).output("please enter your key");
    }*//*

    //בודק אם הקלט הוא 0
    @Test
    void TestIsInvalIsInputZero() {
        Menu.UserInterface userInterface = mock(Menu.UserInterface.class);
        Menu.userInterface = userInterface;
        when(userInterface.input()).thenReturn("0");
        Menu.menu("0");
        verify(userInterface).output("bye bye" );
    }
    //בודק האם הקובץ הוצפן
    @Test
    void menuTest6() {
        Menu.UserInterface userInterface = mock(Menu.UserInterface.class);
        Menu.userInterface = userInterface;
        Menu.menu("1");
        File file = new File("C:\\Users\\This_user\\Desktop\\try\\g.encrypted.txt");
        Assertions.assertTrue(file.exists());

    }




    //בודק האם הקובץ פוענח
    @Test
    void menuTest7() {
        Menu.UserInterface userInterface = mock(Menu.UserInterface.class);
        Menu.userInterface = userInterface;
        when(userInterface.input()).thenReturn("1").thenReturn("C:\\Users\\hackeru.HACKERU3\\Documents\\GitHub\\shira-exe\\myFile.encrypted.txt").thenReturn("0");//.thenThrow(new Exception());
        Menu.start();
       // File file = new File("C:\\Users\\hackeru.HACKERU3\\Documents\\GitHub\\shira - exe\\myFile.encrypted.decrypted.txt");
       // verify(Menu.menu("1"));
    }


    //בדיקה אם הוקש מפתח שהוא אינו מספר
    @Test
    void menuTest8() {
        Menu.UserInterface userInterface = mock(Menu.UserInterface.class);
        Menu.userInterface = userInterface;
        when(userInterface.input()).thenReturn("2").thenReturn("C:\\Users\\hackeru.HACKERU3\\Documents\\GitHub\\shira-exe\\myFile.txt").thenReturn("1").thenThrow(new Exception());
        Menu.start();
        InOrder orderedOutput = inOrder(userInterface);
        orderedOutput.verify(userInterface).output("enter your path ");
        orderedOutput.verify(userInterface).output("please enter your key");
        orderedOutput.verify(userInterface).output("you not enter num");
    }


    //בדיקות על הקבצים:
    @Test
    void checkMyFile_notPath() {
        MyFile file = new MyFile("aa45415a");
        if (file.check(file))
            Assertions.fail("not path");
    }
    @Test
    void checkMyFile_notFile() {
        MyFile file = new MyFile("C:\\Users\\hackeru.HACKERU3\\Documents\\GitHub\\shira-exe");
        if (file.check(file))
            Assertions.fail("not file");
    }
    @Test
    void checkMyFile_notExist() {
        MyFile file = new MyFile("C:\\Users\\hackeru.HACKERU3\\Docuhhhhhhhhhhments\\GitHub\\shira-exe");
        if (file.check(file))
            Assertions.fail("Path doesn't exist ");
    }
    void checkMyFile_pathExist() {
        MyFile file = new MyFile("C:\\Users\\hackeru.HACKERU3\\Documents\\GitHub\\shira-exe\\myFile.txt");
        if (!file.check(file))
            Assertions.fail("Path exists ");
    }
}

*/
