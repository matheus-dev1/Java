import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Fomulario2 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Button butOK;
		TextField campo1, campo2, resp;
		Label texto1, texto2;
		
		JFrame frame = new JFrame("Minha Segunda Aplicacaoo com Swing");

		texto1 = new Label("Nome: ");
		campo1 = new TextField(15);

		texto2 = new Label ("Fone: ");
		campo2 = new TextField(15);

		butOK = new Button ("OK");
		resp = new TextField(15);
		
		butOK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resp.setText(campo1.getText() + " " + campo2.getText());
			}
			});
		
		frame.setLayout(new GridLayout(3,2));
		frame.add(texto1);
		frame.add(campo1);
		frame.add(texto2);
		frame.add(campo2);
		frame.add(butOK);
		frame.add(resp);
		frame.pack();
		frame.show();
	}
}
