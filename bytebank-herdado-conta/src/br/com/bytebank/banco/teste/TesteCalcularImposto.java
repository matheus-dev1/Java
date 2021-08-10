package br.com.bytebank.banco.teste;

import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.AcaoBolsa;
import br.com.bytebank.banco.modelo.SeguroDeVida;
import br.com.bytebank.banco.modelo.Tributavel;
import br.com.bytebank.banco.modelo.CalcularImposto;

public class TesteCalcularImposto {

	public static void main(String[] args) {
		ContaCorrente contaCorrente = new ContaCorrente(2323, 5555);
		AcaoBolsa acaoBolsa = new AcaoBolsa();
		SeguroDeVida seguroDeVida = new SeguroDeVida();
		
		CalcularImposto calcularImposto = new CalcularImposto();
		
		contaCorrente.setValorImposto(300);
		System.out.println(contaCorrente.getValorImposto());
		calcularImposto.calcula((Tributavel) contaCorrente);
		
		acaoBolsa.setValorImposto(400);
		System.out.println(acaoBolsa.getValorImposto());
		calcularImposto.calcula(acaoBolsa);
		
		seguroDeVida.setValorImposto(600);
		System.out.println(seguroDeVida.getValorImposto());
		calcularImposto.calcula(seguroDeVida);
	}
}
