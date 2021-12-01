package StackIterator_3;

import java.util.Iterator;

public class Stack<Integer> implements Iterable<Integer> {
    private Node<Integer> top;

    public Stack() {
        this.top = null;
    }

    public void push(int number) {
        Node<Integer> node = new Node<>(number);
        node.setPrev(this.top);
        this.top = node;
    }

    public int pop() {
        Node<Integer> removedNumber = this.top;
        this.top = this.top.getPrev();
        return removedNumber.getNumber();

    }

    public Node<Integer> getTop() {
        return top;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private Node<Integer> currentNode = top;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public Integer next() {
                int currentNumber = currentNode.getNumber();
                this.currentNode = this.currentNode.getPrev();
                return (Integer) java.lang.Integer.valueOf(currentNumber);
            }
        };
    }
}