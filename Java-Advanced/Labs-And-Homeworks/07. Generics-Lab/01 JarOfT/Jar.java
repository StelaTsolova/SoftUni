package JarOfT_1;

import java.util.ArrayDeque;

public class Jar<E> {
    private ArrayDeque<E> stack;

    public Jar() {
        this.stack = new ArrayDeque<E>();
    }

    public void add(E element) {
        this.stack.push(element);
    }

    public E remove() {
        return this.stack.pop();
    }
}
