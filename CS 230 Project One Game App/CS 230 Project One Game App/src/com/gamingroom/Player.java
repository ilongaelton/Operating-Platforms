package com.gamingroom;

/**
 * Represents a player in the game.
 * Player inherits the common id and name attributes from Entity.
 */
public class Player extends Entity {

    /**
     * Creates a player with a unique id and name.
     *
     * @param id unique player identifier
     * @param name player name
     */
    public Player(long id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return "Player [id=" + getId() + ", name=" + getName() + "]";
    }
}
