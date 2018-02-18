package com.company;

import java.util.Collections;
import java.util.List;

public class BusinessHouse {
    private Board board;
    private List<Player> players;
    private int[] diceInputs;

    public BusinessHouse(Board board, List<Player> players, int[] diceInputs) {
        this.board = board;
        this.players = players;
        this.diceInputs = diceInputs;
    }

    public void start(){
        int playerIndex = 0;
        for (int diceInput: diceInputs) {
            Player player = players.get(playerIndex % players.size());
            playerIndex++;

            board.process(player, diceInput);
        }
    }

    public void getResults(){
        Collections.sort(players);
        players.forEach(System.out::println);
    }

}
