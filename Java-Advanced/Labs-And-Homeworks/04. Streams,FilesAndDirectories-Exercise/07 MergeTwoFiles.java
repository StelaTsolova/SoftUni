import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MergeTwoFiles_7 {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt");
            List<String> firstPart = new ArrayList<>(Files.readAllLines(path));
            path = Paths.get("04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt");
            List<String> secondPart = new ArrayList<>(Files.readAllLines(path));
            PrintWriter printWriter = new PrintWriter("output_07.txt");
            firstPart.forEach(printWriter::println);
            secondPart.forEach(printWriter::println);
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
