
public class TesteFuncionario {
	public static void main(String[] args) {
		// Funcionario funcionario = new Funcionario("Matheus de Oliveira Silva", "234.343.231-55", 4312345);
		// Funcionario funcionario = new Funcionario();
		Funcionario funcionario = new Gerente();
		
		funcionario.setSalario(5000.00);
		funcionario.setNome("Matheus");
		funcionario.setFuncional(43434);
		funcionario.setCpf("222-222-222-22");
		
		System.out.println(funcionario.getNome());
		System.out.println(funcionario.getCpf());
		System.out.println(funcionario.getFuncional());
		System.out.println(funcionario.getSalario());
		System.out.println(funcionario.getBonificacao());
		
		// Mostra a classe deste objeto.
		// Eh uma classe Gerente, porem a referencia eh do tipo Funcionario entao tera apenas acesso aos
		// metodos da classe Funcionario.
		System.out.println(funcionario.getClass());
	}
}
