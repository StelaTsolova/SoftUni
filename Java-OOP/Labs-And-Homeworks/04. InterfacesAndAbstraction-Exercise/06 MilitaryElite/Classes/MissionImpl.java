package MilitaryElite_6.Classes;

import MilitaryElite_6.Interfaces.Mission;

public class MissionImpl implements Mission {
    public enum Status {
        inProgress,
        finished
    }

    private String codeName;
    private Status state;

    public MissionImpl(String codeName, Status state) {
        this.codeName = codeName;
        this.state = state;
    }

    @Override
    public void completeMission() {
        this.state = Status.finished;
    }

    @Override
    public String toString() {
        return String.format("  Code Name: %s State: %s", this.codeName, this.state);
    }
}