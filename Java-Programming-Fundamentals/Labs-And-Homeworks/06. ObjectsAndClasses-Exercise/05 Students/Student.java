package Students_5;

public class Student {
    private String firstname;
    private String lastname;
    private double grade;

    public Student(String firstname, String lastname, double grade) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.grade = grade;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;

    }

    @Override
    public String toString(){
        return String.format("%s %s: %.2f", firstname, lastname, grade);

    }
}
