package com.gamingroom;

/**
 * Base class for all entities in the game application.
 * Games, teams, and players share an identifier and a name.
 */
public class Entity {

    private long id;
    private String name;

    /**
     * Default constructor.
     */
    protected Entity() {
    }

    /**
     * Creates an entity with a unique identifier and name.
     *
     * @param id unique identifier
     * @param name entity name
     */
    public Entity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Entity [id=" + id + ", name=" + name + "]";
    }
}