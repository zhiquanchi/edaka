package com.example.edaka.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        // 基本信息设置
        return new OpenAPI()
                .info(new Info().title("Your API Title")
                        .version("1.0")
                        .description("Your API Description"))
                .addSecurityItem(new SecurityRequirement().addList("token"))
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("token", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT"))); // 如果你使用的是 JWT，可以设置为 "JWT"
    }
}