import java.util.Scanner;

public class Train_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] people = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            people[i] = Integer.parseInt(scanner.nextLine());
            sum += people[i];
            System.out.print(people[i] + " ");
        }
        System.out.println(String.format("\n%d", sum));
    }
}
