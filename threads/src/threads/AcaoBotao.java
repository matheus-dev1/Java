package threads;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigInteger;

import javax.swing.JLabel;
import javax.swing.JTextField;

// Aqui bloqueia o metodo main, quando calculo muito grande.
// Aqui, como eu n�o criei outra thread, eu vou usar a thread que o main criou para executar todas as tarefas.
public class AcaoBotao implements ActionListener {

    private JTextField primeiro;
    private JTextField segundo;
    private JLabel resultado;

    public AcaoBotao(JTextField primeiro, JTextField segundo, JLabel resultado) {
        this.primeiro = primeiro;
        this.segundo = segundo;
        this.resultado = resultado;
    }

    // Metodo que executa a a��o do listener.
    @Override
    public void actionPerformed(ActionEvent e) {
    	/* Essa � uma multiplica��o nada perfomatica que est� dentro, e ela
    	 *  est� dentro da thread do main, ou seja � a unica thread rodando e 
    	 *  quando fazemos um calculo muito grande, ele trava a aplica��o toda, 
    	 *  isso porque n�o tem uma outra thread(tarefa) especifica pra ele pra
    	 *  rodar apenas essa atividade e deixar o resto a aplica��o livre
    	 *  para ser executada.
    	 */
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
