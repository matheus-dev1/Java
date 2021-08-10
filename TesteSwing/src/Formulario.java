import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formulario {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		JFrame frame = new JFrame("Minha segunda aplicacao com swing!");

		JButton button = new JButton("Clique aqui");

		JLabel texto = new JLabel("Numero de cliques no botao: 0");

		JPanel painel = new JPanel();

		painel.add(button);
		painel.add(texto);

		// A classe JFrame possui o método getContentPane() que permite a execução de diversas ações, como configuração do tipo de layout a ser utilizado ou adição de componentes à interface.
		frame.getContentPane().add(painel);

		frame.setSize(400,400);
		frame.pack();
		frame.show();

		button.addActionListener(new ActionListener() {
			int number = 0;
			@Override
			public void actionPerformed(ActionEvent e) {
				texto.setText("Numero de cliques no botao: " + String.valueOf(number = number + 1));
			}
		});
	}
}
