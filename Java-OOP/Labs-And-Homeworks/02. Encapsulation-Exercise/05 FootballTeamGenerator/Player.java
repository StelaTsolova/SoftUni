package FootballTeamGenerator_5;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
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

    private void setEndurance(int endurance) {
        chekRangeAndTrowExaction(endurance, "Endurance");
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        chekRangeAndTrowExaction(sprint, "Sprint");
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
        chekRangeAndTrowExaction(dribble, "Dribble");
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        chekRangeAndTrowExaction(passing, "Passing");
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        chekRangeAndTrowExaction(shooting, "Shooting");
        this.shooting = shooting;
    }

    private void chekRangeAndTrowExaction(int stat, String stateName) {
        if (stat < 0 || stat > 100) {
            throw new IllegalArgumentException(stateName + " should be between 0 and 100.");
        }
    }

    public double overallSkillLevel() {
        return ((double) endurance + sprint + dribble + passing + shooting) / 5;
    }
}