package BarracksWarsTheCommandsStrikeBack_4.interfaces;

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
