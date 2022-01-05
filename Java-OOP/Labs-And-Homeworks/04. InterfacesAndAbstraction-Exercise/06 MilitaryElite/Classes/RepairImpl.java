package MilitaryElite_6.Classes;

import MilitaryElite_6.Interfaces.Repair;

public class RepairImpl implements Repair {
    private String partName;
    private int hoursWorked;

    public RepairImpl(String partName, int hoursWorked) {
        this.partName = partName;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String getPartName() {
        return null;
    }

    @Override
    public int hoursWorked() {
        return 0;
    }

    public String toString() {
        return String.format("  Part Name: %s Hours Worked: %d", this.partName, this.hoursWorked);
    }
}