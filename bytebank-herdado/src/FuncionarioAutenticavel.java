
// A ideia desta classe eh que eu criei uma outra classe que apenas os meus funcionarios Gerente e Administrador
// possuiem.
// Eu so nao preciso definir o metodo getBonificacao aqui, porque esta classe e abstrata
public abstract class FuncionarioAutenticavel extends Funcionario {
	private int senha;
	private String login;
	
	public void setSenha(int senha) {
		this.senha = senha;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public boolean autentica(int senha, String login) {
		if(this.senha == senha && this.login == login) {
			return true;
		} else {
			return false;
		}
	}
}
