package com.dboaz;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dboaz.ms_auth.utils.constants.Route;

import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class MainAppAuth {

    private static final Logger LOG = LoggerFactory.getLogger(MainAppAuth.class);

    @Value("${microservice.ms_auth.routes.info.title}") String title;
    @Value("${microservice.ms_auth.routes.info.version}") String version;
    @Value("${microservice.ms_auth.routes.info.description}") String description;
    @Value("${microservice.ms_auth.routes.info.contact.email}") String email;

    public static void main(String[] args) {
        SpringApplication.run(MainAppAuth.class, args);
        LOG.debug("SERVER MS AUTH - RUNING");
    }

    @Bean
    public GroupedOpenApi infoMSAuth() {
        String[] paths = { Route.GET_INFO };

        var info = new Info().title(title).version(version).description(description).contact(new Contact().email(email));
        return GroupedOpenApi.builder()
            .group("Info").addOpenApiCustomizer(openApi -> openApi.info(info)).pathsToMatch(paths)
            .build();
    }
}
