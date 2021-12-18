package StudentSystem_3;

public class Student {
    private String name;
    private int age;
    private double grade;
    private String comment;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.comment = setComment();
    }

    public String setComment() {
        if (grade >= 5.00) {
            return "Excellent student.";
        }
        if (grade >= 3.50) {
            return "Average student.";
        }
        return "Very nice person.";
    }

    public void printInfo() {
        System.out.printf("%s is %d years old. %s%n", this.name, this.age, this.comment);
    }
}