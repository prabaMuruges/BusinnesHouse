package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BusinessHouse {

    public static void main(String[] args) {
        String[] cellTypes = { "E", "H", "J", "T" };

        HashMap<String, Integer> cellAmountMap = new HashMap<>();
        cellAmountMap.put("E", 0);
        cellAmountMap.put("H", 200);
        cellAmountMap.put("J", 150);
        cellAmountMap.put("T", 200);

        CellFactory cellFactory = new CellFactory(50);
        List cells = new ArrayList();

        for (String type: cellTypes) {
            cells.add(cellFactory.getCell(type, cellAmountMap.get(type)));
        }

        Board board = new Board(cells);

        Player praba = new Player(1000);
        Player gracil = new Player(1000);
        Player kd = new Player(1000);

        board.process(praba, 2);
        board.process(praba, 1);

        board.process(kd, 2);
        board.process(kd, 1);

        board.process(gracil, 2);
        board.process(gracil, 1);

        System.out.println("Praba's Amount: " + praba.getWorth());
        System.out.println("KD's Amount: " + kd.getWorth());
        System.out.println("Gracil's Amount: " + gracil.getWorth());
    }
}
