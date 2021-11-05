import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class ExtractIntegers_4 {
    public static void main(String[] args) {
        String path = "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        try {
            FileInputStream inputStream = new FileInputStream(path);
            Scanner scanner = new Scanner(inputStream);
            PrintStream printStream = new PrintStream("04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt");
            while (scanner.hasNext()){
               if(scanner.hasNextInt()){
                   int number = scanner.nextInt();
                   printStream.println(number);
               }
               scanner.next();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
