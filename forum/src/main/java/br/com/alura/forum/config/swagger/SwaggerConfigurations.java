package br.com.alura.forum.config.swagger;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.alura.forum.modelo.Usuario;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfigurations {
	/*
	 * Dcumentação de API - Existem ferramentas que documentam sua API de forma automatizada,
	 * ou seja, com base no seu codigo fonte, é criado um web-site docmentando tudo o que tem
	 * na sua api, para quem for consumir saber como consumir.
	 * 
	 * O Swagger, que é a ferramenta para fazer a documentação, e o Spring fox Swagger, que
	 * é a biblioteca para documentar uma API Java com Spring, utilizando o Swagger.
	 */
	@Bean
    public Docket api() {
		// Retornando um objeto Docket, definindo qual o tipo da documentação, no caso Swagger 2.
        return new Docket(DocumentationType.SWAGGER_2)
        		.select()
        		// Base package, a partir de qual pacote ele vai começar a ler as classes do projeto.
                .apis(RequestHandlerSelectors.basePackage("br.com.alura.forum"))
                // Quais endereços é para ser analisados.
                .paths(PathSelectors.ant("/**"))
                .build()
                // Ignorar todos os parametros da classe Usuario, porque são dados sensiveis.
                .ignoredParameterTypes(Usuario.class)
                // Parametro Globais, ou seja, é um parametro que eu quero que seja apresentado em todos
                // os endpoints mapeados.
                .globalOperationParameters(
                		// Lista com os parametros.
                        Arrays.asList(
                        		// Builder, construindo como vai ser este parametro.
                                new ParameterBuilder()
                                	// Nome do parametro.
                                    .name("Authorization")
                                    // Descrição do parametro.
                                    .description("Header para Token JWT")
                                    // Tipo do valor do parametro, no caso String.
                                    .modelRef(new ModelRef("string"))
                                    // Tipo do parametro, no caso, um header.
                                    .parameterType("header")
                                    // Se é obrigatório ou não, no caso não.
                                    .required(false)
                                    // Mandei buildar/construir o objeto.
                                    .build()));
    }
}
