package BarracksWarsReturnOfTheDependencies_5.core.commands;

import BarracksWarsReturnOfTheDependencies_5.interfaces.Executable;
import BarracksWarsReturnOfTheDependencies_5.interfaces.Repository;
import BarracksWarsReturnOfTheDependencies_5.interfaces.UnitFactory;

public class Fight implements Executable {
    public Fight() {

    }

    @Override
    public String execute() {
        return "fight";
    }
}
