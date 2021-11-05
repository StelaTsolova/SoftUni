import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class WriteEveryThirdLine_5 {
    public static void main(String[] args) {
        String fileName = "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        Path path = Paths.get(fileName);
        try {
            PrintStream printStream = new PrintStream("04. Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt");
            List<String> lines = Files.readAllLines(path);
            for (int i = 2; i < lines.size(); i += 3) {
                printStream.println(lines.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
