package com.twu.biblioteca;

import java.util.*;

/**
 * Created by eric on 3/5/16.
 */
public class BibliotecaApp {

    private List<BookItem> allBooks;
    private BookItem book1;
    private BookItem book2;

    private List<MovieItem> allMovies;
    private MovieItem movie1;
    private MovieItem movie2;

    private List<UserItem> allUsers;
    private UserItem user1;
    private UserItem user2;

    public BibliotecaApp() {
        book1 = new BookItem("title1", "author1", 2010);
        book2 = new BookItem("title2", "author2", 2011);
        allBooks = new ArrayList<BookItem>();
        allBooks.add(book1);
        allBooks.add(book2);
        Collections.sort(allBooks, booksComparator);

        movie1 = new MovieItem("name1", "director1", 2010, 3);
        movie2 = new MovieItem("name2", "director2", 2013, 7);
        allMovies = new ArrayList<MovieItem>();
        allMovies.add(movie1);
        allMovies.add(movie2);
        Collections.sort(allMovies, movieComparator);

        user1=new UserItem("000-0001","pwd1","name1","111@qq.com","123456");
        user2=new UserItem("000-0002","pwd2","name2","222@qq.com","234567");
        allUsers=new ArrayList<UserItem>();
        allUsers.add(user1);
        allUsers.add(user2);
        Collections.sort(allUsers,userComparator);
    }

    Comparator<? super UserItem> userComparator=new Comparator<UserItem>() {
        @Override
        public int compare(UserItem userItem, UserItem t1) {
            return userItem.compareTo(t1);
        }
    };

    Comparator<? super BookItem> booksComparator = new Comparator<BookItem>() {
        @Override
        public int compare(BookItem bookItem, BookItem t1) {
            return bookItem.compareTo(t1);
        }
    };

    Comparator<? super MovieItem> movieComparator = new Comparator<MovieItem>() {
        @Override
        public int compare(MovieItem movieItem, MovieItem t1) {
            return movieItem.compareTo(t1);
        }
    };

    public List<MovieItem> getAvailableMovies() {
        return allMovies;
    }

    public String getWelcomeString(String name) {
        return "Welcome " + name + "!";
    }

    public List<BookItem> getBooksList() {
        return allBooks;
    }

    public String getAllBooksDetails() {
        String result = "Title\tAuthor\tYear\t";
        for (BookItem item : allBooks) {
            result += "\n" + item.getTitle() + "\t" + item.getAuthor() + "\t" + item.getYear();
        }
        return result;
    }

    public String getMainMenu() {
        return "Main Menu\n"
                + "=============> List Books\n"
                + "=============> Quit\n";
    }

    public boolean isMenuSelectedValid(String menuSelected) {
        switch (menuSelected) {
            case "List Books":
            case "Quit":
                return true;
        }
        return false;
    }

    public boolean isQuit(String menuSelected) {
        if (menuSelected.equals("Quit")) {
            return true;
        } else {
            return false;
        }
    }

    public List<BookItem> checkoutBooks(BookItem bookToCheckout) {
        if (isBookCheckoutSuccessful(bookToCheckout)) {
            allBooks.remove(bookToCheckout);
        }
        return allBooks;
    }


    public List<BookItem> returnBooks(BookItem bookToReturn) {
        if (isBookReturnSuccessful(bookToReturn)) {
            allBooks.add((bookToReturn));
        }
        return allBooks;
    }

    public boolean isBookReturnSuccessful(BookItem bookToReturn) {
        if (allBooks.contains(bookToReturn)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isBookCheckoutSuccessful(BookItem bookToCheckout) {
        return allBooks.contains(bookToCheckout);
    }

    public MovieItem checkOutMovie(MovieItem movieTocheckOut) {
        if (allMovies.contains(movieTocheckOut)) {
            allMovies.remove(movieTocheckOut);
            return movieTocheckOut;
        } else {
            return null;
        }
    }

    public boolean checkUserInfo(String userName,String userPwd){
        for(UserItem user:allUsers){
            if(user.checkUserInfo(userName,userPwd)){
                return true;
            }
        }
        return false;
    }

    public String getUserInfo(UserItem user){
        return user.getUserInfo();
    }

}
