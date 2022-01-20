package BarracksWarsTheCommandsStrikeBack_4;

import BarracksWarsTheCommandsStrikeBack_4.interfaces.Repository;
import BarracksWarsTheCommandsStrikeBack_4.interfaces.Runnable;
import BarracksWarsTheCommandsStrikeBack_4.interfaces.UnitFactory;
import BarracksWarsTheCommandsStrikeBack_4.core.Engine;
import BarracksWarsTheCommandsStrikeBack_4.core.factories.UnitFactoryImpl;
import BarracksWarsTheCommandsStrikeBack_4.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
