package unit1;
import java.awt.Graphics;
import java.applet.Applet;
@SuppressWarnings("serial")
public class sayHello extends Applet{
	public void paint(Graphics g){
		g.drawString("Hello Java!", 35, 30);
	}
}
