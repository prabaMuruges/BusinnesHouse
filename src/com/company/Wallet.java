package com.company;

/**
 * Created by praba on 17/02/18.
 */
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
