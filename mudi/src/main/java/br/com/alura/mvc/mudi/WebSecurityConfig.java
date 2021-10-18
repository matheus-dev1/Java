package br.com.alura.mvc.mudi;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	// Importando DataSouce que é o objeto que contem todas as informações da minha conexao ao banco de dados.
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Este metodo permite configurar requisições web de forma segura, por padrão ele vai aceitar todas as requisições, mas podemores restringir isso.
		http
			.csrf().disable()
			// Permite eu restringir acesso a determinadas paginas. Obs: todas as configurações abaixo se referem a .authorizeRequests(), ou seja a permissões de acesso a determinada pagina ou não.
			.authorizeRequests()
				// Permitindo que todos os usuarios acessem estas duas rotas.
				.antMatchers("/home").permitAll()
				// Configurando que todas as outras rotas necessitam de loguin
				.anyRequest().authenticated()
				// O metodo .and() separa a configurações, ou seja, as proximas configurações não se tratam de autorização de requisições.
			.and()
				// Definindo qual tipo de autenticação eu quero para as paginas que precisam ser autenticadas. No caso é um modal que solicita usuario e senha.
				// .httpBasic();
			
				// Definindo o tipo de login por formulario.
				.formLogin(form -> form
					// Pagina do login - Todas os usuarios não autenticados podem acessar.
					.loginPage("/login")
					// Se o login da pagina der sucesso ele vai redirecinar para /home.
					.defaultSuccessUrl("/usuario/pedido", true)
					.permitAll()
				)
				// Dentro dos formulario de login, temos uma configuração, de logout.
				// E podemos definir uma url pra esta requisição de logout.
				.logout(logout -> {
					logout.logoutUrl("/logout")
					.logoutSuccessUrl("/home");
				})
				.csrf().disable();
	}
	
	@Override
	// Configuração de segurança referente a autenticação de login de usuario.
	protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder)  throws Exception {
		
		// Instanciando qual o nosso enconder ou seja, qual o nosso codificador, exisem varios no mercado.
		// Passamos a sua instancia no passwordEncoder(), para setar o tipo de configuração vai ser usada pra criptografar a senha do usuario.
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		
		// Objeto que represena o nome, senha e role que seria seu nivel de acesso, por exemplo esse usuario é um ADM.
		/*UserDetails user = User.builder()
								.username("carlos")
								// Encriptando a senha deste usuario.
								.password(bCryptPasswordEncoder.encode("carlos"))
								.roles("ADM")
								.build();*/
		
		// Configuração de banco de dados, por exemplo nos estamos pegando as informacoes do dataSource do banco de dados que configuramos, estamos definindo
		// que usaremos determinado tipo de criptografia de senha e que este usuaio vai ser armazenado.
		// Obs: Nos não precisamos fazer nenhum tipo de associação com o banco de dados porque nos seguimos com as tabelas e campos que o framework solicita.
		authenticationManagerBuilder.jdbcAuthentication()
									// DataSouce é o objeto que contem todas as informações da minha conexao ao banco de dados.
									.dataSource(dataSource)
									.passwordEncoder(bCryptPasswordEncoder);
									// Definindo que este usuario vai ser armazenado no banco de dados.
									//.withUser(user);
	}
	
	// @Bean - Um bean é um objeto que é instanciado, montado e gerenciado pelo Spring IoC container. ... Assim como pode usar o @Bean em um método, e
	// tornar a instância retornada pelo método como um objeto gerenciado pelo Spring (seja de uma classe própria ou de terceiros).
	/*@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("joao")
				.password("joao")
				.roles("ADM")
				.build();

		return new InMemoryUserDetailsManager(user);
	}*/
}
