package com.dboaz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainAppMessaging {

    private static final Logger logger = LoggerFactory.getLogger(MainAppMessaging.class);

    public static void main(String[] args) {
        SpringApplication.run(MainAppMessaging.class, args);
        logger.debug("SERVER MS MESSAGING - RUNING");
    }
}
