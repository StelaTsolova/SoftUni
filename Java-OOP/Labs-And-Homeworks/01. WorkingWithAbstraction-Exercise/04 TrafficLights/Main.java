package TrafficLights_4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] colors = scanner.nextLine().split("\\s+");
        List<Light> lights = new ArrayList<>();
        for (String color : colors) {
            Light light = new Light(Colors.valueOf(color));
            lights.add(light);
        }
        int countChange = Integer.parseInt(scanner.nextLine());
        while (countChange-- > 0) {
            lights.forEach(l -> {
                l.changeColor();
                System.out.print(l.getColor() + " ");
            });
            System.out.println();
        }
    }
}