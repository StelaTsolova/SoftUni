import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> wagons = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scanner.nextLine());
        String[] command = scanner.nextLine().split("\\s+");
        while (!command[0].equals("end")) {
            if (command.length == 2) {
                int passengers = Integer.parseInt(command[1]);
                wagons.add(passengers);
            } else {
                int passengers = Integer.parseInt(command[0]);
                for (int i = 0; i < wagons.size(); i++) {
                    if (wagons.get(i) + passengers <= maxCapacity){
                        wagons.set(i, wagons.get(i) + passengers);
                        break;
                    }
                }
            }
            command = scanner.nextLine().split("\\s+");
        }
        System.out.print(wagons.toString().replaceAll("[\\[\\],]", ""));
    }
}