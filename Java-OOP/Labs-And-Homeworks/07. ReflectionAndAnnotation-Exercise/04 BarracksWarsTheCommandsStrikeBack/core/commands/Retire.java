package BarracksWarsTheCommandsStrikeBack_4.core.commands;

import BarracksWarsTheCommandsStrikeBack_4.interfaces.Repository;
import BarracksWarsTheCommandsStrikeBack_4.interfaces.UnitFactory;

public class Retire extends Command {
    public Retire(String[] date, Repository repository, UnitFactory unitFactory) {
        super(date, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = super.getDate()[1];
        super.getRepository().removeUnit(unitType);
        return unitType + " retired!";
    }
}
