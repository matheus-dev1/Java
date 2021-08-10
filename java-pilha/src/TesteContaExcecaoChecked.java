
public class TesteContaExcecaoChecked {

	public static void main(String[] args) {
		// CTRL + D | Apaga a linha
		Conta conta = new Conta();
		try {
			conta.dep();
		} catch(MinhaExcecaoApenasException ex) {
			System.out.println(ex);
		}
		
	}

}
