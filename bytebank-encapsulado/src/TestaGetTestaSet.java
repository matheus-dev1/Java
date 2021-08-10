
public class TestaGetTestaSet {
	public static void main(String[] args) {
		Conta conta = new Conta(1234, 44344);
		
		conta.setNumero(100);
		System.out.println(conta.getNumero());
		
		Cliente cliente = new Cliente();
		// Atribuindo ao atributo "titular" atraves do metodo setTitular.
		conta.setTitular(cliente);
		// Eu estou acessando um metodo que me referencia objeto 
		conta.getTitular().setNome("Matheus");
		System.out.println(conta.getTitular().getNome());
		
		// Eu armazeno o retorno do objeto do metodo getTitular que vai me retornar o objeto Cliente setado.
		Cliente titular = conta.getTitular();
		titular.setProfissao("programador");
		System.out.println(titular.getProfissao());
	}
}
