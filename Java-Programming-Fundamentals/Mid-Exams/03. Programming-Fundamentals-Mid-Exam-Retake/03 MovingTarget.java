import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget_3_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> targets = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        String[] command = scanner.nextLine().split(" ");
        while (!command[0].equals("End")) {
            int index = Integer.parseInt(command[1]);
            switch (command[0]) {
                case "Shoot":
                    if (index >= 0 && index < targets.size()) {
                        int power = Integer.parseInt(command[2]);
                        int currentTarget = targets.get(index);
                        if (currentTarget - power <= 0) {
                            targets.remove(index);
                        } else {
                            targets.set(index, currentTarget - power);
                        }
                    }
                    break;
                case "Add":
                    if (index >= 0 && index < targets.size()) {
                        int value = Integer.parseInt(command[2]);
                        targets.add(index, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    int radius = Integer.parseInt(command[2]);
                    if (index - radius >= 0 && index + radius < targets.size()) {
                        if (index + radius >= index + 1) {
                            targets.subList(index + 1, index + radius + 1).clear();
                        }
                        if (index >= index - radius) {
                            targets.subList(index - radius, index + 1).clear();
                        }
                    } else {
                        System.out.println("Strike missed!");
                    }
                    break;
            }
            command = scanner.nextLine().split(" ");
        }
        System.out.println(targets.toString().replaceAll("[\\[\\] ]", "").replaceAll(",", "|"));
    }
}