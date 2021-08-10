// No java as pastas/diretorios se chamam pacotes/packages.
// Quando um arquivo nosso esta dentro de um pacote nos precisamos deixar claro qual pacote ele pertence.
package br.com.bytebank.banco.teste;

// CTRL + SHITF + O | Ja coloca o import de todas as classes.
import br.com.bytebank.banco.modelo.ContaCorrente;
import br.com.bytebank.banco.modelo.ContaPoupanca;
import br.com.bytebank.banco.modelo.SaldoInsuficienteException;

public class TesteContas {
	public static void main(String[] args) {
		// O compilador indentifica error de sintaxe, este o codigo abaixo nao me da um erro de sintaxe,
		// mas me gera uma Excessao, porque a minha referencia contaNull, nao possui uma instancia
		// da classe.
		
		// Cada Excessao/Erro possui um nome.
		// ContaCorrente contaNull = null;
		// contaNull.deposita(200);
		// int a = 3 / 0;
		
		ContaCorrente contaCorrente = new ContaCorrente(112, 3242);
		contaCorrente.deposita(100);
		
		// Quando sua classe esta dentro de uma pasta ou uma hierarquia de pastas, a sua classe recebe
		// este nome antes da classe, exemplo: modelo.Conta conta = new modelo.ContaCorrente(2323, 343);
		// E isso acontece quando voce esta tentando usar uma classe de outro pacote do seu projeto
		// ou voce tambem pode colocar o nome do proprio pacote da propria classe.
		
		// Eh preciso qualificar a classe.
		// Full Qualified Name(FQN) - Nome completo da classe composto pelo nome do pacote e onome da classe.
		ContaPoupanca contaPoupanca = new ContaPoupanca(113, 32009);
		contaPoupanca.deposita(200);
		
		try {
			contaCorrente.tranfere(20.0, contaPoupanca);
		} catch(SaldoInsuficienteException exception) {
			System.out.println(exception);
		}
		
		System.out.println("Conta Corrente: " + contaCorrente.getSaldo());
		System.out.println("Conta Poupanca: " + contaPoupanca.getSaldo());
		
		try {
			contaCorrente.saca(10);
		} catch(SaldoInsuficienteException exception) {
			System.out.println(exception);
		}
		
		try {
			contaPoupanca.saca(20);
		} catch(SaldoInsuficienteException exception) {
			System.out.println(exception);
		}
		
		System.out.println("Sacando...");
		System.out.println("Conta Corrente: " +  contaCorrente.getSaldo());
		System.out.println("Conta Poupanca: " +  contaPoupanca.getSaldo());
	}
}