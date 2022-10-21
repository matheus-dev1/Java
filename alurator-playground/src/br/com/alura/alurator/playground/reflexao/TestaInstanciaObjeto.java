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
			 * listar atributos (privados ou n�o) da classe em quest�o
			 * listar m�todos (privados ou n�o)
			 * listar construtores
			 * executar m�todos
			 * criar(instanciar) objetos da classe em quest�o */
			
			/* Uma classe .class, vai me retornar um objeto do tipo Class parametrizada com a propria classe.
			E chamamos isso de classe literal (Controle.class) */
			Class<Controle> controleLiteral = Controle.class;
			// FQN
			System.out.println(controleLiteral);
			// Eu s� consigo j� retornar uma intancia de Controle, porque meu Class<?> j� est� com o tipo da minha classe.
			Controle controleLiteralInstanciado = controleLiteral.getDeclaredConstructor().newInstance();
			// Verificando que controleLiteralInstanciado � uma instancia de controle. com o "instanceof"
			System.out.print("controleLiteralInstanciado � uma instancia de Controle?: ");
			System.out.println(controleLiteralInstanciado instanceof Controle);
			System.out.println();
			
			// Pegar o objeto class a partir do FQN do metodo estatico forName.
			Class<?> controleFQN = Class.forName("br.com.alura.alurator.playground.controle.Controle");
			// FQN
			System.out.println(controleFQN);
			/* Neste caso a instancia vai me retornar do tipo Object porque o nosso class, est� com ? no Genereics,
			 Isso signfica que ele n�o pode garantir o tipo dele. */
			Object controleFQNObject = controleFQN.getDeclaredConstructor().newInstance();
			// Verificando que controleFQNObject � uma instancia de controle. com o "instanceof"
			System.out.print("controleFQNObject � uma instancia de Controle?: ");
			System.out.println(controleFQNObject instanceof Controle);
			System.out.println();
			
			// Instanciando uma classe do tipo Controle para poder usar o metodo .getClass();
			Controle controle = new Controle();
			/* Class estar� parametrizado para qualquer classe que extenda Controle,
			 * ou seja, essa declara��o n�o valer� para classes que n�o sejam filhas de Controle, ou seja, que herdam de Controle. */
			@SuppressWarnings("unchecked")
			Class<? extends Controle> controleGetClass = (Class<Controle>) controle.getClass();
			// FQN
			System.out.println(controleGetClass);
			/* Neste caso eu vou conseguir retornar um objeto do tipo Controle, porque o meu ?(que � a classe Objet)
			herda de Controle, ent�o ele � um controle. */
			Object controleGetClassInstanciado = controleFQN.getDeclaredConstructor().newInstance();
			// Verificando que controleGetClassInstanciado � uma instancia de controle. com o "instanceof"
			System.out.print("controleGetClassInstanciado � uma instancia de Controle?: ");
			System.out.println(controleGetClassInstanciado instanceof Controle);
			System.out.println();
	}

}
