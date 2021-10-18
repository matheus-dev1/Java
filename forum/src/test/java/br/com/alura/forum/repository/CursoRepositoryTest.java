package br.com.alura.forum.repository;

import org.junit.Assert;
import org.junit.Test;
// import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.alura.forum.modelo.Curso;

/*
 * Para criar um caso de teste de uma classe/interface já existente
 * Botão direito na classe/interface -> New -> Other -> JUnit Test Case -> Finish
 * Obs: Ele já cria para nos, a pacote no pacote de Teste, adicionar o sufixo "Test"
 * */
@RunWith(SpringRunner.class)
// Anotação para criar uma classe de teste para uma repository
@DataJpaTest
/* Obs: Por padrão, ele considera que você vai fazer o teste com um banco de dados em memória.
 * 
 * Basicamente eu estou configurando para que ele NÃO subtitua o nosso banco de dados pelo H2.
 * 
 * Normalmente nos usamos dois bancos de dados da aplicação, o que para o desenvolvimento, o que
 * pode vir a ser o de produção e o de testes, sendo que este banco de teste sempre/normalmente
 * vai está em vazio ou em um estado em que não interfica nos meus teste automatizados.
 */
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
// Forçar determinado profile.
// Obs: Pelo nome do profile ser teste ele vai carregar o application-test.properties pelo fato do nome.
@ActiveProfiles("test")
public class CursoRepositoryTest {
	
	// Pelo fato da anotação @DataJpaTest, nos conseguimos injetar está dependencia.
	@Autowired
	private CursoRepository cursoRepository;
	
	// A ideia agora é inicializa o banco de dados apenas com o cenaro que eu estou testando.
	@Autowired
	private TestEntityManager testEntityManager;

	@Test
	// Os nomes do teste são explicitos e devem falar o que deve acontecer no teste, no caminho feliz no caso :)
	public void deveriaCarregarUmCursoAoBuscarPeloNome() {
		String nomeCurso = "HTML 5";
		
		Curso curso = new Curso();
		curso.setNome(nomeCurso);
		curso.setCategoria("Programacao");
		testEntityManager.persist(curso);
		
		Curso cursoRepositoryReult = cursoRepository.findByNome(nomeCurso);
		Assert.assertNotNull(cursoRepositoryReult);
		// Aqui eu estou verificando se o valor que eu definir localmente na minha variavel local,
		// é igual ao valor que veio do banco.
		Assert.assertEquals(nomeCurso, cursoRepositoryReult.getNome());
	}
	
	@Test
	public void naoDeveriaCarregarUmCursoCujoNomeNaoEstejaCadastrado() {
		String nomeCurso = "JPA";
		Curso cursoRepositoryReult = cursoRepository.findByNome(nomeCurso);
		Assert.assertNull(cursoRepositoryReult);
	}

}
