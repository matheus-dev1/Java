package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.InvocationTargetException;

import br.com.alura.alurator.playground.controle.Controle;

public class TestaInstanciaObjeto {
	public static void main(String[] args) throws 
		ClassNotFoundException, 
		InstantiationException, 
		IllegalAccessException, 
		IllegalArgumentException, 
		InvocationTargetException, 
		NoSuchMethodException, 
		SecurityException {
			/* Uma classe do tipo Class<?> parametrizavel pode 
			 * listar atributos (privados ou não) da classe em questão
			 * listar métodos (privados ou não)
			 * listar construtores
			 * executar métodos
			 * criar(instanciar) objetos da classe em questão */
			
			/* Uma classe .class, vai me retornar um objeto do tipo Class parametrizada com a propria classe.
			E chamamos isso de classe literal (Controle.class) */
			Class<Controle> controleLiteral = Controle.class;
			// FQN
			System.out.println(controleLiteral);
			// Eu só consigo já retornar uma intancia de Controle, porque meu Class<?> já está com o tipo da minha classe.
			Controle controleLiteralInstanciado = controleLiteral.getDeclaredConstructor().newInstance();
			// Verificando que controleLiteralInstanciado é uma instancia de controle. com o "instanceof"
			System.out.print("controleLiteralInstanciado é uma instancia de Controle?: ");
			System.out.println(controleLiteralInstanciado instanceof Controle);
			System.out.println();
			
			// Pegar o objeto class a partir do FQN do metodo estatico forName.
			Class<?> controleFQN = Class.forName("br.com.alura.alurator.playground.controle.Controle");
			// FQN
			System.out.println(controleFQN);
			/* Neste caso a instancia vai me retornar do tipo Object porque o nosso class, está com ? no Genereics,
			 Isso signfica que ele não pode garantir o tipo dele. */
			Object controleFQNObject = controleFQN.getDeclaredConstructor().newInstance();
			// Verificando que controleFQNObject é uma instancia de controle. com o "instanceof"
			System.out.print("controleFQNObject é uma instancia de Controle?: ");
			System.out.println(controleFQNObject instanceof Controle);
			System.out.println();
			
			// Instanciando uma classe do tipo Controle para poder usar o metodo .getClass();
			Controle controle = new Controle();
			/* Class estará parametrizado para qualquer classe que extenda Controle,
			 * ou seja, essa declaração não valerá para classes que não sejam filhas de Controle, ou seja, que herdam de Controle. */
			@SuppressWarnings("unchecked")
			Class<? extends Controle> controleGetClass = (Class<Controle>) controle.getClass();
			// FQN
			System.out.println(controleGetClass);
			/* Neste caso eu vou conseguir retornar um objeto do tipo Controle, porque o meu ?(que é a classe Objet)
			herda de Controle, então ele é um controle. */
			Object controleGetClassInstanciado = controleFQN.getDeclaredConstructor().newInstance();
			// Verificando que controleGetClassInstanciado é uma instancia de controle. com o "instanceof"
			System.out.print("controleGetClassInstanciado é uma instancia de Controle?: ");
			System.out.println(controleGetClassInstanciado instanceof Controle);
			System.out.println();
	}

}
