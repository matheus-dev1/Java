package br.com.alura.alurator.reflexao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class MetodoInvoker {
	
	private Object instanciaClasse;
	private Method metodo;
	private Map<String, Object> parametrosMap;
	
	public MetodoInvoker(Object instanciaClasse, Method metodo, Map<String, Object> parametrosMap) {
		this.instanciaClasse = instanciaClasse;
		this.metodo = metodo;
		this.parametrosMap = parametrosMap;
	}
	
	public Object invoca() {
		try {
			List<Object> parametros = new ArrayList<>();
			Stream<Parameter> parameterStream = Stream.of(metodo.getParameters());
			parameterStream.forEach(parametro -> {
				Object valorParametro = parametrosMap.get(parametro.getName());
				parametros.add(valorParametro);
			});
			Object retornoDoMetodo = metodo.invoke(instanciaClasse, parametros.toArray());
			System.out.println("Invoca: " + retornoDoMetodo);
			return retornoDoMetodo;
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public MetodoInvoker comTratamentoDeExcecao() {
		System.out.println("Erro no metodo: " + this.metodo.getName() + " da classe " + this.metodo.getDeclaringClass().getName() +  ".\n\n");
		throw new RuntimeException("Erro no metodo!");
	}

}
