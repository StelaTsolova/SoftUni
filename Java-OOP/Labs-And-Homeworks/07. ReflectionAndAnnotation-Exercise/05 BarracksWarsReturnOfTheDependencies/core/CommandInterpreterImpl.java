package BarracksWarsReturnOfTheDependencies_5.core;

import BarracksWarsReturnOfTheDependencies_5.interfaces.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {
    private Repository repository;
    private UnitFactory factory;

    public CommandInterpreterImpl(Repository repository, UnitFactory factory) {
        this.repository = repository;
        this.factory = factory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        Executable executable = null;
        try {
            Class<?> clazz = Class.forName("BarracksWarsReturnOfTheDependencies_5.core.commands." + commandName);
            Constructor<?> constructor = clazz.getDeclaredConstructor();
            executable = (Executable) constructor.newInstance();
            setFields(executable, data);
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException ex) {
            ex.printStackTrace();
        }
        return executable;
    }

    private void setFields(Executable executable, String[] data) throws IllegalAccessException {
        Field[] executableFields = executable.getClass().getDeclaredFields();
        Field[] localFields = this.getClass().getDeclaredFields();

        for (Field field : executableFields) {
            Inject annotation = field.getAnnotation(Inject.class);
            if (annotation != null) {
                field.setAccessible(true);
                if (field.getType() == data.getClass()) {
                    field.set(executable, data);
                } else {
                    for (Field localField : localFields) {
                        if (localField.getType() == field.getType()) {
                            field.set(executable, localField.get(this));
                        }
                    }
                }
            }
        }
    }
}
