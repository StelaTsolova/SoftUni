import java.util.Scanner;

public class BeerKegs_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String modelBiggestKeg = "";
        double volumeBiggestKeg = 0.0;
        for (int i = 0; i < n; i++) {
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());
            //π * r^2 * h
            double volume = Math.PI * Math.pow(radius, 2) * height;
            if (volume > volumeBiggestKeg){
                volumeBiggestKeg = volume;
                modelBiggestKeg = model;
            }
        }
        System.out.println(modelBiggestKeg);
    }
}
