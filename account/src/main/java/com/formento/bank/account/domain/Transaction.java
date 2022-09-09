package com.formento.bank.account.domain;

import com.formento.bank.account.domain.Account.AccountId;

public class Transaction {

    private final String id;
    private final AccountId accountId;
    private final Money amount;

    public Transaction(String id, AccountId accountId, Money amount) {
        this.id = id;
        this.accountId = accountId;
        this.amount = amount;
    }

    public Money getAmount() {
        return amount;
    }
}