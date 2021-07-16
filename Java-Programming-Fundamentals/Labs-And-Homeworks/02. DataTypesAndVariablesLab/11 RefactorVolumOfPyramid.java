import java.util.Scanner;

public class RefactorVolumOfPyramid_11 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        System.out.print("Length: ");
        System.out.print("Width: ");
        System.out.print("Height: ");
        double length = Double.parseDouble(scanner.nextLine());
        double width = Double.parseDouble(scanner.nextLine());
        double height = Double.parseDouble(scanner.nextLine());
        double volume = (length * width * height) / 3;
        System.out.printf("Pyramid Volume: %.2f", volume);
    }
}
