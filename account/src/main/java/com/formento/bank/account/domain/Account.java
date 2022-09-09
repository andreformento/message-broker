package com.formento.bank.account.domain;

import java.util.List;

import static java.util.Collections.emptyList;

public class Account {

    private final AccountId accountId;
    private final String ownerName; // a simplification of user
    private final TransactionHistory transactionHistory;

    private Account(AccountId accountId, String ownerName, TransactionHistory transactionHistory) {
        this.accountId = accountId;
        this.ownerName = ownerName;
        this.transactionHistory = transactionHistory;
    }

    public static Account createAccount(String ownerName) {
        return new Account(null, ownerName, new TransactionHistory(null, Money.ZERO, emptyList()));
    }

    public static Account existentAccount(AccountId accountId, String ownerName, Money baselineAmount, List<Transaction> transactions) {
        return new Account(null, ownerName, new TransactionHistory(accountId, baselineAmount, transactions));
    }

    // TODO test
    public Transaction hire(Money money) {
        if (!money.isPositive()) {
            throw new RuntimeException(String.format("Only can hire positive amount: %s", money.getAmount()));
        }

        return transactionHistory.add(money);
    }

    // TODO test
    public Transaction withdraw(Money money) {
        if (!money.isNegative()) {
            throw new RuntimeException(String.format("Only can withdraw negative amount: %s", money.getAmount()));
        }

        Money balance = transactionHistory.balance();

        // limit account can be calculated here
        if (balance.plus(money).isNegative()) {
            throw new RuntimeException(String.format("Oops! Limit is exceeded. You have only %s", balance.getAmount()));
        }

        return transactionHistory.add(money);
    }

    public record AccountId(String id) {
    }

}
