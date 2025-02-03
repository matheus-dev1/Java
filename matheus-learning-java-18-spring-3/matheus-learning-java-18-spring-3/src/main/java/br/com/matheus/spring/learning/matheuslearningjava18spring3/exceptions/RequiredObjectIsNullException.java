package br.com.matheus.spring.learning.matheuslearningjava18spring3.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequiredObjectIsNullException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RequiredObjectIsNullException(String exceptionMessage) {
        super(exceptionMessage);
    }

    public RequiredObjectIsNullException() {
        super("It is no possible to persists a null object.");
    }
}