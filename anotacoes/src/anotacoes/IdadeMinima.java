package anotacoes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Retention - Aqui nós falaremos para a nossa aplicação até quando nossa anotação estará disponível.
 * @Target - Aqui passaremos os elementos que podem ser anotados com essa anotação.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface IdadeMinima {
	//Propriedade/Atributo
	public int valor();
}
