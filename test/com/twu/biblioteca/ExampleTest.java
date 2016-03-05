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

    private UserItem user1;
    private UserItem user2;

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

        user1 = new UserItem("000-0001", "pwd1", "name1", "111@qq.com", "123456");
        user2 = new UserItem("000-0002", "pwd2", "name2", "222@qq.com", "234567");
    }

    @Test
    public void test_getWelcomeString() {
        assertEquals("getWlecomeString()", "Welcome Eric!", bibliotecaApp.getWelcomeString("Eric"));
    }

    @Test
    public void test_getBooksList() {
        List<BookItem> actualResult = bibliotecaApp.getBooksList();
        assertTrue("getBooksList()", books.containsAll(actualResult) && actualResult.containsAll(books));
    }

    @Test
    public void test_getAllBooksDetails() {
        String expectedResult = "Title\tAuthor\tYear\t" + "\ntitle1\tauthor1\t2010" + "\ntitle2\tauthor2\t2011";
        assertEquals("getAllBooksDetails()", expectedResult, bibliotecaApp.getAllBooksDetails());
    }

    @Test
    public void test_getMainMenu() {
        assertEquals("getMainMenu()", "Main Menu\n"
                + "=============> List Books\n"
                + "=============> Quit\n", bibliotecaApp.getMainMenu());
    }

    @Test
    public void test_isMenuSelectedValid() {
        assertFalse("isMenuSelectedValid()", bibliotecaApp.isMenuSelectedValid("invalid menu"));
        assertTrue("isMenuSelectedValid()", bibliotecaApp.isMenuSelectedValid("List Books"));
    }

    @Test
    public void test_isQuit() {
        assertFalse("isQuit()", bibliotecaApp.isQuit("invalid menu"));
        assertTrue("isQuit()", bibliotecaApp.isQuit("Quit"));
    }

    @Test
    public void test_checkoutBooks() {
        List<BookItem> actualBooks;
        actualBooks = bibliotecaApp.checkoutBooks(book_tmp);
        assertTrue("checkoutBooks()", books.containsAll(actualBooks) && actualBooks.containsAll(books));
        actualBooks = bibliotecaApp.checkoutBooks(book1);
        assertFalse("checkoutBooks()", books.containsAll(actualBooks) && actualBooks.containsAll(books));
    }

    @Test
    public void test_returnBooks() {

        assertEquals("returnBooks()", books, bibliotecaApp.returnBooks(book1));
    }

    @Test
    public void test_isBookReturnSuccessful() {
        assertFalse("isBookReturnSuccessful()", bibliotecaApp.isBookReturnSuccessful(book1));
        assertFalse("isBookReturnSuccessful()", bibliotecaApp.isBookReturnSuccessful(book_tmp));
    }

    @Test
    public void test_getAvaliableMovies() {
        List<MovieItem> actualResult;
        actualResult = bibliotecaApp.getAvailableMovies();
        assertTrue("getAvaliableMovies()", movies.containsAll(actualResult) && actualResult.containsAll(movies));
    }

    @Test
    public void test_checkOutMoive() {
        assertEquals("checkOutMovie()", null, bibliotecaApp.checkOutMovie(movie_tmp));
        assertEquals("checkOutMovie()", movie1, bibliotecaApp.checkOutMovie(movie1));
    }

    @Test
    public void test_checkUserInfo() {
        assertFalse("checkUserInfo()", bibliotecaApp.checkUserInfo(user1.getName(), "pwd_false"));
        assertTrue("checkUserInfo()", bibliotecaApp.checkUserInfo(user1.getName(), "pwd1"));
    }

    @Test
    public void test_getUserInfo() {
        assertNull("getUserInfo()", bibliotecaApp.getUserInfo(user2));
        String acRes1 = "name:\t" + "name1" + "email:\t" + "111@qq.com" + "phone:\t" + "123456";
        assertNull("getUserInfo()", bibliotecaApp.getUserInfo(user1));
        user1.checkUserInfo(user1.getName(), "pwd1");
        assertEquals("getUserInfo()", acRes1, bibliotecaApp.getUserInfo(user1));
    }

}