import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//JButton representa um botão destinado a executar uma ação. Entre os principais métodos temos o setText(String) que altera o texto do botão e setIcon(Icon) que altera o ícone do botão.
import javax.swing.JButton;
//JCheckBox representa uma caixa de seleção e permite selecionar ou não uma opção. Entre os principais métodos temos o setSelected(boolean) que altera o estado da caixa de seleção e o método isSelected() que retorna true se a caixa estiver marcada e false se não estiver marcada.
import javax.swing.JComboBox;
//JFrame representa a janela do programa com barra de título, ícone, botões de comando, etc. Entre os principais métodos temos o pack() que compacta a janela para o tamanho dos componentes, setSize(int, int) que define a largura e altura da janela, setLocation(int, int) que define a posição da janela na tela (x,y), setBounds(int, int, int, int) que define posição e tamanho, setVisible(boolean) que exibe a janela e setDefaultCloseOperation(int) que define o que ocorre quando o usuário tenta fechar a janela (as opções são: DO_NOTHING_ON_CLOSE, HIDE_ON_CLOSE, DISPOSE_ON_CLOSE, EXIT_ON_CLOSE).
//Modulo Jframe vindo do Javax -> Swing -> e pegando o JFrame que basicamente eh a tela deste arquivo.
import javax.swing.JFrame;
//JPanel representa um tipo básico de container para inserção de componentes. Entre os principais métodos temos add(Component, int) que adiciona o componente definindo sua posição e setLayout(LayoutManagaer) que altera o tipo de layout.
import javax.swing.JPanel;
//JTextField representa um campo de texto onde o usuário pode informar um texto em uma linha. Entre os principais métodos temos setText(String) que altera o texto e getText() que retorna o texto atual.
import javax.swing.JTextField;

public class Menu {
	public static void main(String[] args) {
		//Aqui nos estamos instanciando a classe JFrame da tela deste arquivo e estamos o nomeando como "tela";.
		JFrame tela = new JFrame();
		//O JPanel e uma classe que representa um tipo contianer para insercao de componentes. Por exemplo uma lista() de itens.
		JPanel P1 = new JPanel();
		//Aqui nos estamos instanciando a classe JComboBox que eh usada para criar caixas de selecao.
		JComboBox <String> lista = new JComboBox <String>();
		//O JTextField e basicamente um campo de texto e no parametro eu coloco que quero apenas 8 caracteres.
		JTextField T1 = new JTextField(8);
		//Estamos instanciando o JButton que eh usada para criar um botao.
		JButton B1 = new JButton("Confirmar!");

		//Instanciando as minhas classes
		SwingQuadrado exercicioSwingQuadrado = new SwingQuadrado();
		SwingPerimetro exercicioSwingPerimetro = new SwingPerimetro();
		SwingIMC exercicioSwingIMC = new SwingIMC();

		//Altera o tipo do layout da tela.
		tela.setLayout(new FlowLayout());
		//Dentro da classe JFrame nos temos o metodo setSize que define um tamanho para a nossa "tela".
		tela.setSize(400,400);
		//O metodo add da classe JFrame adiciona o componente como parametro na tela.
		// Adiciona na tela o container verde.
		tela.add(P1);
		//Adiciona na tela o botao de confirmar.
		tela.add(B1);
		//Adiciona na tela o campo de texto.
		tela.add(T1);
		//Configura a tela para estar visivel.
		tela.setVisible(true);

		//A classe JPanel possui um metodo chamado setBounds que define o tamanho do container.
		P1.setBounds(80,160,300,300);
		//O setBackground vai definir uma cor para o container.
        P1.setBackground(Color.GREEN);
		//O metodo add da classe JFrame adiciona o componente como parametro na tela.
		P1.add(lista);
		//Altera o tipo do layout do container.
		P1.setLayout(new FlowLayout());

		//O metodo addItem da classe JComboBox cria um item na caixa de selecao.
		lista.addItem("exercicioSwingQuadrado");
		lista.addItem("exercicioSwingPerimetro");
		lista.addItem("exercicioSwingIMC");

		B1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//O metodo getSelectedItem retornar o valor do item selecionado.
				if(lista.getSelectedItem() == "exercicioSwingQuadrado"){
					//O metodo setText da classe JTExtField coloca um determinado texto em um determinado campo de texto.
					T1.setText(exercicioSwingQuadrado.toString());
					//o metodo toString() da instancia de um classe retorna o nome da classe @ o hash Code da classe.
					System.out.print(exercicioSwingQuadrado.toString());
				}
				if(lista.getSelectedItem() == "exercicioSwingPerimetro"){
					T1.setText(exercicioSwingPerimetro.toString());
					System.out.print(exercicioSwingPerimetro.toString());
				}
				if(lista.getSelectedItem() == "exercicioSwingIMC"){
					T1.setText(exercicioSwingIMC.toString());
					System.out.print(exercicioSwingIMC.toString());
				}
			}
		});
	}
}
