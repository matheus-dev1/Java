// Gerente herda todos os atributos e metodos da Classe Funcionario.
// A classe que herda vira classe filha e a classe que passa os atributos e metodos e a classe Pai.
public class Gerente extends Funcionario implements Autenticavel {
	
	private AutenticacaoUtil autenticador;
	
	// Isso sempre vai estar aqui, as vezes de forma implicita, ou seja, ele esta, mas nao esta aparecendo no codigo.
	public Gerente() {
		super();
		// Com a composicao eu possuo os metodos e atributos da classe instanciada.
		this.autenticador = new AutenticacaoUtil();
	}
	
	//	public Gerente(String nome, String cpf, int funcional) {
	//		super(nome, cpf, funcional);
	//	}

	//	public boolean autentica(int senha) {
	//		if(this.senha == senha) {
	//			return true;
	//		}
	//		return false;
	//	}
	
	// A sobrecarga não leva em conta a visibilidade ou retorno do método, apenas os parâmetros
	// e não depende da herança.
	
	// A ideia eh criar uma "nova versao" do nosso metodo, neste nosso caso colocando um parametro a mais
	// na invocacao do metodo.
	//	public boolean autentica(int senha, String login) {
	//		if(this.senha == senha && this.Login == login) {
	//			return true;
	//		}
	//		return false;
	//	}
	
	public void setSenha(int senha) {
		this.autenticador.setSenha(senha);
	}
	
	public void setLogin(String login) {
		this.autenticador.setLogin(login);
	}
	
	// Aqui por exemplo ele vai recebe os valores 2323 para senha e "Matheus" para login.
	public boolean autentica(int senha, String login) {
		return this.autenticador.autentica(senha, login);
	}
	
	// Eu nao necessarimente tenho que ter um atributo para usar get sobre alguma coisa.
	
	// Aqui eu estou fazendo uma reescrita de um metodo da classe herdada por este classe(Gerente).
	// Obs: Normalmente nos nao alteramos modificadores, tipo do valor de retorno, nome do metodo nem parametros
	// apenas o que o metodo faz propriamente dito.
	@Override
	public double getBonificacao() {
		System.out.println("Bonificacao Gerente");
		// Diferente do this. o super. mostra pra que este atributo pertence a classe mae e nao a esta classe.
		// Diferente do this. o super. me deixa usar e mostra os metodos e atributos da classe extendida ou 
		// herdada, entao se por exemplo eu preciso de um metodo da classe mae, eu apenas coloco o sufixo super.
		// e eu posso usar.
		
		// O ponto aqui eh, sempre reaproveitas codigo e nunca reescrever um codigo ja existente.
		// E outro beneficio eh que eu altero em um lugar e todo o resto sofre as alteracoes, sem ter que
		// ficar mexendo individualmente.
		return super.getSalario();
	}
}