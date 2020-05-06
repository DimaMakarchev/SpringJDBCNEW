package com.jdbcbrtij.testtwojdbc;

import com.jdbcbrtij.testtwojdbc.service.ServiceBrTi;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log4j2
@SpringBootApplication
public class TesttwojdbcApplication implements CommandLineRunner {

    @Autowired
    private ServiceBrTi serviceBrTi;

    public static void main(String[] args) {
        SpringApplication.run(TesttwojdbcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        serviceBrTi.methodService();
    }
}
