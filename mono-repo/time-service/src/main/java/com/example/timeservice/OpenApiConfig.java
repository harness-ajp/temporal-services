package com.example.timeservice;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI timeServiceOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Time Service API")
                .description("A RESTful service that returns the current time")
                .version("1.0.0"));
    }
}
