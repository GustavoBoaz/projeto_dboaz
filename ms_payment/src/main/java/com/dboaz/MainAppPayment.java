package com.dboaz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.dboaz.ms_payment.utils.constants.Route;
import com.dboaz.utils.models.GlobalInfo;

@SpringBootApplication
public class MainAppPayment {

    private static final Logger logger = LoggerFactory.getLogger(MainAppPayment.class);

    @Value("${microservice.ms_payment.name}") String name;
    @Value("${microservice.ms_payment.version}") String version;
    @Value("${microservice.ms_payment.description}") String description;

    public static void main(String[] args) {
        SpringApplication.run(MainAppPayment.class, args);
        logger.debug("SERVER MS PAYMENT - RUNING");
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
