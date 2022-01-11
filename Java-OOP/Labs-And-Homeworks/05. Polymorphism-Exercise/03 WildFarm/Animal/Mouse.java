package WildFarm_3.Animal;

import WildFarm_3.Food.Food;
import WildFarm_3.Food.Vegetable;

public class Mouse extends Mammal {
    public Mouse(String name, String type, double wight, String livingRegion) {
        super(name, type, wight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if (!(food instanceof Vegetable)) {
            throw new IllegalArgumentException("Mice are not eating that type of food!");
        }
        super.eat(food);
    }
}
