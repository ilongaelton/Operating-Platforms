package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Represents a team in the game.
 * Team inherits the common id and name attributes from Entity.
 */
public class Team extends Entity {

    // Stores the players that belong to this team.
    private List<Player> players = new ArrayList<Player>();

    /**
     * Creates a team with a unique id and name.
     *
     * @param id unique team identifier
     * @param name team name
     */
    public Team(long id, String name) {
        super(id, name);
    }

    /**
     * Adds a player to the team.
     * If the player already exists, return the existing player.
     *
     * @param name player name
     * @return new or existing player
     * @throws IllegalArgumentException if the name is null or blank
     */
    public Player addPlayer(String name) {

        // Reject names that cannot identify a player. Storing a null name would
        // cause every later name comparison to fail with a NullPointerException.
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Player name must not be null or blank.");
        }

        // Surrounding spaces are removed so " Casey " and "Casey" are the same name.
        String playerName = name.trim();

        // Use the iterator pattern to look for an existing player with the same name.
        Iterator<Player> playerIterator = players.iterator();

        while (playerIterator.hasNext()) {

            Player existingPlayer = playerIterator.next();

            if (existingPlayer.getName().equalsIgnoreCase(playerName)) {
                return existingPlayer;
            }
        }

        // No match was found, so ask the singleton service for a unique player id.
        GameService service = GameService.getInstance();

        Player player = new Player(service.getNextPlayerId(), playerName);

        players.add(player);

        return player;
    }

    /**
     * Finds a player by ID.
     *
     * @param id player identifier
     * @return matching player or null
     */
    public Player getPlayer(long id) {

        // Use the iterator pattern to look for an existing player with the same id.
        Iterator<Player> playerIterator = players.iterator();

        while (playerIterator.hasNext()) {

            Player player = playerIterator.next();

            if (player.getId() == id) {
                return player;
            }
        }

        return null;
    }

    /**
     * Finds a player by name.
     *
     * @param name player name
     * @return matching player or null
     */
    public Player getPlayer(String name) {

        // Use the iterator pattern to look for an existing player with the same name.
        Iterator<Player> playerIterator = players.iterator();

        while (playerIterator.hasNext()) {

            Player player = playerIterator.next();

            if (player.getName().equalsIgnoreCase(name)) {
                return player;
            }
        }

        return null;
    }

    /**
     * Returns the number of players on this team.
     *
     * @return number of players
     */
    public int getPlayerCount() {

        return players.size();
    }

    @Override
    public String toString() {
        return "Team [id=" + getId() + ", name=" + getName() + "]";
    }
}
