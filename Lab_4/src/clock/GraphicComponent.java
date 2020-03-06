package clock;
import java.awt.Graphics;

public interface GraphicComponent {
	/*
	 * Method to display the Graphic Component with Graphics g
	 */
	public void draw(Graphics g);
	/*
	 * Any type of update or step in the component
	 */
	public void step();
}
