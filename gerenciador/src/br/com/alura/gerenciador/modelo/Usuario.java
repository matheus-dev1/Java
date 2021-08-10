package br.com.alura.gerenciador.modelo;

// Java Autenthication and Authorization Service (JAAS - API padrão do Java para segurança)
public class Usuario {
	private String login;
    private String senha;

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean ehIgual(String login, String senha) {
        if(!this.login.equals(login) || !this.senha.equals(senha)) {
            return false;
        }

        return true;
    }
}
