// Uma classe abstrata basicamente eh uma classe que nao pode ser instanciada e serve como molde para suas 
// classes filhas.
// Exemplo de classe abstrata: A class Funcionario eh abstrata porque ela, por si so nao eh nada concreto
// diferente de Gerente, Programador, ou Editor de Video por exemplo, essa sao classes que herdam funcionarios, 
// ou seja, possui atributos e metodos de um funcionarios, porem ela sao concretas, podem ser instanciadas.

// Todas as classes filhas ainda conseguem se utilizar dos atributos e metodos de uma classe abstrata.

// Abstrata esta totalmente relacionado com heranca.
public abstract class Funcionario {
	private String nome;
	private String cpf;
	private int funcional;
	private double salario;
	
	// O protected define que o atributo ou metodo que recebe este modificador, pode ser lido e alterado
	// apenas pela class pertencente ou pela classe filha. Exemplo do nosso caso, eh que a classe Gerente
	// herda a classe Funcionario entao, Gerente eh filho de funcionario e por isso tem acesso aos 
	// atributos e metodos com o modificador protected!!!
	// protected double salario;
	
	//	public Funcionario(String nome, String cpf, int funcional) {
	//		this.nome = nome;
	//		this.cpf = cpf;
	//		this.funcional = funcional;
	//	}
	
	// Eu nao necessarimente tenho que ter um atributo para usar get sobre alguma coisa.
	
	// Um metodo abstrato, nao possui bloco de execucao, ou seja, ele esta totalmente relacionado a heranca.
	
	// E quem tem que implementar funcionalidade pra este metodo sao as classes filhas, e isso eh OBRIGATORIO.
	// Obs: A classe que for implementar nao pode ser abstrata
	
	// A usabilidade deste metodo abstrato nessa nossa aplicacao, eh, que na classe ControleBonificacao
	// eu estou passando como parametro a referencia da classe Funcionario e tambem pegando a referencia
	// recebida como parametro e executando getBonificacao, porem eu quero que quando eu passar uma referencia
	// como parametro eu receba uma referencia de uma classe filha de Funcionario, fazendo com que eu execute
	// o getBonificao da classe passada como parametro para o metodo registra.
	public abstract double getBonificacao();
	// {
		// System.out.println("Bonificacao Funcionario");
		// return this.salario * 0.05;
	// }

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getFuncional() {
		return this.funcional;
	}

	public void setFuncional(int funcional) {
		this.funcional = funcional;
	}

	public double getSalario() {
		return this.salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
}