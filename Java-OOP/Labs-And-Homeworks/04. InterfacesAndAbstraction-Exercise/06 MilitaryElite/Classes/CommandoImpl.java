package MilitaryElite_6.Classes;

import MilitaryElite_6.Interfaces.Commando;
import MilitaryElite_6.Interfaces.Mission;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private List<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public List<Mission> getMissions() {
        return Collections.unmodifiableList(this.missions);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Name: %s %s Id: %d Salary: %.2f%nCorps: %s%n"
                ,super.getFirstName(), super.getLastName(), super.getId(), super.getSalary(), super.getCorps()));

        stringBuilder.append("Missions:");
        missions.forEach(m -> stringBuilder.append(System.lineSeparator()).append(m));
        return stringBuilder.toString();
    }
}