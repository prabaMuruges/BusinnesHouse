package com.company;

/**
 * Created by praba on 17/02/18.
 */
public abstract class Cell {
    private int value;

    public Cell(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public abstract boolean isCreditable();
}
