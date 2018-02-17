package com.company;

/**
 * Created by praba on 17/02/18.
 */
public class Hotel extends Cell  {
    private int rent;
    private Player owner;

    public Hotel(int value, int rent) {
        super(value);
        this.rent = rent;
    }

    public Player getOwner() {
        return owner;
    }

    public void makeOwner(Player player) {
        if(player.getWorth() >= getValue()) {
            this.owner = player;
        }
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
