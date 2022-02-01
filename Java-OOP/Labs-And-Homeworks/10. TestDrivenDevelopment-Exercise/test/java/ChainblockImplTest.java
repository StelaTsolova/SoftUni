import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ChainblockImplTest {
    private static final int TRANSACTION_ID = 1;
    private static final TransactionStatus TRANSACTION_STATUS = TransactionStatus.FAILED;
    private static final String TRANSACTION_FROM = "Toto";
    private static final String TRANSACTION_TO = "Petya";
    private static final double TRANSACTION_AMOUNT = 122.53;

    private Chainblock chainblock;
    private Transaction transaction;

    @Before
    public void setUp() {
        chainblock = new ChainblockImpl();
        transaction = new TransactionImpl(TRANSACTION_ID, TRANSACTION_STATUS, TRANSACTION_FROM,
                TRANSACTION_TO, TRANSACTION_AMOUNT);
    }

    @Test
    public void testAddShouldAddTransactionWhenNotPresent() {
        chainblock.add(transaction);

        Assert.assertEquals(1, chainblock.getCount());
    }

    @Test
    public void testAddNotShouldAddTransactionWhenPresent() {
        chainblock.add(transaction);
        chainblock.add(transaction);

        Assert.assertEquals(1, chainblock.getCount());
    }

    @Test
    public void testContainsReturnFalseWhenTransactionNotInChainblockAndReturnTrueAfterAdded() {
        Assert.assertFalse(chainblock.contains(transaction));

        chainblock.add(transaction);
        Assert.assertTrue(chainblock.contains(transaction));
    }

    @Test
    public void testContainsReturnTrueWhenTransactionInChainblock() {
        chainblock.add(transaction);

        Assert.assertTrue(chainblock.contains(transaction));
    }

    @Test
    public void testGetCountReturnTheCorrect() {
        fillChainblock();

        Assert.assertEquals(6, chainblock.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeTransactionStatusThrowWhenTransactionGivenIdNotPresent() {
        fillChainblock();

        chainblock.changeTransactionStatus(TRANSACTION_ID, TransactionStatus.ABORTED);
    }

    @Test
    public void testChangeTransactionStatusShouldChangeCorrectTransactionStatus() {
        chainblock.add(transaction);

        chainblock.changeTransactionStatus(TRANSACTION_ID, TransactionStatus.ABORTED);

        Assert.assertNotNull(chainblock.getById(TRANSACTION_ID));
        Assert.assertEquals(TransactionStatus.ABORTED, chainblock.getById(TRANSACTION_ID).getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTransactionByIdThrowWhenTransactionGivenIdNotPresent() {
        fillChainblock();

        chainblock.removeTransactionById(TRANSACTION_ID);
    }

    @Test
    public void testRemoveTransactionByIdShouldRemoveTheCorrect() {
        chainblock.add(transaction);
        Assert.assertEquals(1, chainblock.getCount());

        chainblock.removeTransactionById(TRANSACTION_ID);

        Assert.assertEquals(0, chainblock.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIdThrowWhenTransactionGivenIdNotPresent() {
        fillChainblock();

        chainblock.getById(TRANSACTION_ID);
    }

    @Test
    public void testGetByIdShouldReturnTheCorrectTransaction() {
        chainblock.add(transaction);

        Assert.assertEquals(transaction, chainblock.getById(TRANSACTION_ID));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionStatusThrowWhenTransactionWithGivenStatusNotPresent() {
        fillChainblock();

        chainblock.getByTransactionStatus(TRANSACTION_STATUS);
    }

    @Test
    public void testGetByTransactionStatusShouldReturnCorrectObject() {
        List<Transaction> transactionList = fillChainblock().stream()
                .filter(t -> t.getStatus() == TransactionStatus.SUCCESSFUL)
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed()).collect(Collectors.toList());

        List<Transaction> listFromIterableTransaction = createListFromIterableTransaction(chainblock
                .getByTransactionStatus(TransactionStatus.SUCCESSFUL));

        for (int i = 0; i < transactionList.size(); i++) {
            Assert.assertEquals(transactionList.get(i), listFromIterableTransaction.get(i));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllSendersWithTransactionStatusThrowWhenTransactionWithGivenStatusNotPresent() {
        fillChainblock();

        chainblock.getAllSendersWithTransactionStatus(TRANSACTION_STATUS);
    }

    @Test
    public void testGetAllSendersWithTransactionStatusShouldReturnCorrectObject() {
        List<String> transactionList = fillChainblock().stream()
                .filter(t -> t.getStatus() == TransactionStatus.SUCCESSFUL)
                .sorted(Comparator.comparingDouble(Transaction::getAmount))
                .map(Transaction::getFrom).collect(Collectors.toList());

        List<String> listFromIterableString = createListFromIterableString(chainblock
                .getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL));

        for (int i = 0; i < transactionList.size(); i++) {
            Assert.assertEquals(transactionList.get(i), listFromIterableString.get(i));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllReceiversWithTransactionStatusThrowWhenTransactionWithGivenStatusNotPresent() {
        fillChainblock();

        chainblock.getAllReceiversWithTransactionStatus(TRANSACTION_STATUS);
    }

    @Test
    public void testGetAllReceiversWithTransactionStatusShouldReturnCorrectObject() {
        List<String> transactionList = fillChainblock().stream()
                .filter(t -> t.getStatus() == TransactionStatus.SUCCESSFUL)
                .map(Transaction::getTo).collect(Collectors.toList());

        List<String> listFromIterableString = createListFromIterableString(chainblock
                .getAllReceiversWithTransactionStatus(TransactionStatus.SUCCESSFUL));

        for (int i = 0; i < transactionList.size(); i++) {
            Assert.assertEquals(transactionList.get(i), listFromIterableString.get(i));
        }
    }

    @Test
    public void testGetAllOrderedByAmountDescendingThenByIdShouldReturnCorrectObject() {
        List<Transaction> transactionList = fillChainblock().stream()
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed().thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        List<Transaction> listFromIterableString = createListFromIterableTransaction(chainblock
                .getAllOrderedByAmountDescendingThenById());

        for (int i = 0; i < transactionList.size(); i++) {
            Assert.assertEquals(transactionList.get(i), listFromIterableString.get(i));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderOrderedByAmountDescendingThrowWhenTransactionWithGivenSenderNotPresent() {
        fillChainblock();

        chainblock.getBySenderOrderedByAmountDescending(TRANSACTION_FROM);
    }

    @Test
    public void testGetBySenderOrderedByAmountDescendingReturnCorrectObject() {
        List<Transaction> transactionList = fillChainblock().stream().filter(t -> t.getFrom().equals("Mitko"))
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        List<Transaction> listFromIterableString = createListFromIterableTransaction(chainblock
                .getBySenderOrderedByAmountDescending("Mitko"));

        for (int i = 0; i < transactionList.size(); i++) {
            Assert.assertEquals(transactionList.get(i), listFromIterableString.get(i));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverOrderedByAmountThenByIdThrowWhenTransactionWithGivenReceiverNotPresent() {
        fillChainblock();

        chainblock.getByReceiverOrderedByAmountThenById(TRANSACTION_TO);
    }

    @Test
    public void testGetByReceiverOrderedByAmountThenByIdReturnCorrectObject() {
        List<Transaction> transactionList = fillChainblock().stream().filter(t -> t.getTo().equals("Vili"))
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed().thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        List<Transaction> listFromIterableString = createListFromIterableTransaction(chainblock
                .getByReceiverOrderedByAmountThenById("Vili"));

        for (int i = 0; i < transactionList.size(); i++) {
            Assert.assertEquals(transactionList.get(i), listFromIterableString.get(i));
        }
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountReturnEmptyObjectWhenNotPresentAmountWithGivenRange() {
        List<Transaction> listFromIterableString = createListFromIterableTransaction(chainblock
                .getByTransactionStatusAndMaximumAmount(TRANSACTION_STATUS, 12.30));

        Assert.assertTrue(listFromIterableString.isEmpty());
    }

    @Test
    public void testGetByTransactionStatusAndMaximumAmountReturnCorrectObject() {
        List<Transaction> transactionList = fillChainblock().stream()
                .filter(t -> t.getStatus().equals(TransactionStatus.SUCCESSFUL) && t.getAmount() <= 1.79)
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        List<Transaction> listFromIterableString = createListFromIterableTransaction(chainblock
                .getByTransactionStatusAndMaximumAmount(TransactionStatus.SUCCESSFUL, 1.79));

        for (int i = 0; i < transactionList.size(); i++) {
            Assert.assertEquals(transactionList.get(i), listFromIterableString.get(i));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBySenderAndMinimumAmountDescendingThrowWhenTransactionWithGivenSenderAndAmountNotPresent() {
        fillChainblock();

        chainblock.getBySenderAndMinimumAmountDescending(TRANSACTION_FROM, TRANSACTION_AMOUNT);
    }

    @Test
    public void testGetBySenderAndMinimumAmountDescendingReturnCorrectObject() {
        List<Transaction> transactionList = fillChainblock().stream()
                .filter(t -> t.getFrom().equals("Lena") && t.getAmount() > 12.00)
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        List<Transaction> listFromIterableString = createListFromIterableTransaction(chainblock
                .getBySenderAndMinimumAmountDescending("Lena", 12.00));

        for (int i = 0; i < transactionList.size(); i++) {
            Assert.assertEquals(transactionList.get(i), listFromIterableString.get(i));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByReceiverAndAmountRangeThrowWhenTransactionWithGivenReceiverAndRangeNotPresent() {
        fillChainblock();

        chainblock.getByReceiverAndAmountRange(TRANSACTION_TO, 16, 14.26);
    }

    @Test
    public void testGetByReceiverAndAmountRangeReturnCorrectObject() {
        List<Transaction> transactionList = fillChainblock().stream()
                .filter(t -> t.getFrom().equals("Koko") && (t.getAmount() >= 12.00 && t.getAmount() < 18.00))
                .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed().thenComparing(Transaction::getId))
                .collect(Collectors.toList());

        List<Transaction> listFromIterableString = createListFromIterableTransaction(chainblock
                .getByReceiverAndAmountRange("Koko", 12.00, 18.00));

        for (int i = 0; i < transactionList.size(); i++) {
            Assert.assertEquals(transactionList.get(i), listFromIterableString.get(i));
        }
    }

    @Test
    public void testGetAllInAmountRangeReturnEmptyObjectWhenNotPresentAmountWithGivenRange() {
        List<Transaction> listFromIterableString = createListFromIterableTransaction(chainblock
                .getAllInAmountRange(200, 651.36));

        Assert.assertTrue(listFromIterableString.isEmpty());
    }

    @Test
    public void testGetAllInAmountRangeReturnCorrectObject() {
        List<Transaction> transactionList = fillChainblock().stream()
                .filter(t -> t.getAmount() >= 14.20 && t.getAmount() <= 137.74)
                .collect(Collectors.toList());

        List<Transaction> listFromIterableString = createListFromIterableTransaction(chainblock
                .getAllInAmountRange(14.20, 137.74));

        for (int i = 0; i < transactionList.size(); i++) {
            Assert.assertEquals(transactionList.get(i), listFromIterableString.get(i));
        }
    }

    public List<Transaction> fillChainblock() {
        List<Transaction> transactionList = Arrays.asList(
                new TransactionImpl(2, TransactionStatus.ABORTED, "Pesho", "Poly", 14.20),
                new TransactionImpl(14, TransactionStatus.UNAUTHORIZED, "Pena", "Vili", 137.74),
                new TransactionImpl(9, TransactionStatus.SUCCESSFUL, "Mitko", "Petko", 1.79),
                new TransactionImpl(8, TransactionStatus.ABORTED, "Mitko", "Petko", 1.79),
                new TransactionImpl(10, TransactionStatus.SUCCESSFUL, "Lena", "Koko", 18.00),
                new TransactionImpl(16, TransactionStatus.UNAUTHORIZED, "Lena", "Koko", 12.00)
        );

        for (Transaction transaction : transactionList) {
            chainblock.add(transaction);
        }

        return transactionList;
    }

    public List<Transaction> createListFromIterableTransaction(Iterable<Transaction> iterable) {
        Assert.assertNotNull(iterable);

        List<Transaction> listFromIterableTransaction = new ArrayList<>();
        iterable.forEach(listFromIterableTransaction::add);

        return listFromIterableTransaction;
    }

    public List<String> createListFromIterableString(Iterable<String> iterable) {
        Assert.assertNotNull(iterable);

        List<String> listFromIterableString = new ArrayList<>();
        iterable.forEach(listFromIterableString::add);

        return listFromIterableString;
    }
}