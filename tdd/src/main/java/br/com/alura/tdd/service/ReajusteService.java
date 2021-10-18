package br.com.alura.tdd.service;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {

	public void reajustar(Funcionario funcionario) {
		funcionario.setReajusteSalario(funcionario.getSalario().multiply(funcionario.getDesempenho().percentualReajuste()));
		
		/*
		 * switch (funcionario.getDesempenho()) {
		case A_DESEJAR: 
			funcionario.setReajusteSalario(funcionario.getSalario().multiply(new BigDecimal("0.03")));
			break;
		case BOM: 
			funcionario.setReajusteSalario(funcionario.getSalario().multiply(new BigDecimal("0.15")));
			break;
		case OTIMO: 
			funcionario.setReajusteSalario(funcionario.getSalario().multiply(new BigDecimal("0.20")));
			break;
		default:
			break;
		}
		*/
	}
	
}
