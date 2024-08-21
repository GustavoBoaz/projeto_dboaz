package com.dboaz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainAppProduct {

    private static final Logger logger = LoggerFactory.getLogger(MainAppProduct.class);

    public static void main(String[] args) {
        SpringApplication.run(MainAppProduct.class, args);
        logger.debug("SERVER MS PRODUCT - RUNING");
    }
}
