import java.applet.Applet;
import java.awt.Graphics;

public class DrawCircle extends Applet {
	
	public void paint(Graphics g) {
		g.fillOval(this.getWidth()/2-15, this.getHeight()/2-15, 30, 30);
	}
}
