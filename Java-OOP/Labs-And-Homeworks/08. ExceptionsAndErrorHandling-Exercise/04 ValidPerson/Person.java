package ValidPerson_4;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.setFirstname(firstName);
        this.setLastName(lastName);
        this.setAge(age);
    }

    public String getFirstname() {
        return this.firstName;
    }

    public void setFirstname(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()){
            throw new IllegalArgumentException("The first name cannot null or empty");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()){
            throw new IllegalArgumentException("The last name cannot null or empty");
        }
        this.lastName = lastName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 120){
            throw new IllegalArgumentException("Age should be in the range [0 ... 120]");
        }
        this.age = age;
    }
}
