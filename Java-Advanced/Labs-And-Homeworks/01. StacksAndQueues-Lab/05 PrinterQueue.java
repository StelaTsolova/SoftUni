import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        ArrayDeque<String> files = new ArrayDeque<>();
        while (!fileName.equals("print")) {
            if (fileName.equals("cancel")) {
                String canceledFile = files.poll();
                if (canceledFile == null) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + canceledFile);
                }
            } else {
                files.offer(fileName);
            }
            fileName = scanner.nextLine();
        }
        while (!files.isEmpty()) {
            System.out.println(files.pop());
        }
    }
}