package com.example.springcore.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Spring Core application")
                        .version("1.0")
                        .description("This is the API documentation for my Spring Boot application.")
                        .termsOfService("http://bekhruz")
                        .contact(new Contact()
                                .name("Bexruz Izzatullayev")
                                .email("bexruz@example.com")
                                .url("https://github.com/bexruz"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")));
    }
}
