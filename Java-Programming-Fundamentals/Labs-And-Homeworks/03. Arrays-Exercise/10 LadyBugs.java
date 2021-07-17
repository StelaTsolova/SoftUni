import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] output = new int[Integer.parseInt(scanner.nextLine())];
        int[] indexs = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        for (int index : indexs) {
            if (index < output.length && index >= 0) {
                output[index] = 1;
            }
        }
        String[] command = scanner.nextLine().split(" ");
        while (!command[0].equals("end")) {
            int ladybugIndex = Integer.parseInt(command[0]);
            int flyLength = Integer.parseInt(command[2]);
            if (ladybugIndex >= 0 && ladybugIndex < output.length && flyLength != 0) {
                if (command[1].equals("right")) {
                    while (output[ladybugIndex] == 1) {
                        if (ladybugIndex + flyLength < output.length) {
                            if (output[ladybugIndex + flyLength] == 1) {
                                flyLength += flyLength;
                            } else if (output[ladybugIndex + flyLength] == 0) {
                                output[ladybugIndex] = 0;
                                output[ladybugIndex + flyLength] = 1;
                            }
                        } else {
                            output[ladybugIndex] = 0;
                        }
                    }
                } else if (command[1].equals("left")) {
                    while (output[ladybugIndex] == 1) {
                        if (ladybugIndex - flyLength >= 0) {
                            if (output[ladybugIndex - flyLength] == 1) {
                                flyLength += flyLength;
                            } else if (output[ladybugIndex - flyLength] == 0) {
                                output[ladybugIndex] = 0;
                                output[ladybugIndex - flyLength] = 1;
                            }
                        } else {
                            output[ladybugIndex] = 0;
                        }
                    }
                }
            }
            command = scanner.nextLine().split(" ");
        }
        for (int position : output) {
            System.out.print(position + " ");
        }
    }
}