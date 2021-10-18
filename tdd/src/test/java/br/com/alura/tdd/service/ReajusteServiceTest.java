package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {
	
	// Defino as nossa classes como atributos
	private ReajusteService reajusteService;
	private Funcionario funcionario;
	
	@BeforeEach // Serve para o Junit execute este metodo antes de cada @Test
	// @AfterEach // Serve para o Junit execute este metodo de cada @Test
	// @BeforeAll // Serve para o Junit execute este metodo uma vez antes de todos os metodos. Obs: O metodo tem que ser static.
	// @AfterAll // Serve para o Junit execute este metodo uma vez depois de todos os metodos. Obs: O metodo tem que ser static.
	// E inicializo elas atraves de um unico metodo em que pode ser usado por varios outros metodo de teste.
	public void inicializarAtribuos() {
		reajusteService = new ReajusteService();
		funcionario = new Funcionario("Matheus", LocalDate.now(), new BigDecimal(5000));
	}
	

	@Test
	// A desejar
	public void deveriaReajustarOSalarioEmTresPorcentoQuandoDesempenhoForADesejar() {
		funcionario.setDesempenho(Desempenho.A_DESEJAR);
		reajusteService.reajustar(funcionario);
		Assert.assertEquals(new BigDecimal("5150.00"), funcionario.getSalario());
	}
	
	@Test
	// Bom
	public void deveriaReajustarOSalarioEmQuinzePorcentoQuandoODesempenhoForBom() {
		funcionario.setDesempenho(Desempenho.BOM);
		reajusteService.reajustar(funcionario);
		Assert.assertEquals(new BigDecimal("5750.00"), funcionario.getSalario());
	}
	
	@Test
	// Otimo
	public void deveriaReajustarOSalariEmVintePorcentoQuandoODesempenhoForOtimo() {
		funcionario.setDesempenho(Desempenho.OTIMO);
		reajusteService.reajustar(funcionario);
		Assert.assertEquals(new BigDecimal("6000.00"), funcionario.getSalario());
	}
}
