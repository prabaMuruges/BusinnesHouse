package com.company;

public class Jail extends Cell {

    public Jail(int position, int amountToProcess) {
        super(position, amountToProcess);
    }

    @Override
    public boolean isCreditable() {
        return false;
    }
}
