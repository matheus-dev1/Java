import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SwingIMC {
	public SwingIMC() {
	}
	public static void main(String[] args) {
		JFrame tela = new JFrame();

		JPanel P1 = new JPanel();
		JPanel P2 = new JPanel();
		JPanel P3 = new JPanel();
		JPanel P4 = new JPanel();

		JTextField T1 = new JTextField(8);
		JTextField T3 = new JTextField(8);
		JTextField T4 = new JTextField(8);

		JButton B1 = new JButton("Calcular");
		//Dentro do parametro do metodo add() eu estou instanciando uma labal que basicamente eh um titulo em cima de cada campo de texto.
		P1.add(new JLabel ("Altura: "));
		P1.add(T1);
		P3.add(new JLabel ("Peso: "));
		P3.add(T3);
		P4.add(new JLabel ("IMC: "));
		P4.add(T4);

		tela.setLayout(new FlowLayout());

		P1.setLayout(new FlowLayout());

		tela.setSize(400,400);

		CalcIMC CalcIMCClass = new CalcIMC();

		B1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// A classe Double possui um metodo chamado parseDouble que faz com que o valor do parametro dentro de parseInt seja do tipo Double.
				CalcIMCClass.setAltura(Double.parseDouble(T1.getText()));
				CalcIMCClass.setPeso(Double.parseDouble(T3.getText()));
				T4.setText(String.valueOf(CalcIMCClass.Calcular()));
			}
		});

		tela.add(P1);
		tela.add(P2);
		tela.add(P3);
		tela.add(B1);
		tela.add(P4);
		tela.setVisible(true);
	}
}
