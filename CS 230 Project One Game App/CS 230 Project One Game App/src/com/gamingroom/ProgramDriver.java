package com.gamingroom;

/**
 * Application entry point for the Draw It or Lose It prototype.
 *
 * The main method exercises the client's four software requirements:
 * a game may hold one or more teams, each team holds multiple players,
 * game and team names are unique, and only one GameService instance
 * exists in memory at any given time.
 */
public class ProgramDriver {

    public static void main(String[] args) {

        // Obtain reference to the singleton instance.
        GameService service = GameService.getInstance();

        System.out.println("\nAbout to test initializing game data...");

        // Requirement: a game will have the ability to have one or more teams.
        Game game1 = service.addGame("Game #1");
        System.out.println(game1);

        Game game2 = service.addGame("Game #2");
        System.out.println(game2);

        // Requirement: game names must be unique. Adding a duplicate name
        // returns the existing game rather than creating a second one.
        Game duplicateGame = service.addGame("Game #1");
        System.out.println(duplicateGame);

        System.out.println("\nAbout to test team and player data...");

        // Requirement: each team will have multiple players assigned to it.
        Team team1 = game1.addTeam("Team Alpha");
        System.out.println(team1);

        Player player1 = team1.addPlayer("Elton");
        System.out.println(player1);

        System.out.println(team1.addPlayer("Jordan"));

        Team team2 = game1.addTeam("Team Bravo");
        System.out.println(team2);

        System.out.println(team2.addPlayer("Riley"));

        // Unique identifiers continue across games, teams, and players.
        Team team3 = game2.addTeam("Team Charlie");
        System.out.println(team3);

        System.out.println(team3.addPlayer("Casey"));

        System.out.println("\nAbout to test unique name enforcement...");

        // Requirement: team names must be unique within a game. Adding a name
        // that is already in use returns the existing team instead of a new one.
        Team duplicateTeam = game1.addTeam("Team Alpha");
        System.out.println(duplicateTeam
                + " - existing team returned: " + (duplicateTeam == team1));

        // Requirement: player names must be unique within a team.
        Player duplicatePlayer = team1.addPlayer("Elton");
        System.out.println(duplicatePlayer
                + " - existing player returned: " + (duplicatePlayer == player1));

        System.out.println("\nTotal games: " + service.getGameCount());

        // Test the singleton.
        SingletonTester tester = new SingletonTester();
        tester.testSingleton();
    }
}
