package Google_7;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;

    public Person(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public List<Parent> getParents() {
        return parents;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(name).append("\n").append("Company:").append("\n");
        if (this.company != null) {
            output.append(this.company);
        }
        output.append("Car:").append("\n");
        if (this.car != null) {
            output.append(this.car);
        }
        output.append("Pokemon:").append("\n");
        if (this.pokemons != null) {
            pokemons.forEach(p -> output.append(p.toString()));
        }
        output.append("Parents:").append("\n");
        if (this.parents != null) {
            parents.forEach(p -> output.append(p.toString()));
        }
        output.append("Children:").append("\n");
        if (this.children != null) {
            children.forEach(p -> output.append(p.toString()));
        }
        return output.toString();
    }
}