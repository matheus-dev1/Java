
public class TestaMetodo {
	public static void main(String[] args) {
		Conta conta = new Conta();
		// Invocando o metodo do Objeto e passando para o metodo um parametro.
		conta.deposita(200);
		System.out.println(conta.saldo);
		// O metodo saca() me retorna um boleano.
		boolean saqueDoSaldo = conta.saca(57);
		// CTRL e passar o mouse em cima de alguma codigo meu ele vai me dar um link pra ir ate ele ver o 
		// codigo da onde eu estou com o mouse em cima.
		if(saqueDoSaldo) {
			System.out.println("Saque realizado com sucesso! \nSaldo: " + conta.saldo);
		} else {
			System.out.println("Saque nao foi realizado! \n Saldo: " + conta.saldo);
		}
		
		Conta contaDoMarcelo = new Conta();
		// contaDoMarcelo sera o .this na classe Conta por exemplo.
		// Sera a nossa conta de origem.
		contaDoMarcelo.deposita(1500);
		System.out.println("Saldo do Marcelo: " + contaDoMarcelo.saldo);
		
		// No segundo parametro ele recebe uma variavel do tipo Conta que eh uma recefencia do objeto do tipo
		// Conta em que eu quero tranferir um valor da referencia de objeto "contaDoMarcelo"
		// Obs: Eu nao preciso armarenar o retorno do metodo e depois passar para if eu ja posso passar assim.
		if(contaDoMarcelo.tranfere(500, conta)) {
			System.out.println("Tranferencia feita com sucesso!");
			System.out.println("Saldo do Marcelo: " + contaDoMarcelo.saldo);
			System.out.println("Saldo da Conta Destino: " + conta.saldo);
		} else {
			System.out.println("Tranferencia nao realizada!");
		}
		
		contaDoMarcelo.titular = "Marcelo";
		System.out.println(contaDoMarcelo.titular);

	}
}