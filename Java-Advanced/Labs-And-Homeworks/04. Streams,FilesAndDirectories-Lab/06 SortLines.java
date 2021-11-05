import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines_6 {
    public static void main(String[] args) {
        String fileName = "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        Path path = Paths.get(fileName);
        try {
            PrintStream printStream = new PrintStream("04. Java-Advanced-Files-and-Streams-Lab-Resources\\06.SortLinesOutput.txt");
            List<String> lines = Files.readAllLines(path);
            Collections.sort(lines);
            for (String line:lines){
                printStream.println(line);
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
