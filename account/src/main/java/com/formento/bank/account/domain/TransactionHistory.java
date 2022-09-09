package com.formento.bank.account.domain;

import com.formento.bank.account.domain.Account.AccountId;

import java.util.List;

public class TransactionHistory {

    private final AccountId accountId;
    private final Money baselineAmount;
    private final List<Transaction> transactions;

    public TransactionHistory(AccountId accountId, Money baselineAmount, List<Transaction> transactions) {
        this.accountId = accountId;
        this.baselineAmount = baselineAmount;
        this.transactions = transactions;
    }

    public Transaction add(Money money) {
        Transaction transaction = new Transaction(null, accountId, money);
        transactions.add(transaction);
        return transaction;
    }

    public Money balance() {
        return transactions
                .stream()
                .map(Transaction::getAmount)
                .reduce(baselineAmount, Money::plus);
    }
}