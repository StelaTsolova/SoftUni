package guild;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.roster = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void addPlayer(Player player) {
        if (roster.size() < capacity) {
            roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                return roster.remove(player);
            }
        }
        return false;
    }

    public void promotePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                player.setRank("Member");
            }
        }
    }

    public void demotePlayer(String name){
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                player.setRank("Trial");
            }
        }
    }

    public Player[] kickPlayersByClass(String clazz) {
        Player[] removed = roster.stream().filter(p -> clazz.equals(p.getClazz())).toArray(Player[]::new);

        this.roster = roster.stream().filter(r -> !r.getClazz().equals(clazz)).collect(Collectors.toList());
        return removed;
    }

    public int count() {
        return roster.size();
    }

    public String report() {
        StringBuilder statistics = new StringBuilder();
        statistics.append(String.format("Players in the guild: %s:%n", this.name));
        this.roster.forEach(p -> statistics.append(p.toString()).append(System.lineSeparator()));
        return statistics.toString().trim();
    }
}