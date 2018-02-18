package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        InputProcessor inputs = new InputProcessor("input.txt");
        inputs.processFile();

        BusinessHouse game = new BusinessHouse(new Board(getCells(inputs))
                , getPlayers(inputs), inputs.readDiceValues());
        game.start();
        game.getResults();
    }

    private static List<Player> getPlayers(InputProcessor inputs) {
        ArrayList<Player> players = new ArrayList<>();
        for (int player = 1; player <= inputs.readNoOfPlayers(); player++) {
            players.add(new Player("Player " + player, inputs.readInitialAmount()));
        }
        return players;
    }

    private static List<Cell> getCells(InputProcessor inputs) {
        HashMap<CellType, Integer> cellValues = inputs.readCellValues();
        CellFactory cellFactory = new CellFactory();
        ArrayList<Cell> cells = new ArrayList<>();
        int cellPosition = 1;

        for (String type: inputs.readCellTypes()) {
            CellType cellType = CellType.findByAbbreviation(type);
            cells.add(cellFactory.getCell(
                    cellType,
                    cellValues.get(cellType),
                    cellPosition++,
                    inputs.readHotelRent())
            );
        }
        return cells;
    }
}
