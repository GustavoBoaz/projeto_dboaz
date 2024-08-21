package com.dboaz;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class MainAppAuction {

    private static final Logger logger = LoggerFactory.getLogger(MainAppAuction.class);

    public static void main(String[] args) {
        SpringApplication.run(MainAppAuction.class, args);
        logger.debug("SERVER MS AUCTION - RUNING");
    }
}
