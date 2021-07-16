import java.util.Scanner;

public class Snowballs_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        double bestSnowballValue = -1.0;
        int bestsnowballSnow = -1;
        int bestsnowballTime = -1;
        int bestsnowballQuality = -1;
        for (int i = 0; i < N; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());
            //(snowballSnow / snowballTime) ^ snowballQuality
            double snowballValue = Math.pow((snowballSnow / snowballTime), snowballQuality);
            if (snowballValue > bestSnowballValue) {
                bestSnowballValue = snowballValue;
                bestsnowballSnow = snowballSnow;
                bestsnowballTime = snowballTime;
                bestsnowballQuality = snowballQuality;
            }
        }
        //{snowballSnow} : {snowballTime} = {snowballValue} ({snowballQuality})
        System.out.println(String.format("%d : %d = %.0f (%d)", bestsnowballSnow, bestsnowballTime, bestSnowballValue, bestsnowballQuality));
    }
}