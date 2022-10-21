package br.com.alura.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestaInvocaMetodoSemParametro {
	public static void main(String[] args) throws ClassNotFoundException {
		Class<?> subControleClass = Class.forName("br.com.alura.alurator.playground.controle.SubControle");
		
		Object SubControleInstancia = null;
		
		try {
			Constructor<?> construtorSubControle = subControleClass.getDeclaredConstructor();
			SubControleInstancia = construtorSubControle.newInstance();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		for(Method method : subControleClass.getMethods()) {
			System.out.println(method);
		}
		
		System.out.println("-----------------------------------------------------");
		
		for(Method method : subControleClass.getDeclaredMethods()) {
			System.out.println(method);
		}
		
		System.out.println("-----------------------------------------------------");
		
		try {
			Method metodoSubControle1 = subControleClass.getMethod("metodoSubControle1");
			metodoSubControle1.invoke(SubControleInstancia);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		
		System.out.println("-----------------------------------------------------");
		
		try {
			Method metodoSubControle2 = subControleClass.getDeclaredMethod("metodoSubControle2");
			metodoSubControle2.setAccessible(true);
			Object retornoDoMetodo = metodoSubControle2.invoke(SubControleInstancia);
			System.out.println(retornoDoMetodo);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
	}
}
