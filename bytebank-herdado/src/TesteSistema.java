
public class TesteSistema {
	public static void main(String[] args) {
		Gerente gerente = new Gerente();
		gerente.setSenha(2323);
		gerente.setLogin("Matheus");
		
		Administrador administrador = new Administrador();
		administrador.setSenha(3333);
		administrador.setLogin("Karlos Chagas de Souza Aben");
		
		Cliente cliente = new Cliente();
		cliente.setLogin("Matheus");
		cliente.setSenha(2323);
		
		SistemaInterno sistemaInterno = new SistemaInterno();
		// Apenas de eu passar a referencia do objeto aqui ele vai autenticar e me retornar um resposta.
		sistemaInterno.autentica(gerente);
		sistemaInterno.autentica(administrador);
		sistemaInterno.autentica(cliente);
	}
}
