package br.com.matheus.spring.learning.matheuslearningjava18spring3.helper;

import br.com.matheus.spring.learning.matheuslearningjava18spring3.enums.Operation;

import static br.com.matheus.spring.learning.matheuslearningjava18spring3.utils.MathUtils.convertToDouble;

public class OperationsHelper {

    // TODO: Colocar cada operacao como um metodo
    public Double simpleOperation(String numberOne, String numberTwo, Operation op) {
        if (op.equals(Operation.SUM)) {
            return convertToDouble(numberOne) + convertToDouble(numberTwo);
        }
        if (op.equals(Operation.SUB)) {
            return convertToDouble(numberOne) - convertToDouble(numberTwo);
        }
        if (op.equals(Operation.MULT)) {
            return convertToDouble(numberOne) * convertToDouble(numberTwo);
        }
        if (op.equals(Operation.DIV)) {
            return convertToDouble(numberOne) / convertToDouble(numberTwo);
        }
        if (op.equals(Operation.AVG)) {
            return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
        }
        if (op.equals(Operation.SQUARE_ROOT)) {
            return Math.sqrt(convertToDouble(numberOne));
        }
        return null;
    }
}
