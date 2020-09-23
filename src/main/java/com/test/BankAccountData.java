package com.test;

import java.util.concurrent.atomic.AtomicInteger;

public class BankAccountData {
    Integer executedTxn;
    Integer maxSupportedTxn;


    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public AtomicInteger getBalance() {
        return balance;
    }

    public void setBalance(AtomicInteger balance) {
        this.balance = balance;
    }

    String bankName;
    AtomicInteger balance;

    @Override
    public String toString() {
        return "BankAccountData{" +
                "bankName='" + bankName + '\'' +
                ", amount=" + balance +
                '}';
    }
}
