import java.applet.Applet;
import java.awt.*;

// Exibe um ditado de Confucio 
// do livro: Java Software Solutions:J. Lewis e W. Loftus

@SuppressWarnings("deprecation")
public class Confucio extends Applet{
	
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void paint(Graphics pagina){
  pagina.drawString("Esque�a desaforos, nunca esque�a gentilezas.", 30,30);
  pagina.drawString("----Conf�cio", 70,70);
 }
 
}
