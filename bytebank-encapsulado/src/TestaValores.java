
public class TestaValores {
	public static void main(String[] args) {
		// Conta(Classe) 
		// nomeObjeto(Nome do Objeto) 
		// = New(Palavra chave pra criar um objeto) 
		// Conta(parametros)(Valores dentro destes parentes sao os valores em que o nosso contrutor vai receber)
		Conta conta = new Conta(1337, 25467);
		
		System.out.println(conta.getAgencia());
		System.out.println(conta.getNumero());
		
		// Segundo Construtor!
		Conta conta2 = new Conta();
		Conta conta3 = new Conta();
		
		// Eu nao necessariamente preciso de uma instancia de algum objeto pra utilizar o metodo e atributos
		// que tem static.
		System.out.println(Conta.getTotal());
	}
}
