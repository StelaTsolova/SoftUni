package GreedyTimes_6;

public class Gem implements Comparable<Gem>{
    private String name;
    private Long amount;

    public Gem(String name, long amount) {
        this.name = name;
        this.amount = amount;
    }

    public Long getAmount() {
        return this.amount;
    }

    @Override
    public String toString() {
        return "##" + this.name + " - " + this.amount;
    }

    @Override
    public int compareTo(Gem o) {
        int result = o.name.compareTo(name);
        if (result == 0){
            result = amount.compareTo(o.getAmount());
        }
        return result;
    }
}
