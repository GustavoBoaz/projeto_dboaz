package com.dboaz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainAppCommentRating {

    private static final Logger logger = LoggerFactory.getLogger(MainAppCommentRating.class);

    public static void main(String[] args) {
        SpringApplication.run(MainAppCommentRating.class, args);
        logger.debug("SERVER MS COMMENT RATING - RUNING");
    }
}
