package anotacoes;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.Period;

public class IdadeMinimaImpl {
	public static <T> boolean validador(T objeto) {
		// Pegar o tipo da classe de generics
		Class<?> classe = objeto.getClass();
		/* Para decbrir qual atributo est� declarado a anota��o nos usamos fazemos um la�o de
		 * repeti��o por todos os metodo at� achar um atributo que tenha um anota��o 
		 * atraves do metodo classe.getDeclaredFields()
		 */
		for (Field field : classe.getDeclaredFields()) {
			/*
			 * Atraves do metodo isAnnotationPresent passando como parametro a nossa anota��o 
			 * verificamos se a anota��o est� presente no atributo do indice atual.
			 * */
			if (field.isAnnotationPresent(IdadeMinima.class)) {
				/* 
				 * Atraves do metodo getAnnotation, passando como parametro a nossa anota��o
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
					 * atributo est� acess�vel, desta forma: field.setAccessible(true);
					 * 
					 * Eu deixo o atributo acessivel.
					 * */
					field.setAccessible(true);
					/*
					 * Para pegar o valor do atributo anotado com @IdadeMinima vamos usar
					 *  o m�todo get() da classe Field.
					 * */
					LocalDate dataNascimento = (LocalDate) field.get(objeto);
					/*
					 * Na compara��o iremos usar o m�todo between() que recebe como par�metro
					 * duas datas para serem comparadas, o m�todo now() para obtermos a data
					 * atual e o m�todo getYears() para conseguirmos saber o valor do per�odo
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
