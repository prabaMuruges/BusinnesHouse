package com.company;

import java.util.Arrays;

public enum CellType {
    EMPTY("E"), JAIL("J"), TREASURE("T"), HOTEL("H");

    private String value;

    CellType(String value) {
        this.value = value;
    }

    public static CellType findByAbbreviation(final String abbreviation){
        return Arrays.stream(values())
                .filter(value -> value.value.equals(abbreviation))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Cell Types should be among { E (Empty), J (Jail)," +
                        " T (Treasure), H (Hotel)}"));
    }
}
