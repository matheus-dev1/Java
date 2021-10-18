package br.com.alura.forum.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.alura.forum.modelo.Curso;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.CursoRepository;

public class TopicoForm {
	@NotNull @NotEmpty(message = "Não pode ser vazio") @Length(min = 5)
	private String titulo;
	@NotNull @NotEmpty @Length(min = 10)
	private String mensagem;
	@NotNull @NotEmpty
	private String nomeCurso;
	
	public TopicoForm() {
		super();
	}
	
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
	public String getNomeCurso() {
		return nomeCurso;
	}
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	
	public Topico toTopico(CursoRepository cursoRepository) {
		Curso curso = cursoRepository.findByNome(nomeCurso);	
		Topico topico = new Topico();
		topico.setTitulo(getTitulo());
		topico.setCurso(curso);
		topico.setMensagem(getNomeCurso());
		return topico;
	}
}
