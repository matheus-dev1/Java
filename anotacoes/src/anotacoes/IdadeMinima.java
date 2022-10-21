package anotacoes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Retention - Aqui n�s falaremos para a nossa aplica��o at� quando nossa anota��o estar� dispon�vel.
 * @Target - Aqui passaremos os elementos que podem ser anotados com essa anota��o.
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface IdadeMinima {
	//Propriedade/Atributo
	public int valor();
}
