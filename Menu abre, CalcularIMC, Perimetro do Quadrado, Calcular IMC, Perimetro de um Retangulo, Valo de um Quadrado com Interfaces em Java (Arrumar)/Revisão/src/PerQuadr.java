public class PerQuadr {
	private int lado;
	private int resultado;
	
	public void setLado(int lado) {
		this.lado = lado;
	}
	public int getResultado() {
		return resultado;
	}
	public void calcular() {
		this.resultado = this.lado + this.lado + this.lado + this.lado;
	}
}
