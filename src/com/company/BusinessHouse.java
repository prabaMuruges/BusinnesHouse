package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class BusinessHouse {

    public static void main(String[] args) {
        CellType[] cellTypesInBoard = { CellType.EMPTY, CellType.HOTEL, CellType.JAIL, CellType.TREASURE };

        HashMap<CellType, Integer> cellTypeProcessAmount = new HashMap<>();
        cellTypeProcessAmount.put(CellType.EMPTY, 0);
        cellTypeProcessAmount.put(CellType.JAIL, 150);
        cellTypeProcessAmount.put(CellType.HOTEL, 200);
        cellTypeProcessAmount.put(CellType.TREASURE, 200);

        Board board = new Board(new ArrayList(), new CellFactory(50));

        for (CellType cellType : cellTypesInBoard) {
            board.addCells(cellType, cellTypeProcessAmount.get(cellType));
        }

        Player praba = new Player(1000);
        Player gracil = new Player(1000);
        Player kd = new Player(1000);

        board.move(kd, 2);
        board.move(kd, 3);

        board.move(praba, 2);
        board.move(praba, 3);

        board.move(gracil, 2);
        board.move(gracil, 3);

        System.out.println("Praba's Amount: " + praba.getAmount());
        System.out.println("KD's Amount: " + kd.getAmount());
        System.out.println("Gracil's Amount: " + gracil.getAmount());
    }
}
