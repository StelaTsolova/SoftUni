import java.util.*;

public class PastryShop_1_18August2021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] materials = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> liquids = fillQueue(materials);

        materials = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> ingredients = fillStack(materials);

        Map<String, Integer> foods = new LinkedHashMap<>();
        foods.put("Biscuit", 0);
        foods.put("Cake", 0);
        foods.put("Pie", 0);
        foods.put("Pastry", 0);

        while (liquids.size() > 0 && ingredients.size() > 0) {
            int liquid = liquids.poll();
            int ingredient = ingredients.pop();

            int sum = liquid + ingredient;
            if (sum == 25) {
                foods.put("Biscuit", foods.get("Biscuit") + 1);
            } else if (sum == 50) {
                foods.put("Cake", foods.get("Cake") + 1);
            } else if (sum == 75) {
                foods.put("Pastry", foods.get("Pastry") + 1);
            } else if (sum == 100) {
                foods.put("Pie", foods.get("Pie") + 1);
            } else {
                ingredients.push(ingredient + 3);
            }
        }

        printResult(foods, liquids, ingredients);
    }

    private static ArrayDeque<Integer> fillQueue(int[] quantities) {
        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        for (int number : quantities) {
            liquids.offer(number);
        }
        return liquids;
    }

    private static ArrayDeque<Integer> fillStack(int[] quantities) {
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        for (int number : quantities) {
            ingredients.push(number);
        }
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
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
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