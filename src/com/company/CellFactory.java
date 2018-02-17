package com.company;

/**
 * Created by praba on 17/02/18.
 */
public class CellFactory {
    private int hotelRent;

    public CellFactory(int hotelRent) {
        this.hotelRent = hotelRent;
    }

    public Cell getCell(CellType type, int amountToProcess) {
        Cell cell = null;
        switch (type){
            case EMPTY:
                cell = new Empty();
                break;
            case JAIL:
                cell = new Jail(amountToProcess);
                break;
            case TREASURE:
                cell = new Treasure(amountToProcess);
                break;
            case HOTEL:
                cell = new Hotel(amountToProcess, hotelRent);
        }
        return cell;
    }
}
