package org.example;
import java.util.HashSet;
import java.util.Scanner;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) {

        RaterSystem raterSystem = new RaterSystem();
        Scanner input = new Scanner(System.in);

        boolean running = true;
        // Loop for use until user decides to quit
        while (running) {
            System.out.println("Please enter an option:");
            System.out.println("1. Add User");
            System.out.println("2. Rate Movie");
            System.out.println("3. Show User's Rated Movies");
            System.out.println("4. Show User List");
            System.out.println("5. Show Movie List");
            System.out.println("6. Get Recommended Movies");
            System.out.println("7. Exit");

            if (input.hasNextInt()) {
                int optionChoice = input.nextInt();
                input.nextLine();

                //Switch case to determine user choice
                switch (optionChoice) {
                    case 1:
                        // Option 1: Add User
                        System.out.println("Please enter a user name:");
                        String userName = input.nextLine();
                        raterSystem.addUser(userName);
                        System.out.println("User Created: " + userName);
                        break;

                    case 2:
                        // Option 2: Rate Movie
                        System.out.println("Please enter your username:");
                        String userRateName = input.nextLine();

                        //change string to User
                        User ratingUser = raterSystem.getUser(userRateName);
                        //Err handling ensuring user is found
                        if (ratingUser == null) {
                            System.out.println("User not found!");
                            break;
                        }

                        System.out.println("Please enter the movie you want to rate:");
                        String ratedMovie = input.nextLine();

                        // change string to Movie
                        Movie movie = raterSystem.getMovie(ratedMovie);
                        //Err Handling ensuring user is found
                        if (movie == null) {
                            System.out.println("Movie not found.");
                            break;
                        }

                        System.out.println("Please enter the rating for " + ratedMovie + ":");

                        // Err handling to ensure rating is correct and between 1-10
                        if (input.hasNextDouble()) {
                            double rating = input.nextDouble();
                            input.nextLine();

                            if (rating > 10 || rating < 1) {
                                System.out.println("Rating must be between 1 and 10.");
                                break;
                            }

                            // Add the rating to the user's rated list
                            ratingUser.rate(movie, rating);
                            System.out.println("Movie " + ratedMovie + " rated as: " + rating + " by " + userRateName);
                        } else {
                            System.out.println("Invalid input. Please enter a valid rating between 1 and 10.");
                            input.next();
                        }
                        break;

                    case 3:
                        // Option 3: Show Rated Movies
                        System.out.println("Please enter your username:");
                        String userShowName = input.nextLine();

                        //change string to User
                        User showUser = raterSystem.getUser(userShowName);
                        //Err handlinf to ensure that user is found
                        if (showUser == null) {
                            System.out.println("User not found!");
                            break;
                        }

                        //getter for rated list
                        HashMap<Movie, Double> ratedMovies = showUser.getRatedList();
                        //Err handling ensuring user has rated movies
                        if (ratedMovies.isEmpty()) {
                            System.out.println(userShowName + " has not rated any movies yet.");
                        } else {
                            System.out.println("Showing rated movies for " + userShowName + ":");
                            for (Movie showMovie : ratedMovies.keySet()) {
                                System.out.println(showMovie.getTitle() + " - Rating: " + ratedMovies.get(showMovie));
                            }
                        }
                        break;

                    case 4:
                        // Option 4: Show User List
                        HashMap<String, User> users = raterSystem.getUsers();
                        if (users.isEmpty()) {
                            System.out.println("No users found.");
                        } else {
                            System.out.println("List of users:");
                            for (String user : users.keySet()) {
                                System.out.println(user);
                            }
                        }
                        break;

                    case 5:
                        // Option 5: Show Movie List
                        HashMap<String, Movie> movies = raterSystem.getMovies();
                        if (movies.isEmpty()) {
                            System.out.println("No movies found.");
                        } else {
                            System.out.println("List of movies:");
                            for (String listMovie : movies.keySet()) {
                                System.out.println(listMovie);
                            }
                        }
                        break;

                    case 6:
                        System.out.println("Please enter your username:");
                        String userRecommendName = input.nextLine();

                        //change string to User
                        User recommendUser = raterSystem.getUser(userRecommendName);
                        //Err handling to ensure user was found
                        if (recommendUser == null) {
                            System.out.println("User not found!");
                            break;
                        }

                        Recommendations recommendationSystem = new Recommendations(raterSystem);
                        //find rec movies
                        HashSet<Movie> recommendations = recommendationSystem.getRecommendations(recommendUser);

                        //Err handling ensuring the user has rated movies
                        if (recommendations.isEmpty()) {
                            System.out.println("No movie recommendations available.");
                        } else {
                            System.out.println("Recommended movies based on your ratings:");
                            for (Movie recommendedMovie : recommendations) {
                                System.out.println(recommendedMovie.getTitle() + " (" + recommendedMovie.getGenre() + ")");
                            }
                        }
                        break;
                    case 7:
                        // Option 6: Quit
                        //set to false to end loop
                        running = false;
                        System.out.println("Exiting the program.");
                        break;

                    default:
                        // Err handling ensuring user choice is valid
                        System.out.println("Invalid option, please try again.");
                        break;
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                input.next();
            }
        }
        input.close(); // Close the scanner
    }
}
