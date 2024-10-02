package org.example;
import java.util.HashMap;

public class User {
    public String username;
    public HashMap <Movie, Double> ratedList;

    public User(String username) {
        this.username = username;
        this.ratedList = new HashMap<>();
    }

    public void rate(Movie movie, double rating) {
        ratedList.put(movie, rating);
    }

    public HashMap<Movie, Double> getRatedList() {
        return ratedList;
    }


}
