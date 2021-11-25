package Tuple_10;

public class Tuple<T, E>  {
    private T item1;
    private E item2;

    public Tuple(T item1, E item2){
        this.item1 = item1;
        this.item2 = item2;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(this.item1).append(" -> ").append(this.item2).append("\n").toString();
    }
}