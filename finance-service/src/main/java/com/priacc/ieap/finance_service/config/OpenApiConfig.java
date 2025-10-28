package com.priacc.ieap.finance_service.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Finance Service API",
                version = "1.0",
                description = "API documentation for managing invoices and financial operations."
        ),
        servers = {
                @Server(url = "http://localhost:8081", description = "Local Development Server")
        }
)
@Configuration
public class OpenApiConfig {
}