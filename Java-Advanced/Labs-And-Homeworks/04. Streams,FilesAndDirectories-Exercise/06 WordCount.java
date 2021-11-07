import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class WordCount_6 {
    public static void main(String[] args) throws IOException {
        BufferedReader firstReader = new BufferedReader(new FileReader("04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt"));
        Map<String, Integer> statistic = new LinkedHashMap<>();
        for (String word : firstReader.readLine().split("\\s+")){
            statistic.put(word, 0);
        }
        Path path = Paths.get("04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt");
        List<String> lines = new ArrayList<>(Files.readAllLines(path));
        for (String line : lines){
            String[] words = line.split("\\s+");
            for (String word : words){
                if (statistic.containsKey(word)){
                    statistic.put(word, statistic.get(word) + 1);
                }
            }
        }
        PrintWriter printWriter = new PrintWriter("results_06.txt");
        statistic.entrySet().stream().sorted((v1,v2) -> v2.getValue().compareTo(v1.getValue())).forEach( e -> {
            printWriter.println(e.getKey() + " - " + e.getValue());
        });
        printWriter.close();
    }
}
