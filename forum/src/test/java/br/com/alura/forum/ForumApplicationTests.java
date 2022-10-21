package br.com.alura.forum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// JUnit tem duas API de testes, normalmente usamos o org.junit.Test
// import org.junit.jupiter.api.Test;

/*
 * Tem a anotação @RunWith, que vem passando como parâmetro esse SpringRunner.class, que é uma classe
 * do pacote “org.springframework.test”, do módulo de teste do Spring.
 * E vem uma anotação @SpringBootTest. Então isso é o Spring Boot. Abaixo disso é Java e JUnit.
 * 
 * A anotação @SpringBootTest serve para que o Spring inicialize o servidor e carregue os beans da
 * aplicação durante a execução dos testes automatizados.
 * */
@RunWith(SpringRunner.class)
@SpringBootTest
class ForumApplicationTests {

	@Test
	void contextLoads() {
		Assert.assertTrue(true);
	}

}
