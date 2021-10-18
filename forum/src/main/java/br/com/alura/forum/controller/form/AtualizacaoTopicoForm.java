package br.com.alura.forum.controller.form;

import java.net.URI;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.alura.forum.dto.TopicoDTO;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.TopicoRepository;

public class AtualizacaoTopicoForm {
	
	@NotNull @NotEmpty(message = "Não pode ser vazio") @Length(min = 5)
	private String titulo;
	
	@NotNull @NotEmpty @Length(min = 10)
	private String mensagem;

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public Topico atualiazar(Long id, TopicoRepository topicoRepository) {
		Topico topico = topicoRepository.getById(id);
		// Como o retorno do objeto "topicoId", está sendo gerenciado pelo Spring, se eu setar novas 
		// informações ele já detecta e eu não preciso usar mais nenhum metodo pra commitar esta
		// atualização, no final da execução do metodo ele já commita!
		topico.setTitulo(this.titulo);
		topico.setMensagem(this.mensagem);
		return topico;
	}
}
