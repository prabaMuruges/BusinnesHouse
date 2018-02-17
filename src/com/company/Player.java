package com.company;

import java.util.List;

/**
 * Created by praba on 17/02/18.
 */
public class Player {
    private Wallet wallet;
    private int cellPosition;

    public Player(int amount) {
        this.wallet = new Wallet(amount);
        this.cellPosition = 0;
    }

    public int getCellPosition() {
        return cellPosition;
    }

    public void pay(Player payee, int amount) {
        wallet.debit(amount);
        payee.wallet.credit(amount);
    }

    public void moveTo(Cell cell, int newPosition){
        if (cell instanceof Hotel) {
            handleOwnables((Hotel) cell);
        } else {
            handleNonOwnables(cell);
        }
        cellPosition = newPosition;
    }

    public int getWorth(){
        return wallet.getAmount();
    }

    private void handleOwnables(Hotel hotel){
        if (hotel.hasOwner()) {
            pay(hotel.getOwner(), hotel.getRent());
        } else {
            hotel.makeOwner(this);
        }
    }

    private void handleNonOwnables(Cell cell){
        if(cell.isCreditable()) {
            wallet.credit(cell.getValue());
        } else {
            wallet.debit(cell.getValue());
        }
    }
}
