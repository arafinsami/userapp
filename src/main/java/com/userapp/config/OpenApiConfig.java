package com.userapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public io.swagger.v3.oas.models.OpenAPI userAppOpenAPI() {
        return new io.swagger.v3.oas.models.OpenAPI()
                .info(new io.swagger.v3.oas.models.info.Info()
                        .title("User App API")
                        .description("User management service")
                        .version("v1.0.0"));
    }
}
