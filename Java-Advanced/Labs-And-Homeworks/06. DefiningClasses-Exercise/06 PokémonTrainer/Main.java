package PokémonTrainer_6;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Trainer> trainers = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("Tournament")) {
            String[] information = input.split("\\s+");
            String trainerName = information[0];
            String pokemonName = information[1];
            String pokemonElement = information[2];
            int pokemonHealth = Integer.parseInt(information[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            trainers.putIfAbsent(trainerName, new Trainer(trainerName));
            trainers.get(trainerName).getPokemons().add(pokemon);

            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("End")) {
            for (Map.Entry<String, Trainer> entry : trainers.entrySet()) {
                if (entry.getValue().checkPokemonsElement(input)) {
                    entry.getValue().addedBadge();
                } else {
                    entry.getValue().reducesPokemonsHealth();
                    entry.getValue().removesPokemons();
                }
            }
            input = scanner.nextLine();
        }

        trainers.values().stream().sorted(Comparator.comparingInt(Trainer::getNumberBadges).reversed())
                .forEach(System.out::println);
    }
}