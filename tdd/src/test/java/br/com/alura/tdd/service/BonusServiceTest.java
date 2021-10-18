package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

public class BonusServiceTest {

	@Test
	// Salario do funconario tão alto a ponto de que o reajuste seja maior que 1000
	void BonusDoSalarioDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService bonusService = new BonusService();
		Funcionario funcionario = new Funcionario("Matheus", LocalDate.now(), new BigDecimal(25000));
		// O lambda faz a execução do metodo e verifica se em sua execução o metodo expeado é estourado.
		Assert.assertThrows(IllegalArgumentException.class, () -> bonusService.calcularBonus(funcionario));
		
		// Assert.assertEquals(new BigDecimal("0.00"), bonus);
		
		/*
		try {
			bonusService.calcularBonus(funcionario);
			Assert.fail("Não ocoreu uma exception na execução do metodo "calcularBonus()");
		} catch (Exception exception) {
			Assert.assertEquals("Funcionario com o salario maior que R$10.000 não pode receber bonus.", exception.getMessage());
		}
		*/
	}
	
	@Test
	// Salario do funcionario baixo afim de retornar o reajuste.
	void BonusDoSalarioDeveriaSerReajustadoEmDezPorCentoDoSalarioDoFuncionario() {
		BonusService bonusService = new BonusService();
		Funcionario funcionario = new Funcionario("Matheus", LocalDate.now(), new BigDecimal(5000));
		BigDecimal bonus = bonusService.calcularBonus(funcionario);
		
		Assert.assertEquals(new BigDecimal("500.00"), bonus);
	}
	
	@Test
	// Salario do funcionario baixo afim de retornar o reajuste.
	void BonusDoSalarioDeveriaSerReajustadoEmDezPorCentoDoSalarioDoFuncionariocCasoBonusIgualA1000() {
		BonusService bonusService = new BonusService();
		Funcionario funcionario = new Funcionario("Matheus", LocalDate.now(), new BigDecimal(10000));
		BigDecimal bonus = bonusService.calcularBonus(funcionario);
		
		Assert.assertEquals(new BigDecimal("1000.00"), bonus);
	}
	
}
