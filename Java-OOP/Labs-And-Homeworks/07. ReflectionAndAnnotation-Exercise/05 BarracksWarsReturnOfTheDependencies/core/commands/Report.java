package BarracksWarsReturnOfTheDependencies_5.core.commands;

import BarracksWarsReturnOfTheDependencies_5.interfaces.Executable;
import BarracksWarsReturnOfTheDependencies_5.interfaces.Inject;
import BarracksWarsReturnOfTheDependencies_5.interfaces.Repository;

public class Report implements Executable {
    @Inject
    private Repository repository;

    public Report() {

    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
