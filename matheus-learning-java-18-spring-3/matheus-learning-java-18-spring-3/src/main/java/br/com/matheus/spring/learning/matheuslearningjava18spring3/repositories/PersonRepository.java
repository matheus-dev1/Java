package br.com.matheus.spring.learning.matheuslearningjava18spring3.repositories;

import br.com.matheus.spring.learning.matheuslearningjava18spring3.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repository eh apenas um alias de @Component, para dar significado para classes que acessam e manipulam dados em uma aplicação.
//@Repository
// JpaRepository é uma extensão específica de JPA (Java Persistence API) do Repository.
// Ele contém a API completa de CrudRepository e PagingAndSortingRepository.
// Então ele contém API para operações CRUD básicas e também API para paginação e classificação.

// Deve passar a classe da entidade e o tipo do objeto do Id, nos generics

// O proprio java implementa as operacoes
public interface PersonRepository extends JpaRepository<Person, Long> {
    
}
