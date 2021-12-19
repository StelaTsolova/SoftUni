package GreedyTimes_6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bag {
    private long capacity;
    private List<Long> golds;
    private List<Gem> gems;
    private List<Cash> cash;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.golds = new ArrayList<>();
        this.gems = new ArrayList<>();
        this.cash = new ArrayList<>();
    }

    public void addGold(long amount) {
        this.golds.add(amount);
    }

    public void addGem(String name, long amount) {
        Gem gem = new Gem(name, amount);
        this.gems.add(gem);
    }

    public void addCash(String name, long amount) {
        Cash cash = new Cash(name, amount);
        this.cash.add(cash);
    }

    public long sum() {
        return sumGolds() + sumGems() + sumCash();
    }

    public long sumGolds() {
        return golds.stream().mapToLong(a -> a).sum();
    }

    public long sumGems() {
        return gems.stream().mapToLong(Gem::getAmount).sum();
    }

    public long sumCash() {
        return cash.stream().mapToLong(Cash::getAmount).sum();
    }

    public String print() {
        StringBuilder output = new StringBuilder();
        Collections.sort(gems);
        Collections.sort(cash);
        if (!golds.isEmpty()) {
            output.append("<Gold> $").append(sumGolds()).append(System.lineSeparator())
                    .append("##Gold - ").append(sumGolds()).append(System.lineSeparator());
        }
        if (!gems.isEmpty()) {
            output.append("<Gem> $").append(sumGems()).append(System.lineSeparator());
            gems.forEach(g -> output.append(g.toString()).append(System.lineSeparator()));
        }
        if (!cash.isEmpty()) {
            output.append("<Cash> $").append(sumCash()).append(System.lineSeparator());
            cash.forEach(c -> output.append(c.toString()).append(System.lineSeparator()));
        }

        return output.toString();
    }
}