package StrategyPattern_6;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Person> {
    @Override
    public int compare(Person f, Person s) {
        int result = Integer.compare(f.getName().length(), s.getName().length());
        if (result == 0) {
            char first = Character.toLowerCase(f.getName().charAt(0));
            char second = Character.toLowerCase(s.getName().charAt(0));
            result = Integer.compare(first, second);
        }
        return result;
    }
}