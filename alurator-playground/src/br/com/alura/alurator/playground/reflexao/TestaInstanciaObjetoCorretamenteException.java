package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestaInstanciaObjetoCorretamenteException {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException  {
			Class<?> classeControleException1 = Class.forName("br.com.alura.alurator.playground.controle.ControleException");
			Constructor<?> constructorControleException1 = classeControleException1.getDeclaredConstructor();
			try {
				// Usar o newInstance(), do construtor é melhor porque você é obrigado a tratar as exceptions.
				Object classeControleExceptionInstancia = constructorControleException1.newInstance();
			} catch ( InstantiationException 
					| IllegalAccessException 
					| IllegalArgumentException 
					| InvocationTargetException e
				) {
					e.printStackTrace();
				}
	}
		
}
