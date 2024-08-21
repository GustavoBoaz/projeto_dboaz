package com.dboaz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainAppPayment {

    private static final Logger logger = LoggerFactory.getLogger(MainAppPayment.class);

    public static void main(String[] args) {
        SpringApplication.run(MainAppPayment.class, args);
        logger.debug("SERVER MS PAYMENT - RUNING");
    }
}
