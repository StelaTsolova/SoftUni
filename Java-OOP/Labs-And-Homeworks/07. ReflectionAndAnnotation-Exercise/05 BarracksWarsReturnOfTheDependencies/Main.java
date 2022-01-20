package BarracksWarsReturnOfTheDependencies_5;

import BarracksWarsReturnOfTheDependencies_5.core.CommandInterpreterImpl;
import BarracksWarsReturnOfTheDependencies_5.core.Engine;
import BarracksWarsReturnOfTheDependencies_5.core.factories.UnitFactoryImpl;
import BarracksWarsReturnOfTheDependencies_5.data.UnitRepository;
import BarracksWarsReturnOfTheDependencies_5.interfaces.Repository;
import BarracksWarsReturnOfTheDependencies_5.interfaces.Runnable;
import BarracksWarsReturnOfTheDependencies_5.interfaces.UnitFactory;

public class Main {
    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(new CommandInterpreterImpl(repository, unitFactory));
        engine.run();
    }
}
