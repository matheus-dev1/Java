package br.com.alura.forum.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.forum.modelo.Topico;
import org.springframework.data.domain.Page;

public class TopicoDTO {
	private Long id;
	private String titulo;
	private String mensagem;
	private LocalDateTime dataCriacao;
	
	// Aqui nos vamos pegar os dados que no setamos da classe modelo, e vamo recuperar apenas os dados
	// que nos queremos.
	public TopicoDTO(Topico topico) {
		this.id = topico.getId();
		this.titulo = topico.getTitulo();
		this.mensagem = topico.getMensagem();
		this.dataCriacao = topico.getDataCriacao();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}

	public static Page<TopicoDTO> converter(Page<Topico> topicos) {
		// Converter um objeto do tipo Topico para TopicoDTO.
		// return topicos.stream().map(TopicoDTO::new).collect(Collectors.toList());

		// :: é um novo operador incluído no Java 8 que é usado para referenciar um método de uma classe existente.
		// Você pode consultar métodos estáticos e métodos não estáticos de uma classe.
		return topicos.map(TopicoDTO::new);
	}
}
