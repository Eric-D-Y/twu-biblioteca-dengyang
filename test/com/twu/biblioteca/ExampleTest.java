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
    public void test_getWelcomeString() {
        assertEquals("Welcome Eric!", bibliotecaApp.getWelcomeString("Eric"));
    }

    @Test
    public void test_getBooksList() {
        assertEquals("book1,book2,book3,...", bibliotecaApp.getBooksList());
    }

    @Test
    public void test_getAllBooksDetails() {
        assertEquals("Author\tYear\t" + "Eric\t2016\t", bibliotecaApp.getAllBooksDetails());
    }

    @Test
    public void test_getMainMenu() {
        assertEquals("Main Menu\n"
                + "=============> List Books\n"
                + "=============> Quit\n", bibliotecaApp.getMainMenu());
    }

    @Test
    public void test_isMenuSelectedValid() {
        assertFalse(bibliotecaApp.isMenuSelectedValid("invalid menu"));
        assertTrue(bibliotecaApp.isMenuSelectedValid("List Books"));
    }

    @Test
    public void test_isQuit() {
        assertFalse(bibliotecaApp.isQuit("invalid menu"));
        assertTrue(bibliotecaApp.isQuit("Quit"));
    }

    @Test
    public void test_checkoutBooks() {
        assertEquals("book1,book2,book3,...", bibliotecaApp.checkoutBooks("book5"));
        assertEquals("book2,book3,...", bibliotecaApp.checkoutBooks("book1"));
    }

    @Test
    public void test_returnBooks() {
        assertEquals("book1,book2,book3,...", bibliotecaApp.returnBooks("book1"));
    }

    @Test
    public void test_isReturnSuccessful() {
        assertFalse(bibliotecaApp.isReturnSuccessful("book1"));
        assertTrue(bibliotecaApp.isReturnSuccessful("book5"));
    }

    @Test
    public void test_getAvaliableMovies(){
        assertEquals("movie1,movie2,movie3,...",bibliotecaApp.getAvaliableMovies());
    }

}