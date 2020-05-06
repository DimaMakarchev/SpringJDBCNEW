package com.jdbcbrtij.testtwojdbc.repository;

import com.jdbcbrtij.testtwojdbc.dao.BankBro;
import com.sun.org.apache.xpath.internal.operations.String;


import java.util.List;
import java.util.Optional;

public interface PayementBroI {
    void creatBD();

    void save (BankBro bankBro);

    int update(BankBro bankBro);

    int remove(BankBro bankBro);

    List<BankBro> findAll();

    Optional<BankBro> findById(int id);


    String getNameById(int id);


    List<BankBro> findByName(java.lang.String name);

}
