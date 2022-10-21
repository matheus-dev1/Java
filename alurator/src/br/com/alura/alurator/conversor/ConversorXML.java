package br.com.alura.alurator.conversor;

import java.lang.reflect.Field;
import java.util.Collection;

import br.com.alura.alurator.conversor.anotacao.NomeTagXml;

public class ConversorXML {

	public String converte(Object objeto) {
		Class<?> classe = objeto.getClass();
		// StringBuilder para concatenar o XML.
		StringBuilder stringBuilder = new StringBuilder();
		String nomeClasse = null;
		String nomeAtributo = null;
		
			try {
				if(objeto instanceof Collection) {
					Collection<?> colecao = (Collection<?>) objeto;
					stringBuilder.append("<lista>");
				        for (Object objectColecao : colecao) {
				            String xml = converte(objectColecao);
				            stringBuilder.append(xml);
				        }
			        stringBuilder.append("</lista>");
				} else {
					if(classe.isAnnotationPresent(NomeTagXml.class)) {
						NomeTagXml nomeTagXml = classe.getDeclaredAnnotation(NomeTagXml.class);
						nomeClasse = nomeTagXml.value();
					} else {
						nomeClasse = classe.getName();
					}
					
					stringBuilder.append("<" + nomeClasse + ">");
					
					// Passar por todos os atributos
			        for (Field atributo: classe.getDeclaredFields()) {
			        	if(atributo.isAnnotationPresent(NomeTagXml.class)) {
			        		NomeTagXml nomeTagXmlAtributo = atributo.getDeclaredAnnotation(NomeTagXml.class);
			        		nomeAtributo = nomeTagXmlAtributo.value();
			        	} else {
			        		nomeAtributo = atributo.getName();
			        	}
			        	atributo.setAccessible(true);
				        	
			        	Object valorAtributo = atributo.get(objeto);
		
			        	stringBuilder.append("<" + nomeAtributo + ">");
			        		stringBuilder.append(valorAtributo);
			        	stringBuilder.append("</" + nomeAtributo + ">");
			        }
		            
					stringBuilder.append("</" + nomeClasse + ">");
				}
				
			} catch(IllegalArgumentException | IllegalAccessException e) {
		        e.printStackTrace();
		        throw new RuntimeException("Erro na geração do XML!");
			}
			
		return stringBuilder.toString();
	}

}
