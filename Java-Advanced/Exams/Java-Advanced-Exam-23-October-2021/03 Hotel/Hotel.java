package hotel_three;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Person> roster;
    private String name;
    private int capacity;

    public Hotel(String name, int capacity) {
        this.roster = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void add(Person person) {
        if (roster.size() < capacity) {
            roster.add(person);
        }
    }

    public boolean remove(String name) {
        for (Person person : roster) {
            if (person.getName().equals(name)) {
                return roster.remove(person);
            }
        }
        return false;
    }

    public Person getPerson(String name, String hometown) {
        for (Person person : roster) {
            if (person.getName().equals(name) && person.getHometown().equals(hometown)) {
                return person;
            }
        }
        return null;
    }

    public int getCount() {
        return roster.size();
    }

    public String getStatistics() {
        StringBuilder statistics = new StringBuilder();
        statistics.append(String.format("The people in the hotel_three %s are:%n", this.name));
        roster.forEach(p -> statistics.append(p).append(System.lineSeparator()));
        return statistics.toString();
    }
}