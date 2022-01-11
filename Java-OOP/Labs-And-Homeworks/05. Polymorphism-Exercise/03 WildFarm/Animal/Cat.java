package WildFarm_3.Animal;

import WildFarm_3.Food.Food;

public class Cat extends Felime {
    private String breed;

    public Cat(String name, String type, double wight, String livingRegion, String breed) {
        super(name, type, wight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(super.toString());
        stringBuilder.insert(stringBuilder.indexOf(" ") + 1, this.breed + ", ");
        return stringBuilder.toString();
    }
}
