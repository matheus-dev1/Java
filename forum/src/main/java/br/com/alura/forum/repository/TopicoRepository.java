package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.alura.forum.modelo.Topico;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
	public List<Topico> findAll();
	
	// Eu vou pesquisar pelo nome do atributo curso dentro da classe Topico.
	
	// Obs: Ele vai me dar os mesmo valores de uma classe do tipo Topico, porém o seu argumento de 
	// comparação para busca é o nome do atributo nome da classe Curso que faz 
	// relacionamento com a class Topico.
	
	// Dica: Se por exemplo nos tivessims um atributo com o nome nomeCurso, e nos usassemos
	// esta assinatura desta forma daria confluto, para arrumar isso nos podemos usar o _ entre
	// Curso e Nome. Exemplo public List<Topico> findByCurso_Nome(String nomeCurso);
	// Ai o Spring entende que é uma classe relacionamento(Curso) e um atributo da classe relacionada.
	public Page<Topico> findByCursoNome(String nomeCurso, Pageable paginacao);
}
