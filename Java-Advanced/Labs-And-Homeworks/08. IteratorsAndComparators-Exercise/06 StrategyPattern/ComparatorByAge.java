package StrategyPattern_6;

import java.util.Comparator;

public class ComparatorByAge implements Comparator<Person> {
    @Override
    public int compare(Person f, Person s) {
        return Integer.compare(f.getAge(), s.getAge());
    }
}