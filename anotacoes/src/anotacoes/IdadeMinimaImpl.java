package anotacoes;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.Period;

public class IdadeMinimaImpl {
	public static <T> boolean validador(T objeto) {
		// Pegar o tipo da classe de generics
		Class<?> classe = objeto.getClass();
		/* Para decbrir qual atributo está declarado a anotação nos usamos fazemos um laço de
		 * repetição por todos os metodo até achar um atributo que tenha um anotação 
		 * atraves do metodo classe.getDeclaredFields()
		 */
		for (Field field : classe.getDeclaredFields()) {
			/*
			 * Atraves do metodo isAnnotationPresent passando como parametro a nossa anotação 
			 * verificamos se a anotação está presente no atributo do indice atual.
			 * */
			if (field.isAnnotationPresent(IdadeMinima.class)) {
				/* 
				 * Atraves do metodo getAnnotation, passando como parametro a nossa anotação
				 * Pegamos o valor atribuido na classe que anotamos.
				 */
				IdadeMinima idadeMinima = field.getAnnotation(IdadeMinima.class);
				/*
				 * Exibir o valor configurado. 
				 * */
				System.out.println(idadeMinima.valor());
				try {
					/*
					 * Para acessar o valor de um atributo private precisamos falar que esse 
					 * atributo está acessível, desta forma: field.setAccessible(true);
					 * 
					 * Eu deixo o atributo acessivel.
					 * */
					field.setAccessible(true);
					/*
					 * Para pegar o valor do atributo anotado com @IdadeMinima vamos usar
					 *  o método get() da classe Field.
					 * */
					LocalDate dataNascimento = (LocalDate) field.get(objeto);
					/*
					 * Na comparação iremos usar o método between() que recebe como parâmetro
					 * duas datas para serem comparadas, o método now() para obtermos a data
					 * atual e o método getYears() para conseguirmos saber o valor do período
					 * em anos:
					 * */
					return Period.between(dataNascimento, LocalDate.now()).getYears() >= idadeMinima.valor();
				} catch (IllegalAccessException e) {
		              e.printStackTrace();
		         }

			}
		}
		return false;
	}
}
