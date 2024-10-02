package org.example;

public class Movie {
    public String title;
    public String genre;

    //constructor
    public Movie (String title, String genre) {
        this.title = title;
        this.genre = genre;
    }

    //getters
    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }


}
