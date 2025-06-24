package com.vincenzo.skeleton.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.Contact
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {
    
    @Bean
    fun openAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Vincenzo Skeleton API")
                    .description("Spring Boot 3.x + Kotlin + JPA Sample API")
                    .version("1.0.0")
                    .contact(
                        Contact()
                            .name("Vincenzo")
                            .email("vincenzo@example.com")
                    )
            )
    }
}