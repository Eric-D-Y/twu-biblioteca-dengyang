package com.twu.biblioteca;

/**
 * Created by eric on 3/5/16.
 */
public class BibliotecaApp {

    private String allBooks = "book1,book2,book3,...";

    public String getWelcomeString(String name) {
        return "Welcome " + name + "!";
    }

    public String getBooksList() {
        return allBooks;
    }

    public String getAllBooksDetails() {
        return "Author\tYear\t" + "Eric\t2016\t";
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

    public String checkoutBooks(String bookToCheckout) {
        if (isCheckoutSuccessful(bookToCheckout)) {
            return allBooks.replace(bookToCheckout + ",", "");
        } else {
            return allBooks;
        }
    }

    public String returnBooks(String bookToReturn) {
        if (!isReturnSuccessful(bookToReturn)) {
            return allBooks;
        } else {
            return bookToReturn + "," + bookToReturn;
        }
    }

    public boolean isReturnSuccessful(String bookToReturn) {
//        System.out.print(allBooks+"       "+bookToReturn+"\n");
        if (allBooks.contains(bookToReturn)) {
            return false;
        } else {
            return true;
        }
    }

    public boolean isCheckoutSuccessful(String bookToCheckout) {
        return allBooks.contains(bookToCheckout);
    }

}
