package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Singleton service that manages games and unique identifiers.
 *
 * The Singleton pattern ensures that only one GameService object
 * exists in the application. This provides one central location
 * for managing games, teams, players, and their unique IDs.
 */
public class GameService {

    // Stores all active games.
    private static List<Game> games = new ArrayList<Game>();

    // Unique identifiers.
    private static long nextGameId = 1;
    private static long nextTeamId = 1;
    private static long nextPlayerId = 1;

    // The single GameService instance.
    private static GameService service = null;

    /**
     * Private constructor prevents other classes from creating
     * additional GameService objects.
     */
    private GameService() {
    }

    /**
     * Returns the one and only GameService instance.
     *
     * @return singleton GameService instance
     */
    public static GameService getInstance() {

        if (service == null) {
            service = new GameService();
        }

        return service;
    }

    /**
     * Adds a game if a game with the same name does not already exist.
     *
     * @param name unique game name
     * @return new or existing game
     * @throws IllegalArgumentException if the name is null or blank
     */
    public Game addGame(String name) {

        // Reject names that cannot identify a game. Storing a null name would
        // cause every later name comparison to fail with a NullPointerException.
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Game name must not be null or blank.");
        }

        // Surrounding spaces are removed so " Game #1 " and "Game #1" are the same name.
        String gameName = name.trim();

        // Use the iterator pattern to look for an existing game with the same name.
        Iterator<Game> gameIterator = games.iterator();

        while (gameIterator.hasNext()) {

            Game existingGame = gameIterator.next();

            // Names are compared without case so "Game #1" and "game #1" match.
            if (existingGame.getName().equalsIgnoreCase(gameName)) {
                return existingGame;
            }
        }

        // No match was found, so create a new game with a unique identifier.
        Game game = new Game(nextGameId++, gameName);

        games.add(game);

        return game;
    }

    /**
     * Returns a game using its position in the list.
     *
     * @param index position of the game
     * @return game at the specified index
     */
    public Game getGame(int index) {

        return games.get(index);
    }

    /**
     * Finds a game using its unique ID.
     *
     * @param id game identifier
     * @return matching game or null
     */
    public Game getGame(long id) {

        // Use the iterator pattern to look for an existing game with the same id.
        Iterator<Game> gameIterator = games.iterator();

        while (gameIterator.hasNext()) {

            Game game = gameIterator.next();

            if (game.getId() == id) {
                return game;
            }
        }

        return null;
    }

    /**
     * Finds a game using its unique name.
     *
     * @param name game name
     * @return matching game or null
     */
    public Game getGame(String name) {

        // Use the iterator pattern to look for an existing game with the same name.
        Iterator<Game> gameIterator = games.iterator();

        while (gameIterator.hasNext()) {

            Game game = gameIterator.next();

            if (game.getName().equalsIgnoreCase(name)) {
                return game;
            }
        }

        return null;
    }

    /**
     * Returns the number of active games.
     *
     * @return number of games
     */
    public int getGameCount() {

        return games.size();
    }

    /**
     * Returns the next unique team identifier.
     *
     * @return unique team ID
     */
    public long getNextTeamId() {

        return nextTeamId++;
    }

    /**
     * Returns the next unique player identifier.
     *
     * @return unique player ID
     */
    public long getNextPlayerId() {

        return nextPlayerId++;
    }
}
