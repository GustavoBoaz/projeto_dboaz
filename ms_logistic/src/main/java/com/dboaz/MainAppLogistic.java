package com.dboaz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.dboaz.ms_logistic.utils.constants.Route;
import com.dboaz.utils.models.GlobalInfo;

@SpringBootApplication
public class MainAppLogistic {

    private static final Logger logger = LoggerFactory.getLogger(MainAppLogistic.class);

    @Value("${microservice.ms_logistic.name}") String name;
    @Value("${microservice.ms_logistic.version}") String version;
    @Value("${microservice.ms_logistic.description}") String description;

    public static void main(String[] args) {
        SpringApplication.run(MainAppLogistic.class, args);
        logger.debug("SERVER MS LOGISTIC - RUNING");
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
