package threads;

import java.math.BigInteger;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class TarefaMutiplicarThread implements Runnable {
	
    private JTextField primeiro;
    private JTextField segundo;
    private JLabel resultado;

	public TarefaMutiplicarThread(JTextField primeiro, JTextField segundo, JLabel resultado) {
        this.primeiro = primeiro;
        this.segundo = segundo;
        this.resultado = resultado;
	}

	// Aqui eu defino o que o meu run() vai fazer, no caso a multiplicação em si.
	@Override
	public void run() {
        long valor1 = Long.parseLong(primeiro.getText());
        long valor2 = Long.parseLong(segundo.getText());
        BigInteger calculo = new BigInteger("0");

        for (int i = 0; i < valor1; i++) {
            for (int j = 0; j < valor2; j++) {
                calculo = calculo.add(new BigInteger("1"));
            }
        }

        resultado.setText(calculo.toString());
	}
	
}
