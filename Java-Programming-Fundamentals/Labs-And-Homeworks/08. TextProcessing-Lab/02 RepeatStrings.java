import java.util.Scanner;

public class RepeatStrings_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        StringBuilder replicatedArray = new StringBuilder();
        for (String string : array) {
            replicatedArray.append(string.repeat(string.length()));
        }
        System.out.println(replicatedArray);
    }
}