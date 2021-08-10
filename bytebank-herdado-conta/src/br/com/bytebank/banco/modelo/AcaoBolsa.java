package br.com.bytebank.banco.modelo;

public class AcaoBolsa implements Tributavel {
	
	private TributavelUtil calcular;
	
	public AcaoBolsa() {
		this.calcular = new TributavelUtil();
	}
	
	public double setValorImposto(double valor) {
		return this.calcular.setValorImposto(valor);
	}
	
	public double getValorImposto() {
		return this.calcular.getValorImposto();
	}
	
	public boolean calcula(double porcentagemImposto) {
		return this.calcular.calcula(porcentagemImposto);
	}
}
