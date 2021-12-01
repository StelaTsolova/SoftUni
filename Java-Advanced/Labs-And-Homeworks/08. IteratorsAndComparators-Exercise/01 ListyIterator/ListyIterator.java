package ListyIterator_1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListyIterator {
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
}