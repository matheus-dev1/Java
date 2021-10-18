package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.tdd.modelo.Funcionario;

// Classe service é a classe que armazena a logica de determinada execução.
public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		
		if (valor.compareTo(new BigDecimal("1000")) > 0) {
			// valor = BigDecimal.ZERO;
			throw new IllegalArgumentException("Funcionario com o salario maior que R$10.000 não pode receber bonus.");
		}
		
		// Duas casas decimais arredondando pra cima!
		return valor.setScale(2, RoundingMode.HALF_UP);
	}

}
