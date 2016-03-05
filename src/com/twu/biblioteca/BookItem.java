package com.twu.biblioteca;

import java.awt.print.Book;

/**
 * Created by eric on 3/5/16.
 */
public class BookItem {

    private String author = "default";
    private String title = "default";
    private int year = 2016;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        BookItem item = (BookItem) o;
        return item.getAuthor().equals(item.getAuthor())
                && item.getTitle().equals((item.getTitle()))
                && item.getYear() == item.getYear();
    }
}
