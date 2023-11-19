package mcsv.transaccional.libreromcsone.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "API para el servicio de Librero", version = "1.0",
    description = "API que expone los endpoints para las entidades de Libro, Autor y Categoria (Servicio de Libros)"))
public class SwaggerConfig {
}
