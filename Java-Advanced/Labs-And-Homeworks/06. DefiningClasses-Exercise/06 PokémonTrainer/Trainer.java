package PokémonTrainer_6;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    //     name, number of badges and a collection of pokemon
    private String name;
    private int numberBadges;
    private List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.numberBadges = 0;
        this.pokemons = new ArrayList<>();
    }

    public boolean checkPokemonsElement(String element) {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getElement().equals(element)) {
                return true;
            }
        }
        return false;
    }

    public void addedBadge() {
        this.numberBadges++;
    }

    public void reducesPokemonsHealth() {
        for (Pokemon pokemon : pokemons) {
            pokemon.reducesHealth();
        }
    }

    public void removesPokemons() {
        pokemons.removeIf(pokemon -> pokemon.getHealth() <= 0);
    }

    public int getNumberBadges() {
        return this.numberBadges;
    }

    public List<Pokemon> getPokemons() {
        return this.pokemons;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.numberBadges, this.pokemons.size());
    }
}