package com.company;

import java.util.List;

/**
 * Created by praba on 17/02/18.
 */
public class Board {
    private List<Cell> cells;

    public Board(List cells) {
        this.cells = cells;
    }

    public void process(Player player, int diceValue) {
        int newPosition = player.getCellPosition() + diceValue;
        Cell cellToMove = cells.get(newPosition - 1);
        player.moveTo(cellToMove, newPosition);
    }
}
