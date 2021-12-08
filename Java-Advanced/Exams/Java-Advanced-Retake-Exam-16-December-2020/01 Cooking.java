import java.util.*;

public class Cooking_1_16December2020 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquids = fillQueue(scanner);
        ArrayDeque<Integer> ingredients = fillStack(scanner);

        Map<String, Integer> foods = new LinkedHashMap<>();
        foods.put("Bread", 0);
        foods.put("Cake", 0);
        foods.put("Fruit Pie", 0);
        foods.put("Pastry", 0);

        while (liquids.size() > 0 && ingredients.size() > 0) {
            int liquid = liquids.poll();
            int ingredient = ingredients.pop();

            int sum = liquid + ingredient;
            if (sum == 25) {
                foods.put("Bread", foods.get("Bread") + 1);
            } else if (sum == 50) {
                foods.put("Cake", foods.get("Cake") + 1);
            } else if (sum == 75) {
                foods.put("Pastry", foods.get("Pastry") + 1);
            } else if (sum == 100) {
                foods.put("Fruit Pie", foods.get("Fruit Pie") + 1);
            } else {
                ingredients.push(ingredient + 3);
            }
        }

        printResult(foods, liquids, ingredients);
    }

    private static ArrayDeque<Integer> fillQueue( Scanner scanner) {
        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        int[] quantities = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Arrays.stream(quantities).forEach(liquids::offer);
        return liquids;
    }

    private static ArrayDeque<Integer> fillStack(Scanner scanner) {
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        int[] quantities = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Arrays.stream(quantities).forEach(ingredients::push);
        return ingredients;
    }

    private static void printResult(Map<String, Integer> foods, ArrayDeque<Integer> liquids, ArrayDeque<Integer> ingredients) {
        printInfoForCooking(foods);
        printInfoForLiquids(liquids);
        printInfoForIngredients(ingredients);
        printInfoForFood(foods);
    }

    private static void printInfoForCooking(Map<String, Integer> foods) {
        boolean isAllCooking = true;
        for (Map.Entry<String, Integer> food : foods.entrySet()) {
            if (food.getValue() == 0) {
                isAllCooking = false;
                break;
            }
        }

        if (isAllCooking) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }
    }

    private static void printInfoForLiquids(ArrayDeque<Integer> liquids) {
        System.out.print("Liquids left: ");
        if (liquids.isEmpty()) {
            System.out.println("none");
        } else {
            printMaterials(liquids);
        }
    }

    private static void printInfoForIngredients(ArrayDeque<Integer> ingredients) {
        System.out.print("Ingredients left: ");
        if (ingredients.isEmpty()) {
            System.out.println("none");
        } else {
            printMaterials(ingredients);
        }
    }

    private static void printMaterials(ArrayDeque<Integer> materials) {
        int counter = materials.size();
        for (int material : materials) {
            System.out.print(material);
            if (counter-- > 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }

    private static void printInfoForFood(Map<String, Integer> foods) {
        foods.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
