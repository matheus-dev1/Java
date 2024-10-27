package br.com.matheus.spring.learning.matheuslearningjava18spring3.exceptions.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ResponseEntityExceptionImpl {

    @ExceptionHandler(MissingPathVariableException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleMissingPathVariable(MissingPathVariableException ex) {
        String errorMessage = "Required path variable is missing: " + ex.getVariableName();
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
