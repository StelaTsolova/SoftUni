package WildFarm_3.Animal;

import WildFarm_3.Food.Food;

import java.text.DecimalFormat;

public abstract class Animal {
    private String name;
    private String type;
    private double wight;
    private String livingRegion;
    private int foodEaten;

    protected Animal(String name, String type, double wight, String livingRegion) {
        this.name = name;
        this.type = type;
        this.wight = wight;
        this.livingRegion = livingRegion;
    }

    public abstract void makeSound();

    public void eat(Food food) {
        this.foodEaten += food.getQuantity();
    }

    @Override
    public String toString() {
        DecimalFormat formatter = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %d]", this.type, this.name,
                formatter.format(this.wight), this.livingRegion, this.foodEaten);
    }
}
