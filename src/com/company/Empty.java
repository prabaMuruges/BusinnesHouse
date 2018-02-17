package com.company;

/**
 * Created by praba on 17/02/18.
 */
public class Empty extends Cell {

    public Empty() {
        super(0);
    }

    @Override
    public boolean isCreditable() {
        return false;
    }
}
