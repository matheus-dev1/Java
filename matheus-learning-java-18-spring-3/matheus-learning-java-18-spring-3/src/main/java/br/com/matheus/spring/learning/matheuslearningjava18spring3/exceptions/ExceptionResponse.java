package br.com.matheus.spring.learning.matheuslearningjava18spring3.exceptions;

import java.io.Serializable;
import java.util.Date;

/* *
 * A serialização significa salvar o estado atual dos objetos em arquivos em formato binário para o seu computador,
 * sendo assim esse estado poderá ser recuperado posteriormente recriando o objeto em memória assim como
 * ele estava no momento da sua serialização.
 */
public class ExceptionResponse extends Exception implements Serializable {

    private static final long serialVersionUID = 1L;
    /*
    * * * final em Classes
    * Uma classe com este modificador não pode ser estendida, isto é, não pode ter classes que herdam dela.
    * Isso é importante para garantir que uma determinada implementação não tenha seu comportamento modificado.
    * Isso tem muito a ver com a imutabilidade.
    *
    * * * Final em métodos
    * Imagine uma classe onde eu afirmo algo do tipo “Keep programming until die”, considerando isto uma filosofia
    * pessoal eu não permito que alguém ouse modificar tal constatação.
    *
    * Exemplo:
    * class Programmer {
    *     final void code() {
    *         System.out.println("Keep programming until die");
    *     }
    *
    * class Developer extends Progammer {
    *       // Vai dar erro porque eu nao posso sobreescrever um metodo do tipo final
    *       @Override
    *       final code() {
    *       }
    * }
    * Qualquer método final não pode ter seu comportamento sobrescrito
    * A classe Developer herda a classe Programmer pois ambos devem ter acesso ao método final code( ).
    * Quando tento sobrescrever seu comportamento o compilador não permite.
    *
    * * * Final em Variáveis
    *
    * Toda variavel com final nao pode ser alterada, ou seja, uma vez atribuido um valor nao pode mudar
    *
    * Voce so pode atribuir um valor a uma variavel com o modificador final na sua propria declaracao
    * Ou no construtor, em nenhum outro caso isso pode ocorrer
    *
    * * * Final em parâmetros/argumentos
    *
    * Uma vez que que o metodo eh chamado e passado um valor para o atributo, ele nao pode ser alterado novamente dentro
    * do escopo do metodo
    *
    * Exemplo:
    *
    * final class Programmer {
    *   final String code(final String langague) {
    *       // Vai dar erro nesta linha de atribuicao porque o parametro final nao pode ser modificado no escopo do metodo
    *       langague = "code";
    *       return = "i love " + langague;
    *   }
    * }
    * */
    private Date timestemp;
    private String message;
    private String details;

    public ExceptionResponse(Date timestemp, String message, String details) {
        this.timestemp = timestemp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestemp() {
        return this.timestemp;
    }

    public String getMessage() {
        return this.message;
    }

    public String getDetails() {
        return this.details;
    }
}
