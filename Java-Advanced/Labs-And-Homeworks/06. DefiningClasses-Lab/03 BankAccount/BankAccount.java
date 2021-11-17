package BankAccount_3;

public class BankAccount {
    private static int accountNextId = 1;
    private static double interestRate = 0.02;

    private int id;
    private double balance;

    BankAccount() {
        this.id = accountNextId++;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        BankAccount.interestRate = interestRate;
    }

    public static int getAccountsCount() {
        return accountNextId;
    }

    public double getInterest(int years) {
        return this.balance * interestRate * years;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public int getId() {
        return id;
    }
}
