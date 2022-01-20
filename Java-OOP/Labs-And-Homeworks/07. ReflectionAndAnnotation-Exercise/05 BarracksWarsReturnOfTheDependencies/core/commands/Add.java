package BarracksWarsReturnOfTheDependencies_5.core.commands;

import BarracksWarsReturnOfTheDependencies_5.interfaces.*;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public class Add implements Executable {
    @Inject
    private String[] date;
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory factory;

    public Add() {

    }

    @Override
    public String execute() {
        String unitType = this.date[1];
        Unit unitToAdd =null;
        try {

            unitToAdd = this.factory.createUnit(unitType);
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        this.repository.addUnit(unitToAdd);
        return unitType + " added!";
    }
}
