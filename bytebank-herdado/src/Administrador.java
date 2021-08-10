
// Nos podemos herdam uma classe e tambem podemos implmentar os metodos de uma interface.
public class Administrador extends Funcionario implements Autenticavel{

	private AutenticacaoUtil autenticador;
	
	public Administrador() {
		super();
		this.autenticador = new AutenticacaoUtil();
	}
	
	// Como nos estamos implmentando uma interface, nos temos que assinar(definir uma funcionalidade)
	// para os metodos da interface.
	// Porem, nos podemos pegar a logica de outro arquivo, unico para todas a classe que forem usar, em apenas
	// um arquivo e se tiver que altera vai alterar em apenas um lugar.
	public void setSenha(int senha) {
		this.autenticador.setSenha(senha);
	}
	
	public void setLogin(String login) {
		this.autenticador.setLogin(login);
	}
	
	public boolean autentica(int senha, String login) {
		return this.autenticador.autentica(senha, login);
	}
	
	@Override
	public double getBonificacao() {
		return 50;
	}
}
