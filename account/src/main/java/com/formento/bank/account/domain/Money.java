package com.formento.bank.account.domain;

import java.math.BigInteger;

// TODO test
public class Money {

    public static final Money ZERO = Money.of(0);

    private final BigInteger amount;

    private Money(BigInteger amount) {
        this.amount = amount;
    }

    public static Money of(long value) {
        return new Money(BigInteger.valueOf(value));
    }

    public BigInteger getAmount() {
        return amount;
    }

    public boolean isPositiveOrZero() {
        return this.amount.compareTo(BigInteger.ZERO) >= 0;
    }

    public boolean isPositive() {
        return this.amount.compareTo(BigInteger.ZERO) > 0;
    }

    public boolean isNegative() {
        return this.amount.compareTo(BigInteger.ZERO) < 0;
    }

    public boolean isGreaterThan(Money money) {
        return this.amount.compareTo(money.amount) >= 1;
    }

    public Money minus(Money money) {
        return new Money(this.amount.subtract(money.amount));
    }

    public Money plus(Money money) {
        return new Money(this.amount.add(money.amount));
    }

    public Money negate() {
        return new Money(this.amount.negate());
    }

}
