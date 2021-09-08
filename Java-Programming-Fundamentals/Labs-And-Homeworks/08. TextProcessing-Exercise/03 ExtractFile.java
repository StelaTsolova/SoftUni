import java.util.Scanner;

public class ExtractFile_3 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         String[] path = scanner.nextLine().split("\\\\");
         String file = path[path.length - 1];
         String[] nameAndExtension = file.split("\\.");
         String name = nameAndExtension[0];
         String extension = nameAndExtension[1];
        System.out.printf("File name: %s%nFile extension: %s", name, extension);
    }
}