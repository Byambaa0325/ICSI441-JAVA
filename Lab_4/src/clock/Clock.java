package clock;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;

/**
 * Analog clock simulation applet.
 * 
 * @author Byambaa Bayarmandakh
 *
 */
public class Clock extends Applet {
	private ArrayList<GraphicComponent> components = new ArrayList<>();
	private CurrentTime timeFetcher = CurrentTime.getInstance();

	/**
	 * Add every component in the initialization
	 */
	public void init() {
		// Clock frame circle component
		components.add(new ClockFrame(this));
		// Clock Numbers and other labels
		components.add(new ClockLabels(this));
		// Clock Hand components
		components.add(new ClockHand_Hour(this, timeFetcher));
		components.add(new ClockHand_Minute(this, timeFetcher));
		components.add(new ClockHand_Second(this, timeFetcher));
	}

	/**
	 * Method to play the animation
	 */
	public void paint(Graphics g) {
		// Remember the value of the last second
		int lastSecondValue = timeFetcher.getTime().getSeconds();
		// Play animation indefinitely
		while (true) {
			// If a second has passed.
			if (lastSecondValue != timeFetcher.getTime().getSeconds()) {
				//Re draw the background
				drawBackground(g);
				
				//Update and display every components
				for (GraphicComponent comp : components) {
					comp.step();
					comp.draw(g);
				}
				//Update the second
				lastSecondValue = timeFetcher.getTime().getSeconds();
			}
		}

	}

	private void drawBackground(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		g.setColor(Color.black);
	}
}
