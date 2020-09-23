package com.test;

public class Transactions {
    public Transactions(Integer amount, String sadad) {
        this.amount = amount;
        this.details = details;
    }

    public Integer getAmount() {
        return amount;
    }

    public String getDetails() {
        return details;
    }

    Integer amount;
    String details;

    @Override
    public String toString() {
        return "Transactions{" +
                "amount=" + amount +
                ", details='" + details + '\'' +
                '}';
    }
}
