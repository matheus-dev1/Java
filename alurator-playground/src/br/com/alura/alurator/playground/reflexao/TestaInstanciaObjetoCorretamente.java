package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import br.com.alura.alurator.playground.controle.SubControle;

public class TestaInstanciaObjetoCorretamente {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class<SubControle> subControlePontoClass1 = SubControle.class;
		// Retornando a class Constructor<SubControle> que realmente representa um construtor.
		Constructor<SubControle> constructorSubControle1 = subControlePontoClass1.getConstructor();
		System.out.println(constructorSubControle1);
		
		Class<SubControle> subControlePontoClass2 = SubControle.class;
		// E quando eu quero retornar um Contructor<SubControle> com argumento que seja privado, eu devo colocar o tipo do argumento.
		Constructor<SubControle> constructorSubControle2 = subControlePontoClass2.getDeclaredConstructor(String.class);
		System.out.println(constructorSubControle2);
		// Tornando o nosso construtor private acessivel, ou seja, eu consigo instacia-lo
		constructorSubControle2.setAccessible(true);
		// Quando eu estou usando o newInstance e tenho um argumento, aqui a gente relamente passa o valor do argumento.
		SubControle subControleInstancia = constructorSubControle2.newInstance("Testando...");
		System.out.println(subControleInstancia);
	}
		
}
