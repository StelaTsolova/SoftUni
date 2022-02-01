public interface Transaction {
    TransactionStatus getStatus();

    int getId();

    double getAmount();

    String getFrom();

    String getTo();

    void setStatus(TransactionStatus status);
}
