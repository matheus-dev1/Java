package br.com.alura.forum.config.validacao;

public class ErroDeFormularioDto {
	private String campoErro;
	private String mensagemErro;
	
	public ErroDeFormularioDto(String campoErro, String mensagemErro) {
		super();
		this.campoErro = campoErro;
		this.mensagemErro = mensagemErro;
	}
	
	public String getCampoErro() {
		return campoErro;
	}
	public void setCampoErro(String campoErro) {
		this.campoErro = campoErro;
	}
	
	public String getMensagemErro() {
		return mensagemErro;
	}
	public void setMensagemErro(String mensagemErro) {
		this.mensagemErro = mensagemErro;
	}
	
	
}
