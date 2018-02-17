package com.company;

/**
 * Created by praba on 17/02/18.
 */
public class Treasure extends Cell {

    public Treasure(int amountToProcess) {
        super(amountToProcess);
    }

    @Override
    public void process(Player player) {
        player.setAmount(player.getAmount() + getAmountToProcess());
    }
}
