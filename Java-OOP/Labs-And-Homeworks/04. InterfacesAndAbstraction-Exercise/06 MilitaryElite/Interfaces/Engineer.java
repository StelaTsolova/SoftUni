package MilitaryElite_6.Interfaces;

import java.util.List;

public interface Engineer extends Private {
    void addRepair(Repair repair);

    List<Repair> getRepairs();
}