package com.priacc.ieap.employee_service.config;



import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Employee Service API")
                        .description("API documentation for Employee Microservice in Priacc IEAP Project")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Priacc Team")
                                .email("support@priacc.ai")
                                .url("https://priacc.ai"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")));
    }
}
