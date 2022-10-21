package br.com.alura.alurator.reflexao;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.stream.Stream;

public class ManipuladorMetodo {
	
	private Object instanciaClasse;
	private Class<?> classe;
	
	public ManipuladorMetodo() { }
	
	public ManipuladorMetodo(Class<?> classe, Object instanciaClasse) {
		this.instanciaClasse = instanciaClasse;
		this.classe = classe;
	}
	
	public MetodoInvoker getMetodo(String nomeMetodo, Map<String, Object> parametrosMap) {
		Stream<Method> streamMethods = Stream.of(instanciaClasse.getClass().getDeclaredMethods());
		Method metodoSelecionado = streamMethods.filter(metodo -> 
					metodo.getName().equals(nomeMetodo) 
					&& metodo.getParameterCount() == parametrosMap.values().size() 
					&& Stream.of(metodo.getParameters())
					.allMatch(param -> 
						parametrosMap.keySet().contains(param.getName()) 
						&& parametrosMap.get(param.getName()).getClass().equals(param.getType())
                    )
				)
				.findFirst()
				.orElseThrow(() -> new RuntimeException("Método não encontrado!!!"));
		
		return new MetodoInvoker(instanciaClasse, metodoSelecionado, parametrosMap);
		
		/*try {
			//Method metodo = classe.getDeclaredMethod(nomeMetodo);
			//metodo.setAccessible(true);
			return new MetodoInvoker(instanciaClasse, metodoSelecionado, parametrosMap);
		} catch (SecurityException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}*/
	}

}
