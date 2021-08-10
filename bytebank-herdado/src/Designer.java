
public class Designer extends Funcionario {
	
	// Isso sempre vai estar aqui, as vezes de forma implicita, ou seja, ele esta, mas nao esta aparecendo no codigo.
	public Designer() {
		super();
	}
	
	// Este metodo eh uma implementacao de um metodo abstrato da classe Funcionario
	public double getBonificacao() {
		System.out.println("Bonificacao Designer");
		return 200;
	}
}