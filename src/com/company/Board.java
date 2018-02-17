package com.company;

import java.util.ArrayList;

/**
 * Created by praba on 17/02/18.
 */
public class Board {
    private ArrayList<Cell> cells;
    private CellFactory cellFactory;

    public Board(ArrayList<Cell> cells, CellFactory cellFactory) {
        this.cells = cells;
        this.cellFactory = cellFactory;
    }

    public void addCells(CellType cellType, int amountToProcess) {
        Cell cell = cellFactory.getCell(cellType, amountToProcess);

        if(cell == null) {
            throw new java.lang.RuntimeException("Please specify a valid Cell Type");
        }

        cells.add(cell);
    }

    public void move(Player player, int position) {
        Cell cell = cells.get(position - 1);
        cell.process(player);
    }
}
