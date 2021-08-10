
public class TesteSacaValorNegativo {
	public static void main(String[] args) {
		Conta conta = new Conta();
		
		// Nao consigo acessar o atributo saldo porque ele esta privado para a propria classe.
		// conta.saldo = 100;
		conta.deposita(100);
		System.out.println(conta.getSaldo());
	}
}
