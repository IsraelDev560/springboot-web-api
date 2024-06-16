package dio.web_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Sistema De Usuários - Rest API")
                        .description("API exemplo de uso de Spring Boot REST API")
                        .version("1.0")
                        .termsOfService("Termo de uso: Open Source")
                        .license(new License().name("iscode").url("http://iscode.vercel.app"))
                        .contact(new Contact()
                                .name("Israel")
                                .url("http://iscode.vercel.app")
                                .email("devisrael560@gmail.com")));
    }

    @Bean
    public GroupedOpenApi usersApi() {
        return GroupedOpenApi.builder()
                .group("users")
                .pathsToMatch("/users/**")
                .build();
    }
}
