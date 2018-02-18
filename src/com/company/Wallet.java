package com.company;

public class Wallet {
    private int amount;

    public Wallet(int amount) {
        this.amount = amount;
    }

    public void debit(int amount) {
        this.amount -= amount;
    }

    public void credit(int amount) {
        this.amount += amount;
    }

    public int getAmount() {
        return amount;
    }
}
