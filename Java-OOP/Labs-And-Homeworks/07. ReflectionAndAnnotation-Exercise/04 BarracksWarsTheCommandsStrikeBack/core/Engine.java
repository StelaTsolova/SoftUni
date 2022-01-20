package BarracksWarsTheCommandsStrikeBack_4.core;

import BarracksWarsTheCommandsStrikeBack_4.interfaces.Executable;
import BarracksWarsTheCommandsStrikeBack_4.interfaces.Repository;
import BarracksWarsTheCommandsStrikeBack_4.interfaces.Runnable;
import BarracksWarsTheCommandsStrikeBack_4.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

    private Repository repository;
    private UnitFactory unitFactory;

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
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
                String result = interpretCommand(data, commandName);
                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException | ExecutionControl.NotImplementedException | ClassNotFoundException
                    | InvocationTargetException | NoSuchMethodException
                    | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    // TODO: refactor for problem 4
    private String interpretCommand(String[] data, String commandName) throws ExecutionControl.NotImplementedException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Class<? extends Executable> clazz = (Class<? extends Executable>) Class
                .forName("BarracksWarsTheCommandsStrikeBack_4.core.commands." + commandName);
        Constructor<? extends Executable> constructor = clazz.getDeclaredConstructor(String[].class, Repository.class, UnitFactory.class);
        Executable executable = constructor.newInstance(data, this.repository, this.unitFactory);
        return executable.execute();
    }
}
