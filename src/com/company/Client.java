package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Client {

    public static void main(String[] args) {
        // Processing Inputs
        InputProcessor inputs = new InputProcessor("input.txt");
        inputs.processFile();

        // Creating cells
        HashMap<CellType, Integer> cellValues = inputs.getCellValues();
        CellFactory cellFactory = new CellFactory(inputs.getHotelRent());
        List cells = new ArrayList();
        int cellPosition = 1;
        for (String type: inputs.getCells()) {
            CellType cellType = CellType.findByAbbr(type);
            cells.add(cellFactory.getCell(cellType, cellValues.get(cellType), cellPosition++));
        }

        Board board = new Board(cells);

        // Creating Players
        List players = new ArrayList<Player>();
        for (int player = 1; player <= inputs.getNoOfPlayers(); player++) {
            players.add(new Player("Player " + player, inputs.getInitialAmount()));
        }

        // Game
        BusinessHouse game = new BusinessHouse(board, players, inputs.getDiceValues());
        game.start();
        game.getResults();
    }
}
