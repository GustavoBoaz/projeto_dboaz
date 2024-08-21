package com.dboaz;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class MainAppAuth {

    private static final Logger logger = LoggerFactory.getLogger(MainAppAuth.class);

    public static void main(String[] args) {
        SpringApplication.run(MainAppAuth.class, args);
        logger.debug("SERVER MS AUTH - RUNING");
    }
}
