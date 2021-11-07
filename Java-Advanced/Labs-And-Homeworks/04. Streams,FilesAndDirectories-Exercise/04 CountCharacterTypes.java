import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CountCharacterTypes_4 {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        List<String> lines = Files.readAllLines(path);
        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;
        for (String line : lines) {
            for (char symbol : line.toCharArray()) {
                if (isVowels(symbol)) {
                    vowels++;
                } else if (isPunctuation(symbol)) {
                    punctuation++;
                } else if (symbol != ' ') {
                    consonants++;
                }
            }
        }
        PrintWriter printWriter = new PrintWriter(new FileWriter("output_04.txt"));
        printWriter.print(String.format("Vowels: %d%nConsonants: %d%nPunctuation: %d", vowels, consonants, punctuation));
        printWriter.close();
    }

    private static boolean isVowels(char symbol) {
        return symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u';
    }

    private static boolean isPunctuation(char symbol) {
        return symbol == '!' || symbol == ',' || symbol == '.' || symbol == '?';
    }
}