package com.jdbcbrtij.testtwojdbc.repository;

import com.jdbcbrtij.testtwojdbc.dao.BankBro;
import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("paymentBroImpl")
public class PaymentBroImpl implements PayementBroI {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void creatBD() {
        jdbcTemplate.execute("DROP TABLE IF EXISTS bankbro");

        jdbcTemplate.execute("CREATE TABLE Bankbro(" +
                "id INT(10) NOT NULL AUTO_INCREMENT," +
                "name_many VARCHAR(30)," +
                "PRIMARY KEY (id))");

    }

    @Override
    public void save(BankBro bankBro) {
        jdbcTemplate.update("insert into bankbro(name_many) values(?)",
                bankBro.getName_many());
    }

    @Override
    public int update(BankBro bankBro) {
        return jdbcTemplate.update("" +
                        "UPDATE bankbro SET name_many = ? WHERE id = ?",
                bankBro.getName_many(), bankBro.getId());
    }

    @Override
    public int remove(BankBro bankBro) {
        return jdbcTemplate.update("" +
                        "DELETE bankbro where id = ? ",
                bankBro.getId());
    }

    @Override
    public List<BankBro> findAll() {
        return jdbcTemplate.query(
                "SELECT * FROM bankbro",
                (rs, rowNum) -> new BankBro(
                        rs.getInt("id"),
                        rs.getString("name_many")
                ));
    }

    @Override
    public Optional<BankBro> findById(int id) {
        return jdbcTemplate.queryForObject(
                "SELECT * FROM BANKBRO WHERE id =  ? ",
                new Object[]{id},
                (rs, rowNum) -> Optional.of(new BankBro(
                        rs.getInt("id"),
                        rs.getString("name_many")
                )));
    }



    @Override
    public String getNameById(int id) {
        return null;
    }

    @Override
    public List<BankBro> findByName(java.lang.String name) {
        return  jdbcTemplate.query("SELECT * FROM bankbro where name_many = ?",
                new Object[]{name},(rs, rowNum) -> new BankBro(
                        rs.getInt("id"),
                        rs.getString("name_many")
                ));
    }



}
