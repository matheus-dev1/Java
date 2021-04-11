import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SwingQuadrado {
	public SwingQuadrado(){
	}
	public static void main(String[] args) {
		JFrame tela = new JFrame();

		JPanel P1 = new JPanel();
		JPanel P2 = new JPanel();

		JTextField T1 = new JTextField(8);
		JTextField T2 = new JTextField(8);

		JButton B1 = new JButton("Calcular");

		P1.add(new JLabel ("Numero: "));
		P1.add(T1);
		P2.add(new JLabel ("Resultado "));
		P2.add(T2);

		tela.setLayout(new FlowLayout());
		P1.setLayout(new FlowLayout());

		tela.setSize(400,400);

		ValorQuadr ValorQuadrClass = new ValorQuadr();
		
		B1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ValorQuadrClass.setValor(Integer.parseInt(T1.getText()));
				ValorQuadrClass.calcular();
				T2.setText(String.valueOf(ValorQuadrClass.getResultado()));
			}
		});

		tela.add(P1);
		tela.add(B1);
		tela.add(P2);
		tela.setVisible(true);
	}
}
