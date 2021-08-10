
public class TesteGerente {
	public static void main(String[] args) {
		Gerente gerente = new Gerente();
		
		// Quando a gente coloca ponto (.) pra utilizar um metodo ou atributo, se for um metodo ele me mostra
		// o tipo do retorno e qual de qual classe eh este metodo.
		// No nosso caso setCpf foi herdado da class Funcionario, pelo Gerente ter herdado esses metodos
		// ele pode usar e setar este valor para a classe dele.
		gerente.setCpf("222.222.222-88");
		gerente.setFuncional(89732);
		gerente.setNome("Matheus");
		gerente.setSalario(5000);
		
		// Metodo apenas do Gerente.
		gerente.setSenha(555);
		
		System.out.println(gerente.getCpf());
		System.out.println(gerente.getFuncional());
		System.out.println(gerente.getNome());
		System.out.println(gerente.getSalario());
		
		// Metodo apenas do Gerente.
		System.out.println(gerente.autentica(555, "Matheus"));
		
		System.out.println(gerente.getBonificacao());
	}
}
