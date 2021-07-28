import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists_3 {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        List<Integer> firstLine = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondLine = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int minLength = Math.min(firstLine.size(), secondLine.size());
        for (int i = 0; i < minLength ; i++) {
            System.out.printf("%d %d ", firstLine.get(i), secondLine.get(i));
        }
        printEnd(firstLine, minLength);
        printEnd(secondLine, minLength);
    }

    private static void printEnd(List<Integer> line, int beginLength) {
        for (int i = beginLength; i < line.size(); i++) {
            System.out.print(line.get(i) + " ");
        }
    }
}