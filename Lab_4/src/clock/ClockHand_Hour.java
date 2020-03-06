package clock;
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class ClockHand_Hour implements GraphicComponent {

	private Applet screen;
	private CurrentTime time;
	private Point start;
	private Point end;
	private int radius;
	private double angle;

	public ClockHand_Hour(Applet clock, CurrentTime timeFetcher) {
		this.screen = clock;
		this.time = timeFetcher;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(Color.black);
		//Draw a line from center with vector end
		g.drawLine(start.getIntX(), start.getIntY(), start.getIntX()+end.getIntX(), start.getIntX()+end.getIntY());
	}

	@Override
	public void step() {
		//Take starting point as center of the screen
		start = new Point(screen.getWidth()/2, screen.getHeight()/2);
		//Set radius; hour is shorter
		radius = Math.min(screen.getWidth()/2, screen.getHeight()/2)/3;
		//Calculate angle based on proportion of hours to proportion of angle converted to radians
		angle = ((time.getTime().getHours()%12/12.0)*2*Math.PI); //in radians
		//Rotate the point with angle and flip
		end = new Point((Math.sin(angle)*radius), (-Math.cos(angle)*radius));
	}

}
