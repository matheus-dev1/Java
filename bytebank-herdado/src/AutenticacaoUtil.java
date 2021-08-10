
public class AutenticacaoUtil {
	public int senha;
	public String login;
	
	public void setSenha(int senha) {
		this.senha = senha;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public boolean autentica(int senha, String login) {
		// this.senha eh o valor setado pela classe que invoca o metodo, como Gerente por exemplo.
		if(this.senha == senha && this.login == login)	{
			return true;
		} else {
			return false;
		}
	}
}
