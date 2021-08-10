
public class TesteReferencias {

	public static void main(String[] args) {
		// Como gerente herda a classe Funcionario nos conseguimos instancia um objeto do tipo Gerente
		// e no armazenamento da variavel, nos conseguimos colocar o tipo da variavel com a classe herdada.
		// Porem eu apenas vou conseguir usar os metodos e atributos do tipo da classe da variavel.
		
		// Basicamente nos podemos colocar a referencia da variavel de um tipo mais generico, neste caso 
		// da classe Funcionario.
		
		// O objeto nunca muda o tipo, uma vez um gerente criado, ele sempre sera um gerente.
		// O que pode mudar o tipo da refencia deste objeto.
		Funcionario gerente = new Gerente();
		gerente.setNome("Matheus");
		gerente.getNome();
		
		// Este metodo nao funciona porque a referencia eh do tipo Funcionario e nao Gerente.
		// gerente.autentica();
		
		// --------------------------------------------------------------------------------------
		
		ControleBonificacao controleBonificacao = new ControleBonificacao();
		
		Gerente gerente1 = new Gerente();
		gerente1.setSalario(5000.0);
		// Gerente herda a classe Funcionario.
		controleBonificacao.registra(gerente1);
		
		// Uma classe abstrata nao pode ser instanciada.
		// Funcionario funcionario = new Funcionario();
		// funcionario.setSalario(2000.0);
		// Funcionario eh a classe solicitada.
		// controleBonificacao.registra(funcionario);
		
		EditorDeVideo editorDeVideo = new EditorDeVideo();
		editorDeVideo.setSalario(2500.0);
		// EditorDeVideo herda a classe Funcionario.
		controleBonificacao.registra(editorDeVideo);
		
		Designer designer = new Designer();
		designer.setSalario(4000.0);
		// Designer herda a classe Funcionario.
		controleBonificacao.registra(designer);
		
		System.out.println(controleBonificacao.getSomaBonificacao());
	}

}
