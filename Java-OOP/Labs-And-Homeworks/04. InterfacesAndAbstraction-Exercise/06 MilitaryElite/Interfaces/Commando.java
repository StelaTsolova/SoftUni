package MilitaryElite_6.Interfaces;

import java.util.List;

public interface Commando extends Private {
    void addMission(Mission mission);

    List<Mission> getMissions();
}