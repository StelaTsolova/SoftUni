package GreedyTimes_6;

public class Cash implements Comparable<Cash>{
    private String name;
    private Long amount;

    public Cash(String name, long amount) {
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
    public int compareTo(Cash o) {
        int result = o.name.compareTo(name);
        if (result == 0){
            result = amount.compareTo(o.getAmount());
        }
        return result;
    }
}