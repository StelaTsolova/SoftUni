import java.util.Scanner;

public class BlackFlag_1_6August2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        int plunderDay = Integer.parseInt(scanner.nextLine());
        double expectedPlunder = Double.parseDouble(scanner.nextLine());
        double gather = 0;
        int counter = 0;
        for (int i = 0; i < days; i++) {
            counter++;
            gather += plunderDay;
            if (counter % 3 == 0) {
                gather += plunderDay / 2.0;
            }
            if (counter % 5 == 0) {
                gather -= gather * 0.3;
            }
        }
        if (gather >= expectedPlunder){
            System.out.printf("Ahoy! %.2f plunder gained.", gather);
        } else {
            double percentage = (gather / expectedPlunder) * 100;
            System.out.printf("Collected only %.2f%s of the plunder.", percentage, "%");
        }
    }
}