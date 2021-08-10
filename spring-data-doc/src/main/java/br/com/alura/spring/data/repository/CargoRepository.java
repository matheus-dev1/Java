package br.com.alura.spring.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.spring.data.orm.Cargo;

// Nesta interface nos implementamos transacoes basicas de bancos de dados.
// Exemplo: saveAll(Iterable<S> entities); | Salva no banco de dados.
// findById(ID id); | Select pelo Id.

// Primeiro parametro do CrudRepository eh qual entidade/tabela em banco de dados voce quer manipualar.
// Qual eh o tipo do ID, no meu caso Integer.

// Anotacao Spring que sera lida pela anotacao @SpringBootApplication.
@Repository
public interface CargoRepository extends CrudRepository<Cargo, Integer> {
	// Interface do marcador do repositório central. Captura o tipo de domínio para gerenciar, bem como
	// o tipo de id do tipo de domínio. O propósito geral é manter informações de tipo, bem como ser capaz
	// de descobrir interfaces que estendem esta durante a varredura de classpath para fácil criação de
	// bean Spring.
	
	// Repositórios de domínio que estendem esta interface podem expor seletivamente métodos CRUD
	// simplesmente declarando métodos da mesma assinatura que aqueles declarados em CrudRepository.
}
