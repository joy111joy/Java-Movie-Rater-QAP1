package org.example;
import java.util.HashMap;
import java.util.HashSet;

public class Recommendations {
    //set up rater system
    private RaterSystem raterSystem;

    //Constructor
    public Recommendations(RaterSystem raterSystem) {
        this.raterSystem = raterSystem;
    }

    // Main method to get movie recommendarions list
    public HashSet<Movie> getRecommendations(User user) {
        HashMap<Movie, Double> ratedMovies = user.getRatedList();
        HashMap<String, Integer> genreCount = new HashMap<>();
        HashSet<Movie> recommendedMovies = new HashSet<>();

        //go through each movie in user list and get gere and rating
        for (Movie movie : ratedMovies.keySet()) {
            double rating = ratedMovies.get(movie);
            String genre = movie.getGenre();

            // check if rating is good (above 7)
            if (rating >= 7) {
                //count number of movies liked in genre
                genreCount.put(genre, genreCount.getOrDefault(genre, 0) + 1);
            }
        }

        for (Movie movie : raterSystem.getMovies().values()) {
            // Check if the user hasn't rated the movie
            if (!ratedMovies.containsKey(movie)) {
                String movieGenre = movie.getGenre();

                // Recommend only if the genre is rated good
                if (genreCount.containsKey(movieGenre)) {
                    recommendedMovies.add(movie);
                }
            }
        }

        return recommendedMovies;
    }
}
