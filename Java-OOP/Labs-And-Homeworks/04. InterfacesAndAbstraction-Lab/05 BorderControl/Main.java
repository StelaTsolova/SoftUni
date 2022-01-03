package BorderControl_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> identifiables = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] info = input.split("\\s+");
            Identifiable identifiable = null;

            if (info.length == 3) {
                identifiable = new Citizen(info[0], Integer.parseInt(info[1]), info[2]);
            } else if (info.length == 2) {
                identifiable = new Robot(info[0], info[1]);
            }
            identifiables.add(identifiable);
            input = scanner.nextLine();
        }
        String number = scanner.nextLine();
        identifiables.stream().filter(i -> i.getId().endsWith(number)).forEach(i -> System.out.println(i.getId()));
    }
}