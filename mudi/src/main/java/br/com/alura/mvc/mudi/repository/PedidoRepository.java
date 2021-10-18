package br.com.alura.mvc.mudi.repository;

//Dependencias utilitarias
import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//Dependencias de Negocios
import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;

// Diz para o Sprig que está classe é uma repository e que seja gerenciada por ela.
@Repository
// Classe do tipo Repository onde uma classe onde tem metodos de acessar/recuperar dados.
// A extensão desa classe é o JpaRepository onde temos ue definir qual a Classe/entidade e qual 
// o tipo do valor de primary key, no meu caso Long.
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	// Aqui eu estou cacheado os dados desta consulta, uma vez que o usuario vez uma consulta.
	@Cacheable("books")
	List<Pedido> findByStatusPedido(StatusPedido statusPedido, Pageable pageable);

	@Query("SELECT pedido FROM Pedido AS pedido join pedido.user AS usuario WHERE usuario.username = :username")
	//@Query("select p from Pedido p join p.user u where u.username = :username")
	List<Pedido> findAllByUsuario(@Param("username")String username);
	
	@Query("SELECT pedido FROM Pedido AS pedido join pedido.user AS usuario WHERE usuario.username = :username and pedido.statusPedido = :statusPedido")
	List<Pedido> findByStatusPedidoEUsuario(@Param("statusPedido") StatusPedido statusPedido, @Param("username") String username);
	
	// O Spring também ja sabe instancia um EntityManager
	// @PersistenceContext
	// private EntityManager entityManager;
	
	// A interface JpaRepository já implementa o findAll();
	// public List<Pedido> findAll();
	// {
		// Query query = entityManager.createQuery("SELECT p FROM Pedido p", Pedido.class);
		// return query.getResultList();
	// }

}
