package CustomException_5;

public class Student {
    private String name;
    private String email;

    public Student(String name, String email) {
        this.setName(name);
        this.email = email;
    }

    public void setName(String name) {
        for (char symbol: name.toCharArray()){
            if (!Character.isAlphabetic(symbol)){
                throw new InvalidPersonNameException("Invalid name");
            }
        }
        this.name = name;
    }
}
