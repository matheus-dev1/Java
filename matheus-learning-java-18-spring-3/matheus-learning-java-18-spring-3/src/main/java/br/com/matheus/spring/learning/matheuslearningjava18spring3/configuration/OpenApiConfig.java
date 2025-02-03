package br.com.matheus.spring.learning.matheuslearningjava18spring3.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    // http://localhost:8080/j18s3/v3/api-docs
    // http://localhost:8080/j18s3/swagger-ui/index.html
    @Bean
    public OpenAPI customOpenApi() {
        License licenseInfo = new License()
                .name("Apache 2.0")
                .url("https://www.apache.org/licenses/LICENSE-2.0");

        Info OpenApiInfos = new Info()
                .title("Learning Spring with some courses on Internet")
                .version("v1")
                .description("Some description about this project bla bla bla...")
                .termsOfService("https://www.apache.org/licenses/LICENSE-2.0")
                .license(licenseInfo);

        return new OpenAPI()
                .info(OpenApiInfos);
    }
}
