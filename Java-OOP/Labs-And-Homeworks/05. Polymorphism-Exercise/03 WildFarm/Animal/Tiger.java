package WildFarm_3.Animal;

import WildFarm_3.Food.Food;
import WildFarm_3.Food.Meat;

public class Tiger extends Felime {
    public Tiger(String name, String type, double wight, String livingRegion) {
        super(name, type, wight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (!(food instanceof Meat)) {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
        super.eat(food);
    }
}
