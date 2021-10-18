package br.com.alura.forum.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.forum.controller.form.AtualizacaoTopicoForm;
import br.com.alura.forum.controller.form.TopicoForm;
import br.com.alura.forum.dto.DetalhesDoTopicoDTO;
import br.com.alura.forum.dto.TopicoDTO;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;
import br.com.alura.forum.repository.TopicoRepository;

@RestController
@RequestMapping("/topicos")
public class TopicosController {
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;

	@GetMapping
	/*
		value = identificador unico deste cache

		Obs: Nos podemos verificar se esta funcionando habiliando o log da consultado hibernate e se vc fazer a requisicao
		e não mostrar a query, quer dizer que você esta buscando os dados do cache e não do banco de dados.

		Obs: Se você fazer uma consulta diferente, com um parametro a mais por exemplo neste mesmo endpoint ele vai fazer
		a consulta no banco de dados, porém ele vai guardar em cache os valores das duas consultas.
	*/
	@Cacheable(value = "listaDeTopicos")
	@ResponseBody
	// Obs: não é legal voltar entidades JPA como retorno de actions.
	public Page<TopicoDTO> lista(
			@RequestParam(required = false) String nomeCurso,
			// page = pagina, size = quantidade, sort = ordenacao (nome do atributo), asc ou desc
			@PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable paginacao) {

		// Pageable paginacao = PageRequest.of(pagina, quantidadePagina, Sort.Direction.ASC, ordenacao);

		// Topico topico = new Topico("Duvida", "Duvida com Spring", new Curso("Spring", "Programação"));

		if (nomeCurso == null) {
			Page<Topico> listaTopicos = topicoRepository.findAll(paginacao);
			return TopicoDTO.converter(listaTopicos);
		} else {
			Page<Topico> listaTopicosPorNomeCurso = topicoRepository.findByCursoNome(nomeCurso, paginacao);
			return TopicoDTO.converter(listaTopicosPorNomeCurso);
		}
	}
	
	@GetMapping("/nomeCurso")
	public Page<TopicoDTO> listaNomeCurso(
			@RequestParam(required = false) String nomeCurso,
			@RequestParam Integer pagina,
			@RequestParam Integer quantidadePagina) {

		Pageable paginacao = PageRequest.of(pagina, quantidadePagina);
		Page<Topico> listaTopicosPorNomeCurso = topicoRepository.findByCursoNome(nomeCurso, paginacao);
		return TopicoDTO.converter(listaTopicosPorNomeCurso);
	}
	
	@PostMapping
	@Transactional
	// Invalidar um determinado cache e se é para limpar todos os registros.
	@CacheEvict(value = "listaDeTopicos", allEntries = true)
	public ResponseEntity<TopicoDTO> cadastrar(@RequestBody @Valid TopicoForm topicoForm, UriComponentsBuilder uriComponentsBuilder) {
		Topico topico = topicoForm.toTopico(cursoRepository);
		topicoRepository.save(topico);
		/* Isso acontece porque toda vez que devolvo 201 para o cliente, além de devolver o código,
		 * tenho que devolver mais duas coisas: uma delas é um cabeçalho HTTP, chamado "Location",
		 * com a URL desse novo recurso que acabou de ser criado; a segunda coisa é que, no corpo
		 * da resposta, eu tenho que devolver uma representação desse recurso que acabei de criar.
		 */
		URI uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDTO(topico));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesDoTopicoDTO> detalhar(@PathVariable("id") Long id) {
		Optional<Topico> topico = topicoRepository.findById(id);
		if(topico.isPresent()) {
			return ResponseEntity.ok(new DetalhesDoTopicoDTO(topico.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	// @Transactional, que é para avisar para o Spring que é para commitar a transação no final do método
	@Transactional
	@CacheEvict(value = "listaDeTopicos", allEntries = true)
	public ResponseEntity<TopicoDTO> atualizar(@PathVariable("id") Long id, @RequestBody @Valid AtualizacaoTopicoForm topicoForm) {
		Optional<Topico> optional = topicoRepository.findById(id);
		if(optional.isPresent()) {
			Topico topico = topicoForm.atualiazar(id, topicoRepository);
			return ResponseEntity.ok(new TopicoDTO(topico));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	@CacheEvict(value = "listaDeTopicos", allEntries = true)
	// Generics, sem especificação de tipo.
	public ResponseEntity<?> remover(@PathVariable("id") Long id){
		Optional<Topico> optional = topicoRepository.findById(id);
		if(optional.isPresent()) {
			topicoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	};

}
