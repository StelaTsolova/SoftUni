package BarracksWarsReturnOfTheDependencies_5.interfaces;

import java.lang.reflect.InvocationTargetException;

public interface UnitFactory {
    Unit createUnit(String unitType) throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException;
}