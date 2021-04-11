package br.com;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Exec1Principal {
	public static void main(String[] args) {
		//Se eu passar um valor na instancia do JFrame eu basicamente estou coloando um titulo do Frame.
		JFrame frame = new JFrame("Calcular antecessor");
		
		JLabel Rotulo1 = new JLabel("Digite um valor: ");
		JTextField Valor1 = new JTextField();
		
		JButton btCalcular = new JButton("Calcular");
		
		JLabel Rotulo2 = new JLabel("Resultado");
		JTextField Valor2 = new JTextField();
		
		// Eu estou instanciando o GridLayout como argumento do setLayout do frame deste arquivo.
		// Onde eu tenho duas linhas e tres colunas.
		frame.setLayout(new GridLayout(2, 4));

		frame.add(Rotulo1);
		frame.add(Valor1);
		frame.add(btCalcular);
		frame.add(Rotulo2);
		frame.add(Valor2);

		// pack() faz com que a janela seja ajustada para o tamanho preferido de todos os seus sub- componentes. Faz a mesma coisa, só que criando uma classe nova, definida por nós.
		frame.pack();

		frame.setSize(400,400);
		frame.setVisible(true);

		Exec1 Exec1Class = new Exec1();

		btCalcular.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				Exec1Class.numero = Integer.parseInt(Valor1.getText());				
				Valor2.setText(String.valueOf(Exec1Class.Calcular()));
			}
		});
	}
}
