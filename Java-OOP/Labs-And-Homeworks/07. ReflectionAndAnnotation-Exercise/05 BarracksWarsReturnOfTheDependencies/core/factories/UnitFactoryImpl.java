package BarracksWarsReturnOfTheDependencies_5.core.factories;

import BarracksWarsReturnOfTheDependencies_5.interfaces.Unit;
import BarracksWarsReturnOfTheDependencies_5.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "BarracksWarsReturnOfTheDependencies_5.models.units.";

    @Override
    public Unit createUnit(String unitType) throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
        Constructor<Unit> constructor = unitClass.getConstructor();
        return constructor.newInstance();
    }
}
