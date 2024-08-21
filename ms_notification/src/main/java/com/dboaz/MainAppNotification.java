package com.dboaz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainAppNotification {

    private static final Logger logger = LoggerFactory.getLogger(MainAppNotification.class);

    public static void main(String[] args) {
        SpringApplication.run(MainAppNotification.class, args);
        logger.debug("SERVER MS NOTIFICATION - RUNING");
    }
}
