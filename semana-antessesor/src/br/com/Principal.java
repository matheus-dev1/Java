package br.com;
import javax.swing.*;

public class Principal {
public static void main(String[] args) {
    // Instancia da classe Gui
    GUI gui = new GUI();

    // Executando o metodo darOi();
    gui.darOi();

    // Executo o metodo pedirLado() e armazeno em valor.
    double valor = gui.pedirLado();

    // Instancio a clase Quadrado passando como parametro valor.
    Quadrado quadrado = new Quadrado(valor);

    // Vou pegar o resultado de calcularArea() e calcularPerimetro() e passar como parametro para mostrarResultado()
    gui.mostrarResultado(quadrado.calcularArea(), quadrado.calcularPerimetro());

    // Exibe uma mensagem e finaliza o programa.
    gui.darTchau();
    }
}

class Quadrado {
    private double lado;

    // E ao instanciar a classe este construtor pega o valor do argumento e armazena em "lado" 
    public Quadrado(double valor) {
	    this.lado = valor;
    }
    //Ao executar calcularArea o lado ja possui um valor e vai me retornar a multiplicacao de lado * lado.
    public double calcularArea(){
        return lado * lado;
    }
    // Calcular perimetro vai ser lado * 4.
    public double calcularPerimetro() {
        return lado * 4;
    }
}

class GUI {
    public void darOi() {
        //São pequenas janelas – diálogos – que interagem com o usuário. Object message – A mensagem que será mostrada na tela. Normalmente é uma String, porém a mensagem será mostrada conforme seu tipo: Component – O componente será mostrado conforme seu padrão. Icon – Será mostrado a figura na tela como seu padrão.
        //1. O primeiro argumento determina qual Frame o dialogo vai exibir.
        //2. O segundo arugumento eh o texto no caixa de mensagem.
        //3. O terceiro argumento eh o titulo da caixa de mensagem.
        //4. O Ultimo e o tipo da mensagem.
        JOptionPane.showMessageDialog(
            null,
            "OI...",
            "Bem Vindo...",
            JOptionPane.QUESTION_MESSAGE
        );
    }
    public double pedirLado() {
        // A classe JOptionPane possui o metodo showInputDialog que me criar um input em um campo de dialgo, onde eu pposso definir titulo, nome da label do input e ele me retorna o valor do input.
        // Semelhante ao showMessageDialog()
	    double result = Double.parseDouble(
            JOptionPane.showInputDialog(
                null,
                "Lado do Quadrado",
                "Lado do Quadrado",
                JOptionPane.QUESTION_MESSAGE
            ));
        return result;
    }
    public void mostrarResultado(double area, double perimetro) {
        JOptionPane.showMessageDialog(
            null,
      		"ÁREA: " + area + 
            "\nPERÍMETRO: " + perimetro,
      		"Resultado",
      		JOptionPane.ERROR_MESSAGE);
    }
    public void darTchau() {
        JOptionPane.showMessageDialog(
            null,
            "Adeus...",
            "Obrigado...",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}