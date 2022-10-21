import java.applet.*;
import java.awt.*;

@SuppressWarnings("deprecation")
public class Exemplo extends Applet{
	
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int x,y,tam;

 public void init( ){
    x = 10;
    y = 10;
    tam = 0;
  }
 
 public void start( ){
    tam += 5;
  }
 
 public void paint(Graphics g){
    g.setColor(new Color(200,123,212));
    g.fillRect(x,y,tam,10);
  }
 
 public void stop(){
 }
 
}
