package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

public class InputProcessor {
    private static final String[] ALLOWED_KEYS = { "Number of Players", "Cells", "Dice Output", "Initial Money", "Hotel Rent", "Hotel Worth", "Jail Fine", "Treasure Value" };

    private String fileName;
    private int noOfPlayers;
    private int initialAmount;
    private int[] diceValues;
    private String[] cells;
    private int hotelRent;
    private HashMap<CellType, Integer> cellValues;

    public InputProcessor(String fileName) {
        this.fileName = fileName;
        this.cellValues = new HashMap();
        cellValues.put(CellType.EMPTY, 0);
    }

    public void processFile() {
        HashMap<String, String> keyValues = new HashMap();
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(line -> {
                String[] inputPair = line.trim().split(":");
                String key = inputPair[0].trim();
                validateKey(key);
                keyValues.put(key, inputPair[1].trim());
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        processInputValues(keyValues);
    }

    public int getInitialAmount() {
        return initialAmount;
    }

    public int[] getDiceValues() {
        return diceValues;
    }

    public String[] getCells() {
        return cells;
    }

    public int getHotelRent() {
        return hotelRent;
    }

    public HashMap<CellType, Integer> getCellValues() {
        return cellValues;
    }

    public int getNoOfPlayers() {
        return noOfPlayers;
    }

    private void processInputValues(HashMap<String, String> keyValues){
        keyValues.forEach((key, value) -> {
            switch (key) {
                case "Number of Players":
                    noOfPlayers = Integer.parseInt(value);
                    if(noOfPlayers < 2) {
                        throw new RuntimeException("Sorry! Bussiness should have atleast two players to play.");
                    }
                    break;
                case "Cells":
                    cells = value.split(",");
                    break;
                case "Initial Money":
                    initialAmount = Integer.parseInt(value);
                    break;
                case "Dice Output":
                    diceValues = Arrays.stream(value.split(",")).mapToInt(diceValue -> Integer.parseInt(diceValue)).toArray();
                    break;
                case "Hotel Worth":
                    cellValues.put(CellType.HOTEL, Integer.parseInt(value));
                    break;
                case "Hotel Rent":
                    hotelRent = Integer.parseInt(value);
                    break;
                case "Jail Fine":
                    cellValues.put(CellType.JAIL, Integer.parseInt(value));
                    break;
                case "Treasure Value":
                    cellValues.put(CellType.TREASURE, Integer.parseInt(value));
            }
        });
    }

    private void validateKey(String key) {
        if(Arrays.stream(ALLOWED_KEYS).filter(s -> s.equals(key)) == null) {
            throw new RuntimeException("Keys should be in " + ALLOWED_KEYS.toString());
        }
    }
}
