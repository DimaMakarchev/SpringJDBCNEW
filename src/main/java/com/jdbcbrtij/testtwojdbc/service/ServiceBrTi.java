package com.jdbcbrtij.testtwojdbc.service;


import com.jdbcbrtij.testtwojdbc.dao.BankBro;
import com.jdbcbrtij.testtwojdbc.repository.PayementBroI;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Log4j2
@Service
public class ServiceBrTi {

    @Value("${service.name}")
    private String NAME;

    @Autowired
    @Qualifier("paymentBroImpl")
    private PayementBroI payementBroI;

    public void methodService() {
        log.info("***********creat BD ***************");
        payementBroI.creatBD();
        log.info("***********creat DATA ***************");
        payementBroI.save(new BankBro("Bro1"));
        payementBroI.save(new BankBro("Bro2"));
        payementBroI.save(new BankBro("Bro3"));
        log.info("***********FINISH DATA ***************");
        log.info("***************FIND on ID**************");
        Optional<BankBro> byId = payementBroI.findById(1);
        System.out.println(byId);
        log.info("***************FIND All**************");
        payementBroI.findAll().forEach(data ->
                        payementBroI.save(new BankBro(NAME))
                //System.out.println(data)
        );
        log.info("***************Update on Id**************");
        int update = payementBroI.update(new BankBro(3, "Bro new!!!"));
        log.info("***************Update where id = " + update + "**************");
        log.info("***************Find on NAME**************");
        List<BankBro> byName = payementBroI.findByName("Bro2");
       // payementBroI.findByName("cool");
        byName.stream().filter(Objects::nonNull).forEach(System.out::println);

        /*log.info("***************GET Name**************");

        String nameById = String.valueOf(payementBroI.getNameById(3));
        log.info("***************GET"+nameById+"**************");*/

    }
}
