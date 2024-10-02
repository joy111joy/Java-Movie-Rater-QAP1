package org.example;
import java.util.HashMap;

public class User {
    public String username;
    public HashMap <Movie, Double> ratedList;

    //constructor
    public User(String username) {
        this.username = username;
        this.ratedList = new HashMap<>();
    }

    //method for user to rate movie and add it to their list of rated movies
    public void rate(Movie movie, double rating) {
        ratedList.put(movie, rating);
    }

    //getter
    public HashMap<Movie, Double> getRatedList() {
        return ratedList;
    }


}
