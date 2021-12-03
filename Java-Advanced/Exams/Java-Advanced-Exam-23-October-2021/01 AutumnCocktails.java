import java.util.*;

public class first {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> buckets = fillQueue(scanner);
        ArrayDeque<Integer> freshness = fillStack(scanner);

        Map<String, Integer> cocktails = new TreeMap<>();
        while (buckets.size() > 0 && freshness.size() > 0) {
            int bucket = buckets.poll();
            if (bucket == 0) {
                continue;
            }
            int fresh = freshness.pop();
            int sum = bucket * fresh;

            if (sum == 150) {
                cocktails.putIfAbsent("Pear Sour", 0);
                cocktails.put("Pear Sour", cocktails.get("Pear Sour") + 1);
            } else if (sum == 250) {
                cocktails.putIfAbsent("The Harvest", 0);
                cocktails.put("The Harvest", cocktails.get("The Harvest") + 1);
            } else if (sum == 300) {
                cocktails.putIfAbsent("Apple Hinny", 0);
                cocktails.put("Apple Hinny", cocktails.get("Apple Hinny") + 1);
            } else if (sum == 400) {
                cocktails.putIfAbsent("High Fashion", 0);
                cocktails.put("High Fashion", cocktails.get("High Fashion") + 1);
            } else {
                buckets.offer(bucket + 5);
            }
        }

        if (cocktails.size() == 4) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!buckets.isEmpty()) {
            System.out.printf("Ingredients left: %d%n", buckets.stream().mapToInt(e -> e).sum());
        }

        cocktails.entrySet().forEach(c ->
                System.out.printf(" # %s --> %d%n", c.getKey(), c.getValue()));
    }


    private static ArrayDeque<Integer> fillQueue(Scanner scanner) {
        ArrayDeque<Integer> buckets = new ArrayDeque<>();
        int[] sequence = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Arrays.stream(sequence).forEach(buckets::offer);
        return buckets;
    }

    private static ArrayDeque<Integer> fillStack(Scanner scanner) {
        ArrayDeque<Integer> freshness = new ArrayDeque<>();
        int[] sequence = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Arrays.stream(sequence).forEach(freshness::push);
        return freshness;
    }
}