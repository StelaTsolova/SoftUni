package BankAccount_3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<Integer, BankAccount> accounts = new HashMap<>();
        while (!input.equals("End")) {
            String[] command = input.split("\\s+");
            String output = null;
            if (command[0].equals("Create")) {
                BankAccount bankAccount = new BankAccount();
                accounts.put(bankAccount.getId(), bankAccount);
                output = String.format("Account ID%d created", bankAccount.getId());
            } else if (command[0].equals("Deposit")) {
                int id = Integer.parseInt(command[1]);
                int amount = Integer.parseInt(command[2]);
                output = executeIfNotNull(accounts.get(id), b -> {
                    b.deposit(amount);
                    return String.format("Deposited %d to ID%d", amount, id);
                });
            } else if (command[0].equals("SetInterest")) {
                BankAccount.setInterestRate(Double.parseDouble(command[1]));
            } else if (command[0].equals("GetInterest")) {
                int id = Integer.parseInt(command[1]);
                int years = Integer.parseInt(command[2]);
                output = executeIfNotNull(accounts.get(id), b -> {
                    double interest = b.getInterest(years);
                    return String.format("%.2f", interest);
                });
            }
            if (output != null) {
                System.out.println(output);
            }
            input = scanner.nextLine();
        }
    }

    public static String executeIfNotNull(BankAccount account, Function<BankAccount, String> function) {
        if (account == null) {
            return "Account does not exist";
        }
        return function.apply(account);
    }
}
