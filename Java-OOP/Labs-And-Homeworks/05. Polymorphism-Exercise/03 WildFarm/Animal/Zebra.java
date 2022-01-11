package WildFarm_3.Animal;

import WildFarm_3.Food.Food;
import WildFarm_3.Food.Vegetable;

public class Zebra extends Mammal {
    public Zebra(String name, String type, double wight, String livingRegion) {
        super(name, type, wight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (!(food instanceof Vegetable)) {
            throw new IllegalArgumentException("Zebras are not eating that type of food!");
        }
        super.eat(food);
    }
}
