package com.company;

/**
 * Created by praba on 17/02/18.
 */
public class Jail extends Cell {

    public Jail(int amountToProcess) {
        super(amountToProcess);
    }

    @Override
    public void process(Player player) {
        player.setAmount(player.getAmount() - getAmountToProcess());
    }
}
