package br.com.alura.alurator.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ConstrutorPadrao {
	
	private Constructor<?> construtor;
	
	public ConstrutorPadrao(Constructor<?> construtor) {
		this.construtor = construtor;
	}

	public Object invoca() {
		try {
			return construtor.newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			// getTargetException() mostra a exception que ocorreu na classe
			throw new RuntimeException("Erro no construtor!", e.getTargetException());
		}
	}
}
