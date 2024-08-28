package com.dboaz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dboaz.ms_logistic.utils.constants.Route;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@SpringBootApplication
public class MainAppLogistic {

    private static final Logger LOG = LoggerFactory.getLogger(MainAppLogistic.class);

    @Value("${microservice.ms_logistic.routes.info.title}") String title;
    @Value("${microservice.ms_logistic.routes.info.version}") String version;
    @Value("${microservice.ms_logistic.routes.info.description}") String description;
    @Value("${microservice.ms_logistic.routes.info.contact.email}") String email;

    public static void main(String[] args) {
        SpringApplication.run(MainAppLogistic.class, args);
        LOG.debug("SERVER MS LOGISTIC - RUNING");
    }
    
    @Bean
    public GroupedOpenApi infoMSLogistic() {
        String[] paths = { Route.GET_INFO };

        var info = new Info().title(title).version(version).description(description).contact(new Contact().email(email));
        return GroupedOpenApi.builder()
            .group("Info").addOpenApiCustomizer(openApi -> openApi.info(info)).pathsToMatch(paths)
            .build();
    }
}
