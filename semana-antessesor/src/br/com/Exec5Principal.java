package br.com;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Exec5Principal {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Dia da semana");
		JLabel Rotulo1 = new JLabel("Digite um numero de 1 ate 7: ");
		JTextField Valor1 = new JTextField();
		JButton btCalcular = new JButton("Calcular");
		JLabel Resultado = new JLabel("O resultado");

		frame.setLayout(new GridLayout(3, 2));
		frame.add(Rotulo1);
		frame.add(Valor1);
		frame.add(btCalcular);
		frame.add(Resultado);
		frame.pack();
		frame.setSize(400, 400);
		frame.setVisible(true);

		Exec5 Exec5Class = new Exec5();

		btCalcular.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Neste caso eu estou pegando a instancia da classe e passando a propria varaivel para receber o valor do campo "Valor1"
				Exec5Class.dia = Valor1.getText();

				if(Exec5Class.Verificar() != "0") {
					//Define um backgroud para este componente.
					Resultado.setForeground(Color.black);
					Resultado.setText(Exec5Class.Verificar());
				} else {		
					Resultado.setForeground(Color.red);
					Resultado.setText("Erro de digitacao!");
					JOptionPane.showMessageDialog(
						frame,
						"Digite um valor valido no campo",
						"Erro de validacao",
						JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
