package org.example;
import java.util.Scanner;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) {

        RaterSystem raterSystem = new RaterSystem();
        Scanner input = new Scanner(System.in); // Initialize the scanner outside the loop
        boolean running = true; // To control the loop

        while (running) { // Start a loop to keep prompting until the user decides to quit
            System.out.println("Please enter an option:");
            System.out.println("1. Add User");
            System.out.println("2. Rate Movie");
            System.out.println("3. Show User's Rated Movies");
            System.out.println("4. Show User List");
            System.out.println("5. Show Movie List");
            System.out.println("6. Exit the Menu");

            // Check if input is an integer before calling nextInt()
            if (input.hasNextInt()) {
                int optionChoice = input.nextInt(); // Get the user's choice
                input.nextLine(); // Consume the newline character

                switch (optionChoice) {
                    case 1:
                        // Option 1: Add User
                        System.out.println("Please enter a user name:");
                        String userName = input.nextLine(); // Use nextLine() for strings
                        raterSystem.addUser(userName);
                        System.out.println("User Created: " + userName);
                        break;

                    case 2:
                        // Option 2: Rate Movie
                        System.out.println("Please enter your username:");
                        String userRateName = input.nextLine(); // Use nextLine() for strings

                        User ratingUser = raterSystem.getUser(userRateName);
                        if (ratingUser == null) {  // Check if user is null (user not found)
                            System.out.println("User not found!");
                            break;
                        }

                        System.out.println("Please enter the movie you want to rate:");
                        String ratedMovie = input.nextLine(); // Use nextLine() for strings

                        Movie movie = raterSystem.getMovie(ratedMovie);
                        if (movie == null) {  // Check if movie is null (movie not found)
                            System.out.println("Movie not found.");
                            break;
                        }

                        System.out.println("Please enter the rating for " + ratedMovie + ":");

                        // Check if input is a double before calling nextDouble()
                        if (input.hasNextDouble()) {
                            double rating = input.nextDouble();
                            input.nextLine(); // Consume the newline character

                            if (rating > 10 || rating < 1) {  // Validate the rating is within the correct range
                                System.out.println("Rating must be between 1 and 10.");
                                break;
                            }

                            // Add the rating to the user's rated list
                            ratingUser.rate(movie, rating);
                            System.out.println("Movie " + ratedMovie + " rated as: " + rating + " by " + userRateName);
                        } else {
                            System.out.println("Invalid input. Please enter a valid rating between 1 and 10.");
                            input.next(); // Consume invalid input
                        }
                        break;

                    case 3:
                        // Option 3: Show Rated Movies
                        System.out.println("Please enter your username:");
                        String userShowName = input.nextLine(); // Use nextLine() for strings

                        User showUser = raterSystem.getUser(userShowName);
                        if (showUser == null) {  // Check if user is null (user not found)
                            System.out.println("User not found!");
                            break;
                        }

                        HashMap<Movie, Double> ratedMovies = showUser.getRatedList(); // Get the rated movies list
                        if (ratedMovies.isEmpty()) {
                            System.out.println(userShowName + " has not rated any movies yet.");
                        } else {
                            System.out.println("Showing rated movies for " + userShowName + ":");
                            for (Movie showMovie : ratedMovies.keySet()) {  // Loop through the rated movies
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
                        // Option 6: Quit
                        running = false; // Set running to false to exit the loop
                        System.out.println("Exiting the program.");
                        break;

                    default:
                        // Invalid option
                        System.out.println("Invalid option, please try again.");
                        break;
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                input.next(); // Consume invalid input
            }
        }
        input.close(); // Close the scanner when the loop ends
    }
}
