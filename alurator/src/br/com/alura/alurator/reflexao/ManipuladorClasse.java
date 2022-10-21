package br.com.alura.alurator.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ManipuladorClasse {
	
	private Class<?> classe;
	
	public ManipuladorClasse(Class<?> classe) {
		this.classe = classe;
	}

	public ConstrutorPadrao getConstrutorPadrao() {
		try {
			Constructor<?> construtorClasse = this.classe.getDeclaredConstructor();
			return new ConstrutorPadrao(construtorClasse);
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public ManipuladorMetodo criandoInstancia()  {
			try {
				Constructor<?> construtorClasse = this.classe.getDeclaredConstructor();
				return new ManipuladorMetodo(classe, construtorClasse.newInstance());
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			} catch (InvocationTargetException e) {
				e.printStackTrace();
				// getTargetException() mostra a exception que ocorreu na classe
				throw new RuntimeException("Erro no construtor!", e.getTargetException());
			}
	}
	
}
