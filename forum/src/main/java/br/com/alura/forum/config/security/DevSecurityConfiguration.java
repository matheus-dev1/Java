package br.com.alura.forum.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
/*
 * Dependendo de qual ambiente você está rodando o seu software, podem ter configurações que sejam
 * distintas, que tenham que sofrer alterações; e podem ter funcionalidades também que você 
 * queira habilitar ou desabilitar.
 * Profiles - Com profiles podemos ter configurações distintas para cada tipo de ambiente, como
 * desenvolvimento, testes e produção.
 * 
 * Como alterar o ambiente em que você quer rodar a aplicacação
 * Botão direito no projeto -> Run As -> Run Configurations -> Java Aplicaton ->
 * Verificar se a classe a baixo é a sua MAIN -> Arguments -> VM Arguments ->
 * -Dspring.profiles.active=dev(Aqui nos vamos definir qual ambiente é o vamos estar rodando a aplicação)
 * Obs: Se você não declarar nenhum profile ele vai usar o profile default, ou seja, vai carregar todas as classes.
 */
@Profile("dev")
public class DevSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                // Aqui eu estou permitino qualquer endpoint com qualquer verbo http.
                .antMatchers("/**").permitAll()
                .and().csrf().disable();
    }

}
