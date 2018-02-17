package com.company;

/**
 * Created by praba on 17/02/18.
 */
public abstract class Cell {
    private int amountToProcess;

    public Cell(int amountToProcess) {
        this.amountToProcess = amountToProcess;
    }

    public int getAmountToProcess() {
        return amountToProcess;
    }

    public abstract void process(Player player);
}
