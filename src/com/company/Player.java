package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Player implements Comparable<Player> {
    private String name;
    private Wallet wallet;
    private Optional<Cell> currentCell;
    private List<Hotel> hotels;

    public Player(String name, int amount) {
        this.name = name;
        this.wallet = new Wallet(amount);
        this.currentCell = Optional.empty();
        this.hotels = new ArrayList();
    }

    public Optional<Cell> getCurrentCell() {
        return currentCell;
    }

    public void pay(Player payee, int amount) {
        wallet.debit(amount);
        payee.wallet.credit(amount);
    }

    public void buy(Hotel hotel) {
        if(getWorth() >= hotel.getValue()) {
            wallet.debit(hotel.getValue());
            hotel.makeOwner(this);
            hotels.add(hotel);
        }
    }

    public void moveTo(Cell cell){
        if (cell instanceof Hotel) {
            if(!hotels.contains(cell)) {
                handleOwnables((Hotel) cell);
            }
        } else {
            handleNonOwnables(cell);
        }
        currentCell = Optional.of(cell);
    }

    public int getWorth(){
        return wallet.getAmount();
    }

    public int getNetWorth() {
        return getWorth() + hotels.stream().mapToInt(hotel -> hotel.getValue()).sum();
    }

    private void handleOwnables(Hotel hotel){
        if (hotel.hasOwner()) {
            pay(hotel.getOwner(), hotel.getRent());
        } else {
            buy(hotel);
        }
    }

    private void handleNonOwnables(Cell cell){
        if(cell.isCreditable()) {
            wallet.credit(cell.getValue());
        } else {
            wallet.debit(cell.getValue());
        }
    }

    @Override
    public String toString() {
        return "Name: " + this.name + " Worth: " + this.getNetWorth();
    }

    @Override
    public int compareTo(Player o) {
        return o.getNetWorth() - this.getNetWorth();
    }
}
