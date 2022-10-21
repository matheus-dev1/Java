package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestaInvocaMetodoComParametro {
	public static void main(String[] args) {
		try {
			Class<?> controleClass = Class.forName("br.com.alura.alurator.playground.controle.Controle");
			Constructor<?> construtorControle = controleClass.getDeclaredConstructor();
			construtorControle.setAccessible(true);
			Object controleInstancia = construtorControle.newInstance();
			
			Method metodo1 = controleClass.getDeclaredMethod("metodoControle2", String.class);
			metodo1.invoke(controleInstancia, "Testando...");
			
			Method metodo2 = controleClass.getDeclaredMethod("metodoControle2", String.class, String.class);
			metodo2.setAccessible(true);
			metodo2.invoke(controleInstancia, "Testando...", "Testando2...");

			Method metodo3 = controleClass.getDeclaredMethod("metodoControle2", String.class, Integer.class);
			metodo3.invoke(controleInstancia, "Testando...", 22);
			
		} catch ( ClassNotFoundException 
				| NoSuchMethodException 
				| SecurityException 
				| InstantiationException 
				| IllegalAccessException 
				| IllegalArgumentException 
				| InvocationTargetException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
	}
}
