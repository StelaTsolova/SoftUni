package FootballTeamGenerator_5;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Team> teams = new LinkedHashMap<>();
        Team team = null;
        while (!input.equals("END")) {
            String[] command = input.split(";");
            String teamName = command[1];
            switch (command[0]) {
                case "Team":
                    try {
                        team = new Team(teamName);
                        teams.put(teamName, team);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Add":
                    String playerName = command[2];
                    int endurance = Integer.parseInt(command[3]);
                    int sprint = Integer.parseInt(command[4]);
                    int dribble = Integer.parseInt(command[5]);
                    int passing = Integer.parseInt(command[6]);
                    int shooting = Integer.parseInt(command[7]);
                    if (teams.containsKey(teamName)) {
                        try {
                            Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                            teams.get(teamName).addPlayer(player);
                        } catch (IllegalArgumentException ex) {
                            System.out.println(ex.getMessage());
                        }
                    } else {
                        System.out.printf("Team %s does not exist.%n", teamName);
                    }
                    break;
                case "Remove":
                    playerName = command[2];
                    try {
                        teams.get(teamName).removePlayer(playerName);
                    } catch (IllegalArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                case "Rating":
                    if (teams.containsKey(teamName)) {
                        System.out.printf("%s - %d%n", teams.get(teamName).getName(), Math.round(teams.get(teamName).getRating()));
                    } else {
                        System.out.printf("Team %s does not exist.%n", teamName);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
    }
}