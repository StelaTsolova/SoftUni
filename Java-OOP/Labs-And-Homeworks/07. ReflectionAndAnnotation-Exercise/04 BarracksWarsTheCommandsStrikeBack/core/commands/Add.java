package BarracksWarsTheCommandsStrikeBack_4.core.commands;

import BarracksWarsTheCommandsStrikeBack_4.interfaces.Repository;
import BarracksWarsTheCommandsStrikeBack_4.interfaces.Unit;
import BarracksWarsTheCommandsStrikeBack_4.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public class Add extends Command {
    public Add(String[] date, Repository repository, UnitFactory unitFactory) {
        super(date, repository, unitFactory);
    }

    @Override
    public String execute() throws ExecutionControl.NotImplementedException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String unitType = getDate()[1];
        Unit unitToAdd = super.getUnitFactory().createUnit(unitType);
        super.getRepository().addUnit(unitToAdd);
        return unitType + " added!";
    }
}
