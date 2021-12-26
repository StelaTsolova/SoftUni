package ShoppingSpree_3;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (product.getCost() > this.money) {
            throw new IllegalArgumentException(String.format("%s can't afford %s", this.name, product.getName()));
        } else {
            this.products.add(product);
            this.money -= product.getCost();
        }
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        if (products.isEmpty()) {
            return String.format("%s – Nothing bought%n", this.name);
        }
        return this.name + " - " + this.products.toString().replaceAll("[\\[\\]]", "");
    }
}