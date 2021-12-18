package StudentSystem_3;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repository;
    private Reader reader;

    public StudentSystem() {
        this.repository = new HashMap<>();
        this.reader = new Reader();
    }

    public void start() {
        String[] command = reader.readArray();
        while (!command[0].equals("Exit")) {
            if (command[0].equals("Create")) {
                String name = command[1];
                int age = Integer.parseInt(command[2]);
                double grade = Double.parseDouble(command[3]);
                Student student = new Student(name, age, grade);
                repository.putIfAbsent(name, student);
            } else if (command[0].equals("Show")) {
                String name = command[1];
                if (repository.containsKey(name)) {
                    repository.get(name).printInfo();
                }
            }
            command = reader.readArray();
        }
    }
}