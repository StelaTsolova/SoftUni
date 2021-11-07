import java.io.*;
import java.util.List;

public class ALLCAPITALS_3 {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));
            PrintWriter printWriter = new PrintWriter(new FileWriter("output_03.txt"));
            List<String> lines = reader.lines().toList();
            for (String line : lines) {
                printWriter.println(line.toUpperCase());
            }
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}