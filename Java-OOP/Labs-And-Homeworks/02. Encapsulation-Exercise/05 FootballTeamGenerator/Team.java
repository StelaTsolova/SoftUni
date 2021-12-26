package FootballTeamGenerator_5;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String namePlayer) {
        int startSize = this.players.size();
        for (Player player : this.players) {
            if (player.getName().equals(namePlayer)) {
                this.players.remove(player);
                break;
            }
        }
        if (startSize == this.players.size()) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", namePlayer, this.name));
        }
    }

    public double getRating() {
        return this.players.stream().mapToDouble(Player::overallSkillLevel).sum();
    }
}