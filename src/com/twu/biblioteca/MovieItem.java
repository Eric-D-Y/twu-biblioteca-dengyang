package com.twu.biblioteca;

/**
 * Created by eric on 3/5/16.
 */
public class MovieItem {

    private String name = "default";
    private int year = 2010;
    private String director = "default";
    private int rating = 5;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        MovieItem item = (MovieItem) o;
        return this.getName().equals(item.getName())
                && this.getYear() == item.getYear()
                && this.getDirector().equals(item.getDirector())
                && this.getRating() == item.getRating();
    }
}
