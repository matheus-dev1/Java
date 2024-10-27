package br.com.matheus.spring.learning.matheuslearningjava18spring3.exceptions.handlers;

import br.com.matheus.spring.learning.matheuslearningjava18spring3.exceptions.ExceptionResponse;
import br.com.matheus.spring.learning.matheuslearningjava18spring3.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

/* *
 * De acordo com a própria documentação do Spring, o @ControllerAdvice é uma especialização da anotação
 * @Component, que permite manipular exceções em todo o aplicativo em um componente global.
 */
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    /* *
     * O termo "handler" em programação refere-se a uma função ou bloco de código que gerencia ou responde a eventos específicos.
     * Exemplo esta Exception
     */

    /*
    * Compilar automaticamente depois de salvar o arquivo eh configurado na IDE Intellij */
    @ExceptionHandler(Exception.class)
    private ResponseEntity<Exception> handleAllExceptions (
            Exception exception,
            WebRequest webRequest
    ) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                exception.getMessage(),
                webRequest.getDescription(false)
        );
        return new ResponseEntity<Exception>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // A desvantagem dessa implementacao eh que se em outro lugar do meu codigo retornar um status code BAD Request
    // Ele vai cair nesta mesma exception, mesmo que nao tenha nada a ver com o problema
    // Ou seja esse cara eh muito recomendado para pequenas aplicacoes ou temas unicos que possam utilizar 100% destas implementacoes
    @ExceptionHandler(ResourceNotFoundException.class)
    private ResponseEntity<Exception> handleNotFoundExceptions (
            Exception exception,
            WebRequest webRequest
    ) {
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(),
                exception.getMessage() + " " + "BAD REQUEST",
                webRequest.getDescription(false) + " - " + "Session ID: " + webRequest.getSessionId()
        );

        return new ResponseEntity<Exception>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

}