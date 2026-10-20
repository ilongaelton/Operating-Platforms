package com.gamingroom;

/**
 * A class to test a singleton's behavior.
 */
public class SingletonTester {

    public void testSingleton() {

        System.out.println("\nAbout to test the singleton...");

        // Obtain reference to the singleton instance.
        GameService service = GameService.getInstance();

        // Print all games from the same GameService instance.
        for (int i = 0; i < service.getGameCount(); i++) {
            System.out.println(service.getGame(i));
        }
    }
}