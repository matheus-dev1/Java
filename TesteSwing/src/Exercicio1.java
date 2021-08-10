import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Exercicio1 {
	public static void main(String[] args) {
		JFrame Tela = new JFrame("Exercicio 1");

		JLabel Rotulo1 = new JLabel("Digite um numero: ");
		JTextField Valor1 = new JTextField ();

		JLabel Rotulo2 = new JLabel("Resultado");
		JTextField Valor2 = new JTextField();

		JButton btCalcular = new JButton("Calcular");
		
		Tela.setLayout(new GridLayout(3,2));
		Tela.add(Rotulo1);
		Tela.add(Valor1);
		Tela.add(Rotulo2);
		Tela.add(Valor2);
		Tela.add(btCalcular);
		Tela.pack();
		Tela.setSize(400, 400);
		Tela.setVisible(true);

		btCalcular.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int numero = Integer.parseInt(Valor1.getText());
				int resp = numero - 1;
				Valor2.setText(String.valueOf(resp));
			}
		});
	}
}