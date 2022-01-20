package BarracksWarsReturnOfTheDependencies_5.interfaces;

import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName) ;
}
