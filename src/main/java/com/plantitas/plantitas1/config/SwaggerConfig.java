package com.plantitas.plantitas1.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI plantitasOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Plantitas API")
                        .description("API REST para la gestión de plantas, especies, tareas de cuidado, usuarios y actividades recientes de la aplicación Plantitas.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Equipo Plantitas")
                                .email("soporte@plantitas.com"))
                        .license(new License()
                                .name("MIT License")
                                .url("https://opensource.org/licenses/MIT")));
    }
}
