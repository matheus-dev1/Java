public class CalcIMC {
	private double peso;
	private double altura;
	private double alturax2;
	private double resultado;

	public void setAltura(double altura) {
		this.altura = altura;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double Calcular() {
		this.alturax2 = this.altura * this.altura;
		this.resultado = this.peso / this.alturax2;
		return this.resultado;
	}
}