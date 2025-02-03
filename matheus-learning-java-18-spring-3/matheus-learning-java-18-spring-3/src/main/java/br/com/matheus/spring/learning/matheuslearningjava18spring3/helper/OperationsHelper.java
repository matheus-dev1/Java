package br.com.matheus.spring.learning.matheuslearningjava18spring3.helper;

import br.com.matheus.spring.learning.matheuslearningjava18spring3.enums.Operation;

import static br.com.matheus.spring.learning.matheuslearningjava18spring3.utils.MathUtils.convertToDouble;

public class OperationsHelper {
    // Switch Expression
    // Sintaxe mais curta: Com -> e sem break, o código fica mais legível.
    // Switch como expressão: Possibilidade de retornar diretamente valores a partir do switch.
    // Menos erros: O uso de break se torna desnecessário, eliminando erros de “fall-through” (quando o código continua para o próximo caso sem querer).
    public Double simpleOperation(String numberOne, String numberTwo, Operation op) {
        return switch (op) {
            case SUM -> {
                System.out.println("Sum");
                yield sum(numberOne, numberTwo); // "yield" é usado para retornar um valor específico
            }
            case SUB, SUBTRACTION -> subtract(numberOne, numberTwo); // mais de um possivel valor em um case
            case MULT, MULTIPLICATION -> multiply(numberOne, numberTwo);
            case DIV -> divide(numberOne, numberTwo);
            case AVG -> average(numberOne, numberTwo);
            case SQUARE_ROOT -> squareRoot(numberOne);
            default -> null;
        };
    }

    private Double sum(String numberOne, String numberTwo) {
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    private Double subtract(String numberOne, String numberTwo) {
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    private Double multiply(String numberOne, String numberTwo) {
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    private Double divide(String numberOne, String numberTwo) {
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    private Double average(String numberOne, String numberTwo) {
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }

    private Double squareRoot(String numberOne) {
        return Math.sqrt(convertToDouble(numberOne));
    }
}
