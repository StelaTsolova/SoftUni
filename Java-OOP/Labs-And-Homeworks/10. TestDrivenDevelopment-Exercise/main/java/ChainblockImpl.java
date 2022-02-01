import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {

    private Map<Integer, Transaction> transactions;

    public ChainblockImpl() {
        this.transactions = new LinkedHashMap<>();
    }

    @Override
    public int getCount() {
        return transactions.size();
    }

    @Override
    public void add(Transaction transaction) {
        if (!contains(transaction.getId())) {
            transactions.put(transaction.getId(), transaction);
        }
    }

    @Override
    public boolean contains(Transaction transaction) {
        return contains(transaction.getId());
    }

    @Override
    public boolean contains(int id) {
        for (Map.Entry<Integer, Transaction> entry : transactions.entrySet()) {
            if (entry.getKey() == id) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if (!contains(id)) {
            throw new IllegalArgumentException();
        }
        transactions.get(id).setStatus(newStatus);
    }

    @Override
    public void removeTransactionById(int id) {
        if (!contains(id)) {
            throw new IllegalArgumentException();
        }
        transactions.remove(id);
    }

    @Override
    public Transaction getById(int id) {
        if (!contains(id)) {
            throw new IllegalArgumentException();
        }
        return transactions.get(id);
    }

    @Override
    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> collect = transactions.values().stream().filter(t -> t.getStatus().equals(status))
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if (collect.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return collect;
    }

    @Override
    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        List<String> collect = transactions.values().stream().filter(t -> t.getStatus().equals(status))
                .sorted(Comparator.comparingDouble(Transaction::getAmount))
                .map(Transaction::getFrom)
                .collect(Collectors.toList());

        if (collect.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return collect;
    }

    @Override
    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        List<String> collect = transactions.values().stream().filter(t -> t.getStatus().equals(status))
                .map(Transaction::getTo)
                .collect(Collectors.toList());

        if (collect.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return collect;
    }

    @Override
    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return transactions.values().stream()
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed().thenComparingInt(Transaction::getId))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        List<Transaction> collect = transactions.values().stream().filter(t -> t.getFrom().equals(sender))
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if (collect.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return collect;
    }

    @Override
    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        List<Transaction> collect = transactions.values().stream().filter(t -> t.getTo().equals(receiver))
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed().thenComparingInt(Transaction::getId))
                .collect(Collectors.toList());

        if (collect.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return collect;
    }

    @Override
    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return transactions.values().stream()
                .filter(t -> t.getStatus().equals(status) && t.getAmount() <= amount)
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        List<Transaction> collect = transactions.values().stream()
                .filter(t -> t.getFrom().equals(sender) && t.getAmount() > amount)
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        if (collect.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return collect;
    }

    @Override
    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        List<Transaction> collect = transactions.values().stream()
                .filter(t -> t.getTo().equals(receiver) && (t.getAmount() >= lo && t.getAmount() < hi))
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed().thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        if (collect.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return collect;
    }

    @Override
    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return transactions.values().stream()
                .filter(t -> t.getAmount() >= lo && t.getAmount() <= hi)
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Transaction> iterator() {
        return transactions.values().iterator();
    }
}
