package com.example.springdataadvancedquering;

import com.example.springdataadvancedquering.entities.Size;
import com.example.springdataadvancedquering.services.IngredientService;
import com.example.springdataadvancedquering.services.ShampooService;
import com.sun.source.doctree.IndexTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

@Component
public class ConsoleRunner implements CommandLineRunner {

    private ShampooService shampooService;
    private IngredientService ingredientService;

    @Autowired
    public ConsoleRunner(ShampooService shampooService, IngredientService ingredientService) {
        this.shampooService = shampooService;
        this.ingredientService = ingredientService;
    }

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // 1. Select Shampoos by Size
        printShampoosBySizeOrderById(scanner);

        // 2. Select Shampoos by Size or Label
        printShampoosBySizeOrLabelIdOrderByPrice(scanner);

        // 3. Select Shampoos by Price
        printShampoosByPriceGreaterThanGivenPriceOrderByPriceDesc(scanner);

        // 4. Select Ingredients by Name
        printNamesStartingWith(scanner);

        // 5. Select Ingredients by Names
        printNamesWhichInGivenCollection(scanner);

        // 6. Count Shampoos by Price
        printCountShampoosWithPriceLowerThanGivenPrice(scanner);

        // 7. Select Shampoos by Ingredients
        printBrandsWhereIngredientInGivenCollection(scanner);

        // 8. Select Shampoos by Ingredients Count
        printBrandsWhereIngredientLessThanGivenNumber(scanner);

        // 9. Delete Ingredients by Name
        deleteIngredientsByName(scanner);

        // 10. Update Ingredients by Price
        increasesIngredientsPriceBy10Percent();

        // 11. Update Ingredients by Names
        increasesPriceByPercentByNamesInCollection(scanner);
    }

    private void printShampoosBySizeOrderById(Scanner scanner) {
        Size size = Size.valueOf(scanner.nextLine());

        this.shampooService.getAllBySizeOrderById(size)
                .forEach(s -> System.out.printf("%s %s %.2flv.%n", s.getBrand(), s.getSize(), s.getPrice()));
    }

    private void printShampoosBySizeOrLabelIdOrderByPrice(Scanner scanner) {
        Size size = Size.valueOf(scanner.nextLine());
        Long labelId = Long.parseLong(scanner.nextLine());

        this.shampooService.getAllBySizeOrLabelIdOrderByPrice(size, labelId)
                .forEach(s -> System.out.printf("%s %s %.2flv.%n", s.getBrand(), s.getSize(), s.getPrice()));
    }

    private void printShampoosByPriceGreaterThanGivenPriceOrderByPriceDesc(Scanner scanner) {
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(scanner.nextLine()));

        this.shampooService.getAllByPriceGreaterThanGivenPriceOrderByPriceDesc(price)
                .forEach(s -> System.out.printf("%s %s %.2flv.%n", s.getBrand(), s.getSize(), s.getPrice()));
    }

    private void printNamesStartingWith(Scanner scanner) {
        String letters = scanner.nextLine();

        this.ingredientService.getAllNamesStartingWith(letters).forEach(System.out::println);
    }

    private void printNamesWhichInGivenCollection(Scanner scanner) {
        List<String> names = Arrays.asList(scanner.nextLine().split("\\s+"));

        this.ingredientService.getAllNamesWhichInGivenCollectionOrderByPrice(names)
                .forEach(System.out::println);

    }

    private void printCountShampoosWithPriceLowerThanGivenPrice(Scanner scanner) {
        BigDecimal price = BigDecimal.valueOf(Double.parseDouble(scanner.nextLine()));

        int count = this.shampooService.getCountShampoosWithPriceLowerThanGivenPrice(price);

        System.out.println(count);
    }

    private void printBrandsWhereIngredientInGivenCollection(Scanner scanner) {
        List<String> names = Arrays.asList(scanner.nextLine().split("\\s+"));

        this.shampooService.getBrandsWhereIngredientInGivenCollection(names).forEach(System.out::println);
    }

    private void printBrandsWhereIngredientLessThanGivenNumber(Scanner scanner) {
        int number = Integer.parseInt(scanner.nextLine());

        this.shampooService.getBrandsWhereIngredientsLessThanGivenNumber(number).forEach(System.out::println);
    }

    private void deleteIngredientsByName(Scanner scanner) {
        String name = scanner.nextLine();

        this.ingredientService.deleteIngredientByGivenName(name);
    }

    private void increasesIngredientsPriceBy10Percent() {
        this.ingredientService.increasesPriceBy10Percent();
    }

    private void increasesPriceByPercentByNamesInCollection(Scanner scanner) {
        int percent = Integer.parseInt(scanner.nextLine());
        Set<String> names = Set.of(scanner.nextLine().split(", "));

        this.ingredientService.increasesPriceByPercentByNamesInCollection(percent, names);
    }
}
