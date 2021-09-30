import java.util.Scanner;

public class BonusScoringSystem_1_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int students = Integer.parseInt(scanner.nextLine());
        int lectures = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());
        double maxBonusPoints = 0;
        int studentAttendances = 0;
        for (int i = 0; i < students; i++) {
            int currentAttendance = Integer.parseInt(scanner.nextLine());
            if (currentAttendance != 0 && lectures != 0) {
                double totalBonus = ((double) currentAttendance / lectures) * (5 + additionalBonus);
                if (totalBonus > maxBonusPoints) {
                    maxBonusPoints = totalBonus;
                    studentAttendances = currentAttendance;
                }
            }
        }
        System.out.printf("Max Bonus: %d.%n", Math.round(maxBonusPoints));
        System.out.printf("The student has attended %d lectures.", studentAttendances);
    }
}