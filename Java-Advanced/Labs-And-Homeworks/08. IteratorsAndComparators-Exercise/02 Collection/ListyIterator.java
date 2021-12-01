package Collection_2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListyIterator implements Iterable<String> {
    private List<String> elements;
    private int index = -1;

    public ListyIterator(List<String> elements) {
        this.elements = new ArrayList<>();
        if (!elements.isEmpty()) {
            this.elements.addAll(elements);
            index = 0;
        }
    }

    public boolean move() {
        if (hasNext()) {
            index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return index + 1 < elements.size();
    }

    public void print() {
        if (!elements.isEmpty()) {
            System.out.println(elements.get(index));
        } else {
            System.out.println("Invalid Operation!");
        }
    }

    public void printAll(){
        this.elements.forEach(e -> System.out.print(e + " "));
        System.out.println();
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int i = 0;

            @Override
            public boolean hasNext() {
                return i < elements.size();
            }

            @Override
            public String next() {
                return elements.get(i++);
            }
        };
    }
}