package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Represents a game in The Gaming Room application.
 * Game inherits id and name from Entity.
 */
public class Game extends Entity {

    // Stores the teams that belong to this game.
    private List<Team> teams = new ArrayList<Team>();

    /**
     * Creates a game with a unique id and name.
     *
     * @param id unique game identifier
     * @param name game name
     */
    public Game(long id, String name) {
        super(id, name);
    }

    /**
     * Adds a team to the game.
     * If the team already exists, return the existing team.
     *
     * @param name team name
     * @return new or existing team
     * @throws IllegalArgumentException if the name is null or blank
     */
    public Team addTeam(String name) {

        // Reject names that cannot identify a team. Storing a null name would
        // cause every later name comparison to fail with a NullPointerException.
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Team name must not be null or blank.");
        }

        // Surrounding spaces are removed so " Team A " and "Team A" are the same name.
        String teamName = name.trim();

        // Use the iterator pattern to look for an existing team with the same name.
        Iterator<Team> teamIterator = teams.iterator();

        while (teamIterator.hasNext()) {

            Team existingTeam = teamIterator.next();

            if (existingTeam.getName().equalsIgnoreCase(teamName)) {
                return existingTeam;
            }
        }

        // No match was found, so ask the singleton service for a unique team id.
        GameService service = GameService.getInstance();

        Team team = new Team(service.getNextTeamId(), teamName);

        teams.add(team);

        return team;
    }

    @Override
    public String toString() {
        return "Game [id=" + getId() + ", name=" + getName() + "]";
    }
}
