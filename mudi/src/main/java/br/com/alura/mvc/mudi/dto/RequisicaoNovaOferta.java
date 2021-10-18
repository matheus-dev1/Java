package br.com.alura.mvc.mudi.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.alura.mvc.mudi.model.Oferta;

public class RequisicaoNovaOferta {
	
	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	// Não pode ser nulo/null
	@NotNull
	private Long pedidoId;
	// Patern é um design e regex é um expressão regular, ou seja, como eu desejo receber este valor.
	// Obs: A action que vai receber este objeto, no caso a OfertasRest como parametro e possui estes
	// patterns precisa colocar a anotação @valid
	@Pattern(regexp = "^\\d+(\\.\\d+{2})?$", message = "não deve ser nulo")
	@NotNull
	private String valor;
	@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "não deve ser nulo")
	@NotNull
	private String dataDaEntrega;
	private String comentario;
	
	public Long getPedidoId() {
		return pedidoId;
	}
	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}
	
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	
	public String getDataDaEntrega() {
		return dataDaEntrega;
	}
	public void setDataDaEntrega(String dataDaEntrega) {
		this.dataDaEntrega = dataDaEntrega;
	}
	
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Oferta toOferta() {
		Oferta oferta = new Oferta();
		oferta.setComentario(comentario);
		oferta.setDataDaEntrega(LocalDate.parse(this.dataDaEntrega, dateTimeFormatter));
		oferta.setValor(new BigDecimal(this.valor));
		return oferta;
	}
}
