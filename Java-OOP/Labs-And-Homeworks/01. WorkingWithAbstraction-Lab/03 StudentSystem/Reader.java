package StudentSystem_3;

import java.util.Scanner;

public class Reader {
    public static Scanner scanner = new Scanner(System.in);

    public String[] readArray() {
        return scanner.nextLine().split("\\s+");
    }
}
