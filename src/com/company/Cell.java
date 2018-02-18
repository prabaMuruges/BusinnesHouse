package com.company;

public abstract class Cell {
    private int value;
    private int position;

    public Cell(int position, int value) {
        this.position = position;
        this.value = value;
    }

    public int getPosition() {
        return position;
    }

    public int getValue() {
        return value;
    }

    public abstract boolean isCreditable();
}
