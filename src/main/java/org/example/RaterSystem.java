package org.example;

import java.util.HashMap;

public class RaterSystem {
    private HashMap<String, User> users;
    private HashMap<String, Movie> movies;

    public RaterSystem() {
        users = new HashMap<>();
        movies = new HashMap<>();
        //starting movies
        movies.put("Inception", new Movie("Inception", "Sci-Fi"));
        movies.put("Titanic", new Movie("Titanic", "Romance"));
    }

    public void addUser(String userName) {
        if (!users.containsKey(userName)) {
            users.put(userName, new User(userName));
            System.out.println("User " + userName + " created!");
        } else {
            System.out.println("User " + userName + " already exists.");
        }
    }

    public User getUser(String userName) {
        return users.get(userName);
    }

    public Movie getMovie(String movieName) {
        return movies.get(movieName);
    }


    public HashMap<String, User> getUsers() {
        return users;
    }
    //show movies list
    //show users list *Possibly*
}

