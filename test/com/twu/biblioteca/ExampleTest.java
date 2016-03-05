package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by eric on 3/5/16.
 */
public class ExampleTest {

    private BibliotecaApp bibliotecaApp;

    private List<BookItem> books;
    private BookItem book1;
    private BookItem book2;
    private BookItem book_tmp;

    private List<MovieItem> movies;
    private MovieItem movie1;
    private MovieItem movie2;
    private MovieItem movie_tmp;

    @Before
    public void setUp() throws Exception {
        bibliotecaApp = new BibliotecaApp();

        book1 = new BookItem("title1", "author1", 2010);
        book2 = new BookItem("title2", "author2", 2011);
        book_tmp = new BookItem("title_tmp", "author_tmp", 100000);
        books = new ArrayList<BookItem>();
        books.add(book1);
        books.add(book2);

        movie1 = new MovieItem("name1", "director1", 2010, 3);
        movie2 = new MovieItem("name2", "director2", 2013, 7);
        movie_tmp = new MovieItem("name_tmp", "director_tmp", 100000, 0);
        movies = new ArrayList<MovieItem>();
        movies.add(movie1);
        movies.add(movie2);
    }

    @Test
    public void test_getWelcomeString() {
        assertEquals("Welcome Eric!", bibliotecaApp.getWelcomeString("Eric"));
    }

    @Test
    public void test_getBooksList() {
        assertEquals(books, bibliotecaApp.getBooksList());
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
        assertEquals(books, bibliotecaApp.checkoutBooks(book_tmp));
        assertEquals(books, bibliotecaApp.checkoutBooks(book1));
    }

    @Test
    public void test_returnBooks() {

        assertEquals(books, bibliotecaApp.returnBooks(book1));
    }

    @Test
    public void test_isBookReturnSuccessful() {
        assertFalse(bibliotecaApp.isBookReturnSuccessful(book1));
        assertTrue(bibliotecaApp.isBookReturnSuccessful(book_tmp));
    }

    @Test
    public void test_getAvaliableMovies() {
        assertEquals(movies, bibliotecaApp.getAvailableMovies());
    }

}