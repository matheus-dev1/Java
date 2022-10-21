package br.com.algaworks.consumer.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProdutoComPreco {
	// Este é o "Model" dos valores que eu quero que retorne quando eu fazer a requisição para esta API.
	private Long codigo;
	private String nome;
	private BigDecimal preco;
	
}
