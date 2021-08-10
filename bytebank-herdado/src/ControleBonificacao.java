
public class ControleBonificacao {
	private double somaBonificacao;
	
	// Eu consigo passar para como parametro a classe padrao do parametro, no caso Funcionario, mas eu tambem
	// consigo passar classes que HERDAM da classe funcionario, ou seja, se eu passar a classe gerente
	// vai funcionar porque ela herda de funcionario, ou seja, "existe" dentro da classe gerente
	// a classe funcionario.
	
	// O que eu nao poderia fazer eh, solicitar no parametro do metodo registra a classe Gerente, e passar
	// na invocacao do metodo a classe funcionario ou Editor de Video, porque, eles nao herdam gerente.
	
	// O polimorfismo permite usar referencias mais genericas para a comunicacao com um objeto.
	public void registra(Funcionario funcionarios) {
		// Aqui eu vou invocar o metodo referente ao tipo da classe da variavel passada como parametro na 
		// invocacao do metodo registra.
		
		// Exemplo: Instanciei Gerente gerente1 = new Gerente(), ou seja, tipo "Gerente", ao passar para 
		// controleBonificacao.registra(gerente1), esta classe possui um metodo chamado getBonificacao()
		// espeficifo, entao dependendo da classe que for passada como parametro ele vai invocar o metodo 
		// especifico da classe, suponto que todas as classe passadas como parametro tenha os mesmos metodos
		// com comportamentos diferentes.
		
		// Com um print em getBonificacao de cada classe, nos mostramos que em cada objeto, ele vai executar
		// um o metodo especifico de cada classe.
		
		// Sempre sera chamado o metodo mais especifico da classe.
		this.somaBonificacao += funcionarios.getBonificacao();
	}
	
	// Getter da soma total das bonificacoes de todos os funcionarios.
	public double getSomaBonificacao() {
		return somaBonificacao;
	}
}
