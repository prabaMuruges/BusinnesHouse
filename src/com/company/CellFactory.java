package com.company;

public class CellFactory {
    private int hotelRent;

    public CellFactory(int hotelRent) {
        this.hotelRent = hotelRent;
    }

    public Cell getCell(CellType type, int amountToProcess, int position) {
        Cell cell = null;
        switch (type){
            case EMPTY:
                cell = new Empty(position);
                break;
            case JAIL:
                cell = new Jail(position, amountToProcess);
                break;
            case TREASURE:
                cell = new Treasure(position, amountToProcess);
                break;
            case HOTEL:
                cell = new Hotel(position, amountToProcess, hotelRent);
        }
        return cell;
    }
}
