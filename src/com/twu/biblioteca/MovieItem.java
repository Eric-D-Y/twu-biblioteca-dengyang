package com.twu.biblioteca;

import java.util.List;

/**
 * Created by eric on 3/5/16.
 */
public class MovieItem implements Comparable<MovieItem> {

    private String name = "default";
    private int year = 2010;
    private String director = "default";
    private int rating = 5;

    public MovieItem(String name, String director, int year, int rating) {
        this.setName(name);
        this.setDirector(director);
        this.setYear(year);
        this.setRating(rating);
    }

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

    @Override
    public int compareTo(MovieItem movieItem) {
        if(this.equals(movieItem)){
            return 0;
        }else{
            return -1;
        }
    }
}
