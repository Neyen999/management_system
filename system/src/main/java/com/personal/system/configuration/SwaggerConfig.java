package com.personal.system.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI pocketApi() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes("name",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                        ))
                .security(List.of(new SecurityRequirement().addList("name")))
                .info(new Info().title("Student Management System")
                        .description("Basic API to create users")
                        .version("1")
                        .license(new License().name("Apache 2.0").url("nmarinellidev@gmail.com")));

//                .externalDocs(new ExternalDocumentation().description("").url("https://bitbucket.org/AIASAP/pocket-backend-app"));
    }
}
