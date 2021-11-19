package PokémonTrainer_6;

public class Pokemon {
    //name, an element and health
    private String name;
    private String element;
    private int health;

    public Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    public void reducesHealth() {
        health -= 10;
    }

    public String getElement() {
        return this.element;
    }

    public int getHealth() {
        return this.health;
    }
}