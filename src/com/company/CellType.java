package com.company;

import java.util.Arrays;

public enum CellType {
    EMPTY("E"), JAIL("J"), TREASURE("T"), HOTEL("H");

    private String value;

    CellType(String value) {
        this.value = value;
    }

    public static CellType findByAbbr(final String abbr){
        return Arrays.stream(values()).filter(value -> value.value.equals(abbr)).findFirst().orElse(null);
    }
}
