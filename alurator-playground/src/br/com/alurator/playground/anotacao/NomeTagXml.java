package br.com.alurator.playground.anotacao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Anota��es s�o interfaces especiais, ela por baixo dos panos � um sub-interface da interface Annotation do pacote java.lang.annotation
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE})
public @interface NomeTagXml {
	// Por conven��o, e eu colocar "value" e ele for o unico atributo, eu n�o preciso colocar propriedade=atributo, apenas colocar o valor do atributo.
	public String value();
}
