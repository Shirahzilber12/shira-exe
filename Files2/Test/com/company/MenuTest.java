package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * Created by hackeru on 3/14/2017.
 */
class MenuTest {


    @Test
    void menuTest() {
        Menu.UserInterface userInterface = mock(Menu.UserInterface.class);
        Menu.userInterface = userInterface;
        when(userInterface.input()).thenReturn("1").thenReturn("3").thenThrow(new Exception());
        Menu.start();
        verify(userInterface).output("Wrong path");
    }



}