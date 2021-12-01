package Froggy_4;

import java.util.Iterator;
import java.util.List;

public class Lake<Integer> implements Iterable<Integer> {
    private List<Integer> numbers;

    public Lake(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }

    class Frog implements Iterator<Integer> {
        int index = 0;
        boolean firstRoundIsFinished = false;

        @Override
        public boolean hasNext() {
            return index < numbers.size();
        }

        @Override
        public Integer next() {
            int currentIndex = index;
            index += 2;
            if (index >= numbers.size() && !firstRoundIsFinished) {
                index = 1;
                firstRoundIsFinished = true;
            }
            return numbers.get(currentIndex);
        }
    }
}
