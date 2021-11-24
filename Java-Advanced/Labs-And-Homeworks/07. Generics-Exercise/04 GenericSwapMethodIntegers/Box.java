package GenericSwapMethodIntegers_4;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> elements;

    public Box(){
        this.elements = new ArrayList<>();
    }

    public void add(T element){
        this.elements.add(element);
    }

    public void swap(int firstIndex, int secondIndex){
        T firstElement = this.elements.get(firstIndex);
        T secondElement = this.elements.get(secondIndex);
        this.elements.set(firstIndex, secondElement);
        this.elements.set(secondIndex, firstElement);
    }

    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();
        elements.forEach(e -> output.append(String.format("%s: %s%n", e.getClass().getName(), e)));
        return output.toString();
    }
}
