package com.dboaz;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class MainAppGateway {

    private static final Logger logger = LoggerFactory.getLogger(MainAppGateway.class);

    public static void main(String[] args) {
        SpringApplication.run(MainAppGateway.class, args);
        logger.debug("SERVER BFF GATEWAY - RUNING");
    }
}
