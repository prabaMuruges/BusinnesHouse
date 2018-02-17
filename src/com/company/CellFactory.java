package com.company;

/**
 * Created by praba on 17/02/18.
 */
public class CellFactory {
    private int hotelRent;

    public CellFactory(int hotelRent) {
        this.hotelRent = hotelRent;
    }

    public Cell getCell(String type, int amountToProcess) {
        Cell cell = null;
        switch (type){
            case "E":
                cell = new Empty();
                break;
            case "J":
                cell = new Jail(amountToProcess);
                break;
            case "T":
                cell = new Treasure(amountToProcess);
                break;
            case "H":
                cell = new Hotel(amountToProcess, hotelRent);
        }
        return cell;
    }
}
