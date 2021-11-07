import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class SumBytes_2 {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
            List<String> lines = reader.lines().toList();
            long sum = 0;
            for (String line : lines) {
                for (char symbol : line.toCharArray()) {
                    sum += symbol;
                }
            }
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}