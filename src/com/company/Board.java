package com.company;

import java.util.List;

public class Board {
    private List<Cell> cells;

    public Board(List cells) {
        this.cells = cells;
    }

    public void process(Player player, int diceValue) {
        int currentCellIndex = player.getCurrentCell().map(cell -> cell.getPosition()).orElse(0);
        int newPosition = currentCellIndex + diceValue - 1;
        Cell cellToMove = cells.get(newPosition % cells.size());
        player.moveTo(cellToMove);
    }
}
