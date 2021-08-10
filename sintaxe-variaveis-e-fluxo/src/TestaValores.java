
public class TestaValores {
	// O CTRL + Space abre alguns templaes referente ao que voce provavelmente quer.
	// Por exemplo se voce escrever main e CTRL + Space ele vai te sugerir criar o template
	// de metodo main da aplicacao.
	 public static void main(String[] args) {
		 int primeiro = 5;
		 int segundo = 7;
		 // Aqui eu estou fazendo um atribuicao nao uma referencia, ou seja, a varaivel 
		 // segundo realmente rececebe o valor de primeiro.
		 segundo = primeiro;
		 primeiro = 10;
		 
		 System.out.println(segundo);
	 }
}
