package com.company;

public class Empty extends Cell {

    public Empty(int position) {
        super(position,0);
    }

    @Override
    public boolean isCreditable() {
        return false;
    }
}
