package br.com.alura.forum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
 * Por padrão ao buildar uma aplicação do spring boot, ele vem no formato .jar, porém, 
 * nos podemos mudar para vir no forma, .war
 * Adicionar o <packaging>war</packaging> no pom.xml
 * Adicionar a dependencia. Essa lib já existe no projeto, a unica coisa que muda é a tag scope com o valor provider que nos falamos que quem vai providenciar o servidor é o propio tomcat.
 * <dependency>
 * 		<groupId>org.springframework.boot</groupId>
 * 		<artifactId>spring-boot-starter-tomcat</artifactId>
 * 		<scope>provided</scope>
 * </dependency>
 * Adicionar extends SpringBootServletInitializer na classe main, para deixar ser possível configurar
 * a Servlet 3.0 dentro do servidor, do Tomcat, no caso. Temos também que sobreescrever um metodo	
 * @Override
 * protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
 * 		return builder.sources(ForumApplication.class);
 * }
 * Este metodo tem um parametro builder que tem um metodo sources que pede a nossa
 * classe main como argumento.
 * 
 * Obs: Para o desenvolvedor não muda nada, apenas muda a extensão que você vai receber ao fazer o build
 * 
 * Como forma de segurança nos passamos os valores dos properties nas variaveis
 * de ambiente no ambiente de produção / servidor de produção.
 * Elas são declaradas assim: ${FORUM_DATABASE_URL}
 * Nos podemos exporta-las via export "NOME_DA_VARIAVEL"="valor_da_variavel" ou
 * passando como VM Arguments no prompt de comando.
 * 
 * java -jar -Dspring.profiles.active=prod -DFORUM_DATABASE_URL=jdbc:h2:mem:alura-forum -DFORUM_DATABASE_USERNAME=sa -DFORUM_DATABASE_PASSWORD= -DFORUM_JWT_SECRET=123456 forum.jar
 * 
 * export FORUM_DATABASE_URL=jdbc:h2:mem:alura-forum export FORUM_DATABASE_USERNAME=sa export FORUM_DATABASE_PASSWORD= export FORUM_JWT_SECRET=123456
 * java -jar -Dspring.profiles.active=prod forum.jar
 * 
 * A ideia é que se eu utilizar o cache, consigo dizer para o Spring guardar o retorno de um método em cache.
 * Na primeira vez que eu chamar aquele método, ele vai executar linha por linha do método, vai devolver o resultado,
 * mas nas próximas chamadas ele já devolve direto o que está em memória.
 * 
 * Provedor de Chave / Cache distribuido (Chave Provider).
 * O cache distribuído permite que diversos servidores busquem informação nele e não diretamente na fonte de dados do web site,
 * conseguindo assim uma reutilização maior das informações e consequentemente um desempenho melhor. Existem diversos frameworks
 * de cache distribuído, e este artigo cobrirá um deles, o MyCache.
 * 
 * Exemplos: Generic, JCache (JSR-107) (EhCache 3, Hazelcast, Infinispan, and others), EhCache 2. x, Hazelcast,
 * Infinispan, Couchbase, Redis, Caffeine.
*/

// Habiliar a dependencia Spring Fox na aplicação.
@EnableSwagger2
// Habilitar o uso de cachng na aplicação, sendo monitorado pelo Spring
@EnableCaching
// Habilita o Spring a da suporte para pegar os valores dos campos de paginacao e repassar para o spring data.
@EnableSpringDataWebSupport
@SpringBootApplication
public class ForumApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForumApplication.class, args);
	}

}
