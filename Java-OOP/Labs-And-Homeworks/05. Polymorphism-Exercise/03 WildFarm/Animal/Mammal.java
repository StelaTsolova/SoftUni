package WildFarm_3.Animal;

import WildFarm_3.Food.Food;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;

    protected Mammal(String name, String type, double wight, String livingRegion) {
        super(name, type, wight, livingRegion);
    }

    public String getLivingRegion() {
        return livingRegion;
    }
}
