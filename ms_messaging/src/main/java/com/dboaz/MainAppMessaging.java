package com.dboaz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.dboaz.ms_messaging.utils.constants.Route;
import com.dboaz.utils.models.GlobalInfo;

@SpringBootApplication
public class MainAppMessaging {

    private static final Logger logger = LoggerFactory.getLogger(MainAppMessaging.class);

    @Value("${microservice.ms_messaging.name}") String name;
    @Value("${microservice.ms_messaging.version}") String version;
    @Value("${microservice.ms_messaging.description}") String description;

    public static void main(String[] args) {
        SpringApplication.run(MainAppMessaging.class, args);
        logger.debug("SERVER MS MESSAGING - RUNING");
    }

    @Controller
    public class InfoController {

        @GetMapping(path = Route.GET_INFO)
        public ResponseEntity<GlobalInfo> getInfo() {
            var result = GlobalInfo.builder()
                .name(name)
                .version(version)
                .description(description)
                .build();

            logger.debug(result.toString());
            return ResponseEntity.ok(result);
        }
    }
}
