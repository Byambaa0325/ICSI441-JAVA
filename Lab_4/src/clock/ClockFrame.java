package clock;
import java.applet.Applet;
import java.awt.Graphics;

public class ClockFrame implements GraphicComponent {

	private Applet screen;
	public ClockFrame(Applet clock) {
		this.screen = clock;
	}

	@Override
	public void draw(Graphics g) {
		g.drawOval(0, 0, screen.getWidth(), screen.getHeight());
	}

	@Override
	public void step() {}

}
