import java.util.Scanner;

public class PokeMon_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int M = Integer.parseInt(scanner.nextLine());
        int Y = Integer.parseInt(scanner.nextLine());
        int currentPower = N;
        int countTargets = 0;
        while (currentPower >= M) {
            if (N / 2 == currentPower && Y > 0)
                currentPower /= Y;
            if (currentPower >= M) {
                currentPower -= M;
                countTargets++;
            }
        }
        if (N / 2 == currentPower && Y > 0)
            currentPower /= Y;
        System.out.println(String.format("%d%n%d", currentPower, countTargets));
    }
}
