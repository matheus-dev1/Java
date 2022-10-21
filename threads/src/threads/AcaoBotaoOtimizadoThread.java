package threads;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

// Aqui não bloqueia o metodo main, quando calculo muito grande.
// Aqui como eu criei outro thread, o que foi executado no main, a parte da interface
// ainda continua operacional, isso porque eu tem outra atividade pra fazer a multiplicação.
public class AcaoBotaoOtimizadoThread implements ActionListener {

    private JTextField primeiro;
    private JTextField segundo;
    private JLabel resultado;

    public AcaoBotaoOtimizadoThread(JTextField primeiro, JTextField segundo, JLabel resultado) {
        this.primeiro = primeiro;
        this.segundo = segundo;
        this.resultado = resultado;
    }

    // Metodo que executa a ação do listener.
    @Override
    public void actionPerformed(ActionEvent e) {
    	
    	TarefaMutiplicarThread tarefaMutiplicarThread = new TarefaMutiplicarThread(primeiro, segundo, resultado);
    	
    	// Classe thread, ela tem um construtor que recebe uma classe Runable
    	Thread thread = new Thread(tarefaMutiplicarThread, "TarefaMultiplicarThread");
    	// Inicia a execução do metodo run();
    	thread.start();
    }
}
