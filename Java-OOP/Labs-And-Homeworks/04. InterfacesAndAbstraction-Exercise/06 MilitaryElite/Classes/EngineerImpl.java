package MilitaryElite_6.Classes;

import MilitaryElite_6.Interfaces.Engineer;
import MilitaryElite_6.Interfaces.Repair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private List<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public List<Repair> getRepairs() {
        return Collections.unmodifiableList(this.repairs);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Name: %s %s Id: %d Salary: %.2f%nCorps: %s%n"
                , super.getFirstName(), super.getLastName(), super.getId(), super.getSalary(), super.getCorps()));

        stringBuilder.append("Repairs:");
        repairs.forEach(r -> stringBuilder.append(System.lineSeparator()).append(r));
        return stringBuilder.toString();
    }
}