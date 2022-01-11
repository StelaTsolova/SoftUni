package Calculator_5;

import java.util.ArrayDeque;

public class RecallMemory {
    private static final ArrayDeque<Integer> saveNumbers = new ArrayDeque<>();

    protected static void pushNumber(int number) {
        saveNumbers.push(number);
    }

    protected static int popNumber() {
        return saveNumbers.pop();
    }
}
