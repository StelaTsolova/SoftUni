package MilitaryElite_6.Classes;

import MilitaryElite_6.Interfaces.LieutenantGeneral;
import MilitaryElite_6.Interfaces.Private;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private List<Private> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    @Override
    public void addPrivate(Private priv) {
        this.privates.add(priv);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Name: %s %s Id: %d Salary: %.2f"
                , super.getFirstName(), super.getLastName(), super.getId(), super.getSalary()));
        if (!privates.isEmpty()) {
            stringBuilder.append(System.lineSeparator()).append("Privates:");
            privates.sort(Comparator.comparingInt(Private::getId).reversed());
            privates.forEach(p -> stringBuilder.append(System.lineSeparator()).append(p));
        }
        return stringBuilder.toString();
    }
}