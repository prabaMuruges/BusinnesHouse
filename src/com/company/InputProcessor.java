package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class InputProcessor {
    private static final String NUMBER_OF_PLAYERS = "Number of Players";
    private static final String CELLS = "Cells";
    private static final String DICE_OUTPUT = "Dice Output";
    private static final String INITIAL_MONEY = "Initial Money";
    private static final String HOTEL_RENT = "Hotel Rent";
    private static final String HOTEL_WORTH = "Hotel Worth";
    private static final String JAIL_FINE = "Jail Fine";
    private static final String TREASURE_VALUE = "Treasure Value";


    private static final String[] ALLOWED_KEYS = { NUMBER_OF_PLAYERS, CELLS, DICE_OUTPUT, INITIAL_MONEY,
            HOTEL_RENT, HOTEL_WORTH, JAIL_FINE, TREASURE_VALUE };

    private String fileName;
    private int noOfPlayers;
    private int initialAmount;
    private int[] diceValues;
    private String[] cellTypes;
    private int hotelRent;
    private HashMap<CellType, Integer> cellValues;

    public InputProcessor(String fileName) {
        this.fileName = fileName;
        this.cellValues = new HashMap<>();
        cellValues.put(CellType.EMPTY, 0);
    }

    public void processFile() {
        HashMap<String, String> keyValues = new HashMap<>();
        try {
            Files.lines(Paths.get(fileName)).forEach(line -> {
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

    public int readInitialAmount() {
        return initialAmount;
    }

    public int[] readDiceValues() {
        return diceValues;
    }

    public String[] readCellTypes() {
        return cellTypes;
    }

    public int readHotelRent() {
        return hotelRent;
    }

    public HashMap<CellType, Integer> readCellValues() {
        return cellValues;
    }

    public int readNoOfPlayers() {
        return noOfPlayers;
    }

    private void processInputValues(HashMap<String, String> keyValues){
        keyValues.forEach((key, value) -> {
            switch (key) {
                case NUMBER_OF_PLAYERS:
                    int noOfPlayersFromFile = Integer.parseInt(value);
                    validateNoOfPlayers(noOfPlayersFromFile);
                    noOfPlayers = noOfPlayersFromFile;
                    break;
                case CELLS:
                    cellTypes = value.split(",");
                    break;
                case INITIAL_MONEY:
                    initialAmount = Integer.parseInt(value);
                    break;
                case DICE_OUTPUT:
                    int[] diceValuesFromFile = Arrays.stream(value.split(","))
                            .mapToInt(Integer::parseInt)
                            .toArray();
                    validateDiceValues(diceValuesFromFile);
                    diceValues = diceValuesFromFile;
                    break;
                case HOTEL_WORTH:
                    cellValues.put(CellType.HOTEL, Integer.parseInt(value));
                    break;
                case HOTEL_RENT:
                    hotelRent = Integer.parseInt(value);
                    break;
                case JAIL_FINE:
                    cellValues.put(CellType.JAIL, Integer.parseInt(value));
                    break;
                case TREASURE_VALUE:
                    cellValues.put(CellType.TREASURE, Integer.parseInt(value));
            }
        });
    }

    private void validateNoOfPlayers(int noOfPlayersFromFile) {
        if(noOfPlayersFromFile < 2) {
            throw new RuntimeException("BussinessHouse should have atleast two players to play.");
        }
    }

    private void validateDiceValues(int[] diceValuesFromFile) {
        OptionalInt invalidDiceValue = Arrays.stream(diceValuesFromFile)
                .filter(val -> val < 2 || val > 12)
                .findFirst();
        if(invalidDiceValue.isPresent()){
            throw new RuntimeException("Dice Output should be within 2 - 12");
        }
    }

    private void validateKey(String key) {
        if(Arrays.stream(ALLOWED_KEYS).filter(s -> s.equals(key)) == null) {
            throw new RuntimeException("Keys should be in " + Arrays.toString(ALLOWED_KEYS));
        }
    }
}
