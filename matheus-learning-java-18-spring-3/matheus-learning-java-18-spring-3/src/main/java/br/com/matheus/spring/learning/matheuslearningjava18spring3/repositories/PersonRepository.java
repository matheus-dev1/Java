package br.com.matheus.spring.learning.matheuslearningjava18spring3.repositories;

import br.com.matheus.spring.learning.matheuslearningjava18spring3.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// COMO JPAREPOSITORY É IMPLEMENTADA?
// O proprio java implementa as operacoes
// O Spring Data JPA, Spring Framework e os proxies dinamicos para implementar ela em tempo de execução
// Proxy Dinâmico: O Spring utiliza proxies para interceptar chamadas aos métodos definidos na interface e delegar
// essas chamadas para a lógica interna que interage com o banco de dados.
// Integração com EntityManager: O Spring Data JPA faz uso do EntityManager, fornecido por implementações do JPA,
// como Hibernate, EclipseLink ou OpenJPA.
// SimpleJpaRepository: Classe padrão que implementa as operações básicas do JpaRepository.

// O QUE É JPA REPOSITORY?
// JpaRepository é uma extensão específica de JPA (Java Persistence API) do Repository.
// Ele contém a API completa de CrudRepository e PagingAndSortingRepository.
// Então ele contém API para operações CRUD básicas e também API para paginação e classificação.
// Deve passar a classe da entidade e o tipo do objeto do Id, nos Generics <T>

// Repository eh apenas um alias de @Component, para dar significado para classes que acessam e manipulam dados em uma aplicação.
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> { }