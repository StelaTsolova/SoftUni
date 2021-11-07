import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LineNumbers_5 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt");
        List<String> lines = new ArrayList<>(Files.readAllLines(path));
        PrintWriter printWriter = new PrintWriter("output_05.txt");
        int counter = 1;
        for (String line : lines){
            printWriter.println(counter + ". " + line);
            counter++;
        }
        printWriter.close();
    }
}
