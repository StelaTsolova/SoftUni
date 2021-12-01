package StackIterator_3;

public class Node<Integer> {
    private int number;
    private Node<Integer> prev;

    public Node(int number) {
        this.number = number;
        this.prev = null;
    }

    public int getNumber() {
        return number;
    }

    public Node<Integer> getPrev() {
        return prev;
    }

    public void setPrev(Node<Integer> prev) {
        this.prev = prev;
    }
}