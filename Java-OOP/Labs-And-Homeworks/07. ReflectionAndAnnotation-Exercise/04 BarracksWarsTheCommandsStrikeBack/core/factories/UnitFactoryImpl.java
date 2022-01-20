package BarracksWarsTheCommandsStrikeBack_4.core.factories;

import BarracksWarsTheCommandsStrikeBack_4.interfaces.Unit;
import BarracksWarsTheCommandsStrikeBack_4.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "BarracksWarsTheCommandsStrikeBack_4.models.units.";

    @Override
    public Unit createUnit(String unitType) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
        Constructor<Unit> constructor = unitClass.getConstructor();
        return constructor.newInstance();
    }
}
