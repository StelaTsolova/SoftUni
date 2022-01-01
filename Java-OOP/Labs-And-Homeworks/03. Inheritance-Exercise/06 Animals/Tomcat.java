package Animals_6;

public class Tomcat extends Cat {
    public static final String TOMCATS_GENDER = "Male";

    public Tomcat(String name, int age) {
        super(name, age, TOMCATS_GENDER);
    }

    @Override
    public String produceSound() {
        return "MEOW";
    }
}