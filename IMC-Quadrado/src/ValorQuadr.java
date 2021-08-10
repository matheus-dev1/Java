public class ValorQuadr {
	private int valor;
	private int resultado;

	public void setValor(int valor) {
		this.valor = valor;
	}
	public int getResultado() {
		return resultado;
	}
	public void calcular() {
		this.resultado = this.valor * this.valor;
	}
}
