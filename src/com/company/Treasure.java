package com.company;

public class Treasure extends Cell {

    public Treasure(int position, int amountToProcess) {
        super(position, amountToProcess);
    }

    @Override
    public boolean isCreditable() {
        return true;
    }
}
