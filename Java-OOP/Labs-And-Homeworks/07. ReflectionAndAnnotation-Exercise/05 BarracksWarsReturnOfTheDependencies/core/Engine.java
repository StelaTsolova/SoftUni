package BarracksWarsReturnOfTheDependencies_5.core;

import BarracksWarsReturnOfTheDependencies_5.interfaces.CommandInterpreter;
import BarracksWarsReturnOfTheDependencies_5.interfaces.Runnable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Engine implements Runnable {
    private CommandInterpreter commandInterpreter;

    public Engine(CommandInterpreter commandInterpreter) {
        this.commandInterpreter = commandInterpreter;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0].substring(0, 1).toUpperCase() + data[0].substring(1);
                String result = commandInterpreter.interpretCommand(data, commandName).execute();
                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
