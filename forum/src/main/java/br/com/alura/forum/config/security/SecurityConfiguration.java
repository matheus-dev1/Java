package br.com.alura.forum.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.alura.forum.repository.UsuarioRepository;

// Habilitando modulo de segurança na aplicação.
@EnableWebSecurity
// Na inicialização projeto, o Spring vai ler as configurações dentro desta classe.
@Configuration
@Profile(value = {"prod", "test"})
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private AutenticacaoService autenticacaoService;
    
    @Autowired
    private TokenService tokenService;
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    // Configurações de autorização(permissão concedida a um indivíduo para que faça algo ).
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/topicos").permitAll()
                // Aqui eu pego tanto por id como pelo /nomeCurso.
                .antMatchers(HttpMethod.GET, "/topicos/*").permitAll()
                .antMatchers(HttpMethod.POST, "/auth").permitAll()
                /*
                   Monitoramento de API - Fazer o monitomanto, ou seja, observer os comportamentos de
                   uma API de modo repetitivo, afim de identificar seu status, tanto de aividades,
                   fluxo de usuarios, quedas, quantidade de memoria usada e etcs.
				   
				   Spring Boot Actuator - É uma API que tem endpoints que devolvem um JSON com
				   informações sobre a API. É uma facilidade para conseguir monitorar e
				   acompanhar o andamento da nossa API.

					Spring Boot Admin - Ferramentas para exibir informações de monitormanto da
					sua aplicação com interface grafica.
                 */
                .antMatchers(HttpMethod.GET, "/actuator/**").permitAll()
                // Permite o executar o metodo delete deste endpoint se tiver o perfil(role) moderador.
                .antMatchers(HttpMethod.DELETE, "/topicos/*").hasRole("MODERADOR")
                .anyRequest().authenticated()
                .and().csrf().disable()
                // Não é para criar sessão, é para usar token.
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(new AutenticacaoViaTokenFilter(tokenService, usuarioRepository), UsernamePasswordAuthenticationFilter.class);
                // .and().formLogin(); - Este formLogin, cria uma sessão ao se logar, o que não é stateless
    }

    // Metodo responsavel pelas configurações de autenticação(é o ato de confirmar que algo ou alguém é autêntico)
    // Exemplo: está pagna só pode ser acessada por perfis administradores.
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Qual a service que tem a logica de autenticação.
        auth.userDetailsService(autenticacaoService).passwordEncoder(new BCryptPasswordEncoder());
    }

    // Configurações para arquivos estaticos.
    @Override
    public void configure(WebSecurity web) throws Exception {
        // Ignorando, todos os estaticos da paginas dentro deste antMatchers.
        web.ignoring().antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**");
    }

}
