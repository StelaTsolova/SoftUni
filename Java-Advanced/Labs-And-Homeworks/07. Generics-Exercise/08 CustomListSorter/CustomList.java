package CustomListSorter_8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {
    private List<T> elements;

    public CustomList() {
        this.elements = new ArrayList<>();
    }

    public List<T> getElements() {
        return this.elements;
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public T remove(int index) {
        return this.elements.remove(index);
    }

    public boolean contains(T element) {
        return this.elements.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        T firstElement = this.elements.get(firstIndex);
        T secondElement = this.elements.get(secondIndex);
        this.elements.set(firstIndex, secondElement);
        this.elements.set(secondIndex, firstElement);
    }

    public int countGreaterThan(T comparedItem) {
        return (int) this.elements.stream().filter(t -> t.compareTo(comparedItem) > 0).count();
    }

    public T getMax() {
        return Collections.max(elements);
    }

    public T getMin() {
        return Collections.min(elements);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < elements.size();
            }

            @Override
            public T next() {
                return elements.get(index++);
            }
        };
    }
}