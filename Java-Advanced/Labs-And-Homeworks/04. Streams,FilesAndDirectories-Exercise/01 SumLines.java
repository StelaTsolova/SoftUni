import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class SumLines_1 {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
            List<String> lines = reader.lines().toList();
            for (String line : lines) {
                int sum = 0;
                for (char symbol : line.toCharArray()) {
                    sum += symbol;
                }
                System.out.println(sum);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}