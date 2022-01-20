package BarracksWarsANewFactory_3;

import BarracksWarsANewFactory_3.interfaces.Repository;
import BarracksWarsANewFactory_3.interfaces.Runnable;
import BarracksWarsANewFactory_3.interfaces.UnitFactory;
import BarracksWarsANewFactory_3.core.Engine;
import BarracksWarsANewFactory_3.core.factories.UnitFactoryImpl;
import BarracksWarsANewFactory_3.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
