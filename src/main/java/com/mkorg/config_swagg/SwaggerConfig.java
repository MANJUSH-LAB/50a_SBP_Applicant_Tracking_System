package com.mkorg.config_swagg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI atsOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("ATS API")
                        .description("Applicant Tracking System API documentation")
                        .version("1.0.0"));
    }
}
//Run the App and Access Swagger UI(Once your app is running, visit:)
//http://localhost:1111/swagger-ui.html
//(Or (for Springdoc 2.x):)
//http://localhost:1111/swagger-ui/index.html

//