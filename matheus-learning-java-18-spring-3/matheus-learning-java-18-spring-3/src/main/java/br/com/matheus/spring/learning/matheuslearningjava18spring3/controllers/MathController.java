package br.com.matheus.spring.learning.matheuslearningjava18spring3.controllers;

import br.com.matheus.spring.learning.matheuslearningjava18spring3.enums.Operation;
import br.com.matheus.spring.learning.matheuslearningjava18spring3.helper.OperationsHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static br.com.matheus.spring.learning.matheuslearningjava18spring3.utils.MathUtils.numbersVerification;

/*
* Esta controller deve usar o PathVariable para receber dois valores, que sao dois numeros que devem ser somados
* e retornados para o front como Dougle
* Obs: Os valores podem ser Inteiros ou Floats, mas devem sempre retornar float
* E deve conseguir converter numeros flutuantes com virgula (,) em ponto (.)
*
* Outro ponto devemos programar tudo em INGLES, apenas os comentarios devem ser em portugues
* */

@RestController
public class MathController {

    OperationsHelper operationsHelper = new OperationsHelper();
    /*
     * @PathVariable e @PathParam ambos são usados para acessar parâmetros do template da URI
     * Diferencas
     * @PathVariable eh do Spring e @PathParam eh do JAX-RS
     * @PathParam pode apenas ser usado como REST
     * E @PathVariable eh usado no Spring então pode funciona como MVC ou REST
     * */
    @GetMapping("/sum/{numberOne}/{numberTwo}")
    private Double sum (
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
        ) throws Exception {

        numbersVerification(numberOne, numberTwo);

        return operationsHelper.simpleOperation(numberOne, numberTwo, Operation.SUM);
    }

    @GetMapping("/sub/{numberOne}/{numberTwo}")
    private Double sub(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws InstantiationException, IllegalAccessException {

        numbersVerification(numberOne, numberTwo);

        return operationsHelper.simpleOperation(numberOne, numberTwo, Operation.SUB);
    }

    @GetMapping("/mult/{numberOne}/{numberTwo}")
    private Double mult(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws InstantiationException, IllegalAccessException {

        numbersVerification(numberOne, numberTwo);

        return operationsHelper.simpleOperation(numberOne, numberTwo, Operation.MULT);
    }

    @GetMapping("div/{numberOne}/{numberTwo}")
    private Double div(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws InstantiationException, IllegalAccessException {

        numbersVerification(numberOne, numberTwo);

        return operationsHelper.simpleOperation(numberOne, numberTwo, Operation.DIV);
    }

    @GetMapping("avg/{numberOne}/{numberTwo}")
    private Double avg(
            @PathVariable(value = "numberOne") String numberOne,
            @PathVariable(value = "numberTwo") String numberTwo
    ) throws InstantiationException, IllegalAccessException {

        numbersVerification(numberOne, numberTwo);

        return operationsHelper.simpleOperation(numberOne, numberTwo, Operation.AVG);
    }

    @GetMapping("square_root/{numberOne}")
    private Double squareRoot(
            @PathVariable(value = "numberOne") String numberOne
    ) throws InstantiationException, IllegalAccessException {

        numbersVerification(numberOne, "0");

        return operationsHelper.simpleOperation(numberOne, "0", Operation.SQUARE_ROOT);
    }
}
