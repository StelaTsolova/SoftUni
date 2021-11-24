package GenericBox_1;

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

    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();
        elements.forEach(e -> output.append(String.format("%s: %s%n", e.getClass().getName(), e)));
        return output.toString();
    }
}