import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SwingPerimetro {
	public SwingPerimetro() {
	}
	public static void main(String[] args) {
		JFrame tela = new JFrame();

		JPanel P1 = new JPanel();
		JPanel P2 = new JPanel();

		JTextField T1 = new JTextField(8);
		JTextField T2 = new JTextField(8);

		JButton B1 = new JButton("Calcular");

		P1.add(new JLabel ("Lado: "));
		P1.add(T1);
		P2.add(new JLabel ("Resultado "));
		P2.add(T2);

		tela.setLayout(new FlowLayout());
		P1.setLayout(new FlowLayout());

		tela.setSize(400,400);

		PerQuadr PerQuadrClass = new PerQuadr();

		B1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// A classe Interger possui um metodo chamado parseInt que faz com que o valor do parametro dentro de parseInt seja do tipo inteiro.
				PerQuadrClass.setLado(Integer.parseInt(T1.getText()));
				PerQuadrClass.calcular();
				// A classe String possui um metodo chamado valueOf que recebe um pametro com que faz que ele seja tranformado em uma string.
				T2.setText(String.valueOf(PerQuadrClass.getResultado()));
			}
		});

		tela.add(P1);
		tela.add(B1);
		tela.add(P2);
		tela.setVisible(true);
	}
}