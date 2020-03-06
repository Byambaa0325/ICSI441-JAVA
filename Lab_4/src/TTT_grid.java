import java.applet.Applet;
import java.awt.Graphics;

public class TTT_grid extends Applet {
	public void paint(Graphics g) {
		//Vertical lines
		g.drawLine((int)(this.getWidth()*0.33), 0, (int)(this.getWidth()*0.33), this.getHeight());
		g.drawLine((int)(this.getWidth()*0.67), 0, (int)(this.getWidth()*0.67), this.getHeight());
		//Horizontal lines
		g.drawLine(0, (int)(this.getHeight()*0.33), this.getWidth(), (int)(this.getHeight()*0.33));
		g.drawLine(0, (int)(this.getHeight()*0.67), this.getWidth(), (int)(this.getHeight()*0.67));
	}
}
