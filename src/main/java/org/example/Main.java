package org.example;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // Initialize the scanner outside the loop
        boolean running = true; // To control the loop

        while (running) { // Start a loop to keep prompting until the user decides to quit
            System.out.println("Please enter an option:");
            System.out.println("1. Add User");
            System.out.println("2. Rate Movie");
            System.out.println("3. Show User's Rated Movies");
            System.out.println("4. Quit");
            int optionChoice = input.nextInt(); // Get the user's choice

            switch (optionChoice) {
                case 1:
                    // Option 1: Add User
                    System.out.println("Please enter a user name:");
                    String userName = input.next();
                    // Logic to add user
                    System.out.println("User Created: " + userName);
                    break;

                    case 2:
                        // Option 2: Rate Movie
                        System.out.println("Please enter your username:");
                        String userRateName = input.next();
                        // Logic to rate a movie
                        System.out.println("Movie Rated by " + userRateName + "!");
                        break;

                        case 3:
                            // Option 3: Show Rated Movies
                            System.out.println("Please enter your username:");
                            String userShowName = input.next();
                            // Logic to show rated movies
                            System.out.println("Showing rated movies for " + userShowName);
                            break;

                        case 4:
                            // Option 4: Quit
                            running = false; // Set running to false to exit the loop
                            System.out.println("Exiting the program.");
                            break;

                        default:
                            // Invalid option
                            System.out.println("Invalid option, please try again.");
                            break;
                    }
                }
                input.close(); // Close the scanner when the loop ends
            }
        }
