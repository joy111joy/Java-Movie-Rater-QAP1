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
        movies.put("The Matrix", new Movie("The Matrix", "Sci-Fi"));
        movies.put("The Shawshank Redemption", new Movie("The Shawshank Redemption", "Drama"));
        movies.put("The Godfather", new Movie("The Godfather", "Crime"));
        movies.put("The Dark Knight", new Movie("The Dark Knight", "Action"));
        movies.put("Pulp Fiction", new Movie("Pulp Fiction", "Crime"));
        movies.put("Fight Club", new Movie("Fight Club", "Drama"));
        movies.put("Forrest Gump", new Movie("Forrest Gump", "Drama"));
        movies.put("The Lord of the Rings: The Fellowship of the Ring", new Movie("The Lord of the Rings: The Fellowship of the Ring", "Fantasy"));
        movies.put("The Avengers", new Movie("The Avengers", "Action"));
        movies.put("Interstellar", new Movie("Interstellar", "Sci-Fi"));
        movies.put("Gladiator", new Movie("Gladiator", "Action"));
        movies.put("The Lion King", new Movie("The Lion King", "Animation"));
        movies.put("Jurassic Park", new Movie("Jurassic Park", "Adventure"));
        movies.put("Star Wars: A New Hope", new Movie("Star Wars: A New Hope", "Sci-Fi"));
        movies.put("Braveheart", new Movie("Braveheart", "Historical"));

    }

    public void addUser(String userName) {
        if (!users.containsKey(userName)) {
            users.put(userName, new User(userName));
            System.out.println("User " + userName + " created!");
        } else {
            System.out.println("User " + userName + " already exists.");
        }
    }

    public void addMovie(String movieName, String genre) {
        if (!movies.containsKey(movieName)) {
            movies.put(movieName, new Movie(movieName, genre));
            System.out.println("Movie " + movieName + " created!");
        } else {
            System.out.println("Movie " + movieName + " already exists.");
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

    public HashMap<String, Movie> getMovies() {
        return movies;
    }
}

