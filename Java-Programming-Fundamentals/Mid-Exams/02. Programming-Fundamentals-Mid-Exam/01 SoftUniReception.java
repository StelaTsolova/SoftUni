import java.util.Scanner;

public class SoftUniReception_1_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstEmployee = Integer.parseInt(scanner.nextLine());
        int secondEmployee = Integer.parseInt(scanner.nextLine());
        int thirdEmployee = Integer.parseInt(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());
        int employeeEfficiency = firstEmployee + secondEmployee + thirdEmployee;
        int time = 0;
        boolean studentsIsZero = false;
        while (studentsCount > 0) {
            for (int i = 0; i < 3; i++) {
                time++;
                studentsCount -= employeeEfficiency;
                if (studentsCount <= 0) {
                    studentsIsZero = true;
                    break;
                }
            }
            if (!studentsIsZero) {
                time++;
            }
        }
        System.out.printf("Time needed: %dh.", time);
    }
}