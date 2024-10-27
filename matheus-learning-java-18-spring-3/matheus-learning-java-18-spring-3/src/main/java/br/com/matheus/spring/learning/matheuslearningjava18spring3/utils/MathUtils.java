package br.com.matheus.spring.learning.matheuslearningjava18spring3.utils;

import br.com.matheus.spring.learning.matheuslearningjava18spring3.exceptions.ResourceNotFoundException;

public class MathUtils {

    public static void numbersVerification(final String numberOne, final String numberTwo) throws InstantiationException, IllegalAccessException {
        if (isNumeric(numberOne) || isNumeric(numberTwo))
            //throw new Exception("This is not a number!!!");
            throw new ResourceNotFoundException("Invalid Operation");
    }

    public static boolean isNumeric(String strNumber) throws InstantiationException, IllegalAccessException {
        if(strNumber == null) return true;

        /*
         * é um sinal negativo opcional;
         * é zero ou um número inteiro diferente de zero válido;
         * é a peça de fratura opcional;
         * */
        strNumber = strNumber.replaceAll(",", ".");

        return !strNumber.matches("^(-?)(0|([1-9][0-9]*))(\\.[0-9]+)?$");
    }

    public static Double convertToDouble(String strNumber) {
        if(strNumber == null) return 0D;

        strNumber = strNumber.replaceAll(",", ".");

        return Double.parseDouble(strNumber);
    }
}
