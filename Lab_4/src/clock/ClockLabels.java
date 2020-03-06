package clock;
import java.applet.Applet;
import java.awt.Graphics;

public class ClockLabels implements GraphicComponent {

	private Applet screen;

	public ClockLabels(Applet clock) {
		this.screen = clock;
	}

	@Override
	public void draw(Graphics g) {
		// TODO place 1-12 through the screen

	}

	@Override
	public void step() {}

}
