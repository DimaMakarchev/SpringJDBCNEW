package com.jdbcbrtij.testtwojdbc.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BankBro {
    private int id;

    private String name_many;

    public BankBro(String name_many) {
        this.name_many = name_many;
    }
}
