package ComparingObjects_5;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTown() {
        return town;
    }

    @Override
    public int compareTo(Person o) {
        int result = this.name.compareTo(o.getName());
        if (result == 0) {
            result = Integer.compare(this.age, o.getAge());
        }
        if (result == 0) {
            result = this.town.compareTo(o.getTown());
        }
        return result;
    }
}