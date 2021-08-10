// A unica relacao em que a Classe SistemaInterno tem com Autenticavel eh que como parametro eu estou
// solicitando a interface Autenticavel ou qualquer classe mais especifica que implementa a 
// interface Autenticavel
public class SistemaInterno {
	private int senha = 2323;
	private String login = "Matheus";
	
	// Como eu posso passar classe mais genericas para usar o Polimorfismo, eu tambem posso fazer isso com
	// interface, fazendo com que apenas um metodo, qualquer classe que assina o contrato desta interface
	// consiga passar como parametro a referencia do seu objeto.
	public void autentica(Autenticavel autenticavel) {
		if(autenticavel.autentica(this.senha, this.login)) {
			System.out.println("Ok");
		} else {
			System.out.println("Not ok");
		}
	}
}
