
public class EditorDeVideo extends Funcionario {
	
	// Isso sempre vai estar aqui, as vezes de forma implicita, ou seja, ele esta, mas nao esta aparecendo no codigo.
	public EditorDeVideo() {
		super();
	}
	
	public double getBonificacao() {
		System.out.println("Bonificacao Editor de Video");
		return 150;
	}
}