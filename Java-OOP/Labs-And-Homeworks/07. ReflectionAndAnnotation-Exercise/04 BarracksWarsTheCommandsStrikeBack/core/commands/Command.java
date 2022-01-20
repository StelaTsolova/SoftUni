package BarracksWarsTheCommandsStrikeBack_4.core.commands;

import BarracksWarsTheCommandsStrikeBack_4.interfaces.Executable;
import BarracksWarsTheCommandsStrikeBack_4.interfaces.Repository;
import BarracksWarsTheCommandsStrikeBack_4.interfaces.UnitFactory;

public abstract class Command implements Executable {
    private String[] date;
    private Repository repository;
    private UnitFactory unitFactory;

    protected Command(String[] date, Repository repository, UnitFactory unitFactory) {
        this.date = date;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    public String[] getDate() {
        return date;
    }

    public Repository getRepository() {
        return repository;
    }

    public UnitFactory getUnitFactory() {
        return unitFactory;
    }
}
