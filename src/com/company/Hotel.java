package com.company;

/**
 * Created by praba on 17/02/18.
 */
public class Hotel extends Cell  {
    private Player owner;
    private int rent;

    public Hotel(int amountToProcess, int rent) {
        super(amountToProcess);
        this.rent = rent;
    }

    public void setOwner(Player owner) {
        if (owner.getAmount() >= getAmountToProcess()) {
            owner.setAmount(owner.getAmount() - getAmountToProcess());
            this.owner = owner;
        } else {
            owner.setAmount(owner.getAmount() - rent);
        }
    }

    public void creditOwner(Player player){
        player.setAmount(player.getAmount() - rent);
        owner.setAmount(owner.getAmount() + rent);
    }

    public boolean hasOwner(){
        return !(owner == null);
    }

    @Override
    public void process(Player player) {
        if(hasOwner()) {
            creditOwner(player);
        } else {
            setOwner(player);
        }
    }
}
