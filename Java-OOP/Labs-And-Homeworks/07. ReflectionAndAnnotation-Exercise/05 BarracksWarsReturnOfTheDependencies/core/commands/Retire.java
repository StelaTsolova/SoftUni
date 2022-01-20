package BarracksWarsReturnOfTheDependencies_5.core.commands;

import BarracksWarsReturnOfTheDependencies_5.interfaces.Executable;
import BarracksWarsReturnOfTheDependencies_5.interfaces.Inject;
import BarracksWarsReturnOfTheDependencies_5.interfaces.Repository;

public class Retire implements Executable {
    @Inject
    private String[] date;
    @Inject
    private Repository repository;

    public Retire() {

    }

    @Override
    public String execute() {
        String unitType = this.date[1];
        this.repository.removeUnit(unitType);
        return unitType + " retired!";
    }
}
