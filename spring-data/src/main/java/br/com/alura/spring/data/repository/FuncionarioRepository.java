package br.com.alura.spring.data.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.spring.data.orm.Funcionario;
import br.com.alura.spring.data.orm.FuncionarioProjecao;

// Interface Repository eh a pai de todos os repositories
// CrudReposity, usada para realizar crud
// PagingAndSortingRepository usada para fazer paginacao de consultas
// As Repositories do tipo Reactive e Rx sao usadas para trabalhar com programacao funcional
// JPARepository muito bom para arquivo em lote ou seja, todos os arquivo de alguma coisa, por exemplo
// deletar todos os funcionarios, Salvar todas as entradas e etc

@Repository
// Paginacao - Apresentar pequenos blocos de informacao de um todo muito grande - Para ganhar mais performace
// para fazer paginacao no SpringData em vez de extender CrudRepository usaremos o PagingAndSortingRepository

// A feature que o Spring Data utiliza para fazer Querys dinâmicas se chama Specification. Dentro da
// Specification ela já abstrai todos aqueles códigos que vimos lá no modelo do JPA.
// Ter um objeto com todos os itens necessários para realizar uma consulta dinâmica, como por
// exemplo root, criteriaQuery e criteriaBuilder.
// As querys dinamicas sao query que voce pode por exemplo passar apenas um ou outro campo e receber o que
// voce deseja.
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer>, JpaSpecificationExecutor<Funcionario> {
	// Derived Query - Atraves de um metodo em Java, o proprio SpringData consegue criar um Query pro seu
	// banco de dados especifico sem voce ter que criar nenhum comando SQL.
	
	// O Derived Query identifica o nome do seu metodo, confome o padrao colocado no Spring Data.
	// Um exemplo de consulta eh o findBy
	
	// Por padrao eh Derived Query
	List<Funcionario> findByNome(String nome);
	
	// List<Funcionario> findByNameAndSalarioGreaterThanAndDataContratacao(String nome, Double Salario, LocalDate data);
	
	// Defino que quero criar um query para este metodo e nao uma Derived Query
	@Query("SELECT funcionario FROM Funcionario AS funcionario WHERE funcionario.nome = :nome AND funcionario.salario >= :salario AND funcionario.dataContratacao = :data")
	List<Funcionario> findNomeSalarioMaiorQueDataContratacao(String nome, Double salario, LocalDate data);
	
	// Native Querys - Querys do proprio banco de dados, na linguagem do BD.
	@Query(value = "SELECT * FROM funcionarios AS funcionariosAlias WHERE funcionariosAlias.data_contratacao >= :data", nativeQuery = true)
	List<Funcionario> findDataContratacaoMaior(LocalDate data);
	
	@Query(value = "SELECT funcionario.id, funcionario.nome, funcionario.salario FROM funcionarios AS funcionario", nativeQuery = true)
	List<FuncionarioProjecao> findFuncionarioSalario();
}
