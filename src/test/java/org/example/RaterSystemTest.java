package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RaterSystemTest {

    //Test to add user to the system
    @Test
    public void testAddUser() {
        RaterSystem raterSystem = new RaterSystem();
        raterSystem.addUser("John");

        // Check if the user was added
        assertNotNull(raterSystem.getUser("John"));
        assertEquals("John", raterSystem.getUser("John").getName());
    }

    //test adding an existing user to the sstem
    @Test
    public void testAddExistingUser() {
        RaterSystem raterSystem = new RaterSystem();
        raterSystem.addUser("Alice");

        // Try to add a user with the same name
        raterSystem.addUser("Alice");

        // Ensure that no duplicate users were created (assuming you handle duplicates)
        assertEquals(1, raterSystem.getUsers().size());
    }

    //test rating movie
    @Test
    public void testRateMovie() {
        RaterSystem raterSystem = new RaterSystem();
        User user = new User("Bob");
        Movie movie = new Movie("Inception", "Sci-Fi");

        // Simulate rating the movie
        user.rate(movie, 8.5);

        // Ensure the movie is added to the user's rated list
        assertTrue(user.getRatedList().containsKey(movie));
        assertEquals(8.5, user.getRatedList().get(movie));
    }

    //test invalid ratings
    @Test
    public void testInvalidRating() {
        RaterSystem raterSystem = new RaterSystem();
        User user = new User("Bob");
        Movie movie = new Movie("Inception", "Sci-Fi");

        // Simulate rating the movie with an invalid score
        user.rate(movie, 15);

        // Ensure that the rating is not accepted (assuming you have validation in place)
        assertFalse(user.getRatedList().containsKey(movie));
    }

    //check if user finds users
    @Test
    public void testGetUserList() {
        RaterSystem raterSystem = new RaterSystem();
        raterSystem.addUser("Alice");
        raterSystem.addUser("Bob");

        // Ensure the user list contains both users
        assertEquals(2, raterSystem.getUsers().size());
        assertTrue(raterSystem.getUsers().containsKey("Alice"));
        assertTrue(raterSystem.getUsers().containsKey("Bob"));
    }

    //Check if user list is empty
    @Test
    public void testEmptyUserList() {
        RaterSystem raterSystem = new RaterSystem();

        // Ensure that the user list is empty
        assertTrue(raterSystem.getUsers().isEmpty());
    }

    //Check if movie list contains movies
    @Test
    public void testGetMovieList() {
        RaterSystem raterSystem = new RaterSystem();
        raterSystem.addMovie("Deadpool", "Action");
        raterSystem.addMovie("Martian", "Sci-Fi");
        raterSystem.addMovie("Borat", "Comedy");


        // Ensure the movie list contains both new and pre-made movies
        assertEquals(20, raterSystem.getMovies().size());
        assertTrue(raterSystem.getMovies().containsKey("Deadpool"));
        assertTrue(raterSystem.getMovies().containsKey("Martian"));
        assertTrue(raterSystem.getMovies().containsKey("Borat"));
    }


}

