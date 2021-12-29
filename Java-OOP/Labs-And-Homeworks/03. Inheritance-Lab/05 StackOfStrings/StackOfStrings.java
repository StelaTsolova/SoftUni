package StackOfStrings_5;

import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;

    public void push(String item) {
        this.data.add(0, item);
    }

    public String pop() {
        return this.data.remove(0);
    }

    public String peek() {
        return this.data.get(0);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}