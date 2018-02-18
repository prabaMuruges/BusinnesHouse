package com.company;

public class Hotel extends Cell  {
    private int rent;
    private Player owner;

    public Hotel(int position, int value, int rent) {
        super(position, value);
        this.rent = rent;
    }

    public Player getOwner() {
        return owner;
    }

    public void makeOwner(Player player) {
        this.owner = player;
    }

    public int getRent() {
        return rent;
    }

    public boolean hasOwner(){
        return !(owner == null);
    }

    @Override
    public boolean isCreditable() {
        return false;
    }
}
