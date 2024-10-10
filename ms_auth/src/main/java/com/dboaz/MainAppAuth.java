package com.dboaz;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.dboaz.ms_auth.core.utils.constants.Route;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

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
            .group("1 - Info")
            .addOpenApiCustomizer(openApi -> openApi.info(info))
            .pathsToMatch(paths)
            .build();
    }

    @Bean
    public GroupedOpenApi account() {
        String[] paths = { "/ms_auth/account/**" };
        var info = new Info()
            .title("MS Auth")
            .version("1.0.0")
            .description("This microservice is fundamental for manipulation account and credentials.")
            .contact(new Contact().email(email));

        return GroupedOpenApi.builder()
            .group("2 - Account")
            .addOpenApiCustomizer(openApi -> openApi.info(info))
            .pathsToMatch(paths)
            .build();
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .components(new Components()
            .addSecuritySchemes("bearer-key",
            new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")));
    }
}
