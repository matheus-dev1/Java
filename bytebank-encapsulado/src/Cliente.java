
public class Cliente {
	private String nome;
	private String cpf;
	private String profissao;
	
	// Para gerar Getter e Setter de forma automatica nos vamos em "Source" -> "Generate Getter and Setters"
	// -> Seleciona os atributos em que voce queira cria os Getter e Setters, tem algumas configuracoes
	// como o ponto de insercao ou como vai ser ordenado.
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public String getProfissao() {
		return profissao;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
}
