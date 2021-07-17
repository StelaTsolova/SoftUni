import java.util.Scanner;

public class KaminoFactory_9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int rowsCounter = 0;
        int printRow = 0;
        int currentSequenceSum = 0;
        int greatestSum = 0;
        int currentSequence;
        int greatestSequence = length;
        StringBuilder textReceiver = new StringBuilder();
        StringBuilder textPrinter = new StringBuilder();
        boolean isZero = true;
        boolean isOne = false;

        while (!input.equals("Clone them!")) {
            isZero = true;
            isOne = false;
            rowsCounter++;
            input = input.replaceAll("!+", " ");
            int[] sequence = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int digits : sequence) {
                currentSequenceSum += digits;
                textReceiver.append(digits).append(" ");
            }
            for (int digit : sequence) {
                if (digit != 0) {
                    isZero = false;
                    break;
                }
                textPrinter = new StringBuilder();
                textPrinter.append(textReceiver);
            }
            if (length == 1 && sequence[0] == 1) {
                isOne = true;
                textPrinter = new StringBuilder();
                textPrinter.append(textReceiver);
            }
            for (int i = 0; i < length - 1; i++) {
                if (!isZero && sequence[i] + sequence[i + 1] > 1) {
                    currentSequence = i + 1;
                    if (currentSequence < greatestSequence) {
                        greatestSequence = currentSequence;
                        greatestSum = currentSequenceSum;
                        textPrinter = new StringBuilder();
                        textPrinter.append(textReceiver);
                        printRow = rowsCounter;
                    }
                    if (currentSequence == greatestSequence && currentSequenceSum > greatestSum) {
                        greatestSum = currentSequenceSum;
                        greatestSequence = currentSequence;
                        textPrinter = new StringBuilder();
                        textPrinter.append(textReceiver);
                        printRow = rowsCounter;
                    }
                }
            }
            currentSequenceSum = 0;
            textReceiver = new StringBuilder();
            input = scanner.nextLine();
        }
        if (isZero) {
            System.out.println("Best DNA sample 1 with sum: 0.");
            System.out.print(textPrinter);
        } else if (isOne) {
            System.out.println("Best DNA sample 1 with sum: 1.");
            System.out.print(textPrinter);
        } else {
            System.out.printf("Best DNA sample %d with sum: %d.\n", printRow, greatestSum);
            System.out.print(textPrinter);
        }
    }
}