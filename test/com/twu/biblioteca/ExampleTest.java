package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by eric on 3/5/16.
 */
public class ExampleTest {

    private BibliotecaApp bibliotecaApp;

    @Before
    public void setUp() throws Exception {
        bibliotecaApp = new BibliotecaApp();
    }

    @Test
    public void test_getWelcomeString(){
        assertEquals("nullable object method","Eric",bibliotecaApp.getWelcomeString("Eric"));
    }

}