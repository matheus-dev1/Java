package threads;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaCalculador {

    public static void main(String[] args) {

        JFrame janela = new JFrame("Multiplicação Demorada");

        JTextField primeiro = new JTextField(10);
        JTextField segundo = new JTextField(10);
        JButton botao = new JButton(" = ");
        JLabel resultado = new JLabel("           ?          ");

        /* Quando clica no botão será executado a classe AcaoBotao, que faz a 
         * execução da multiplicação.
         * 
         * A classe AcaoBotao tem que implementar uma interace chamada ActionListener
         * e implementar o metodo actionPerformed, que é a execução da multiplicação em si*/
        botao.addActionListener(new AcaoBotaoOtimizadoThread(primeiro, segundo, resultado));

        JPanel painel = new JPanel();
        painel.add(primeiro);
        painel.add(new JLabel("x"));
        painel.add(segundo);
        painel.add(botao);
        painel.add(resultado);

        janela.add(painel);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.pack();
        janela.setVisible(true);
    }
}