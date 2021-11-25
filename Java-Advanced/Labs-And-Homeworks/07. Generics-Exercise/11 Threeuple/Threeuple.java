package Threeuple_11;

public class Threeuple<T, E, V> {
    private T item1;
    private E item2;
    private V item3;

    public Threeuple(T item1, E item2, V item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(this.item1).append(" -> ").append(this.item2)
                .append(" -> ").append(this.item3).append("\n").toString();
    }
}
