package component;

import screen.Screen;

import java.awt.*;

/**
 * Graphic component for a game. Component runs a loop, 
 * constantly updating and displaying.
 * @author Byambaa
 *
 */
public interface Component extends Runnable {
	
	/**
	 * Initiate the component at location (x,y) of Screen (screen) and start running loop
	 * @param x
	 * @param y
	 * @param screen
	 */
	void init(int x, int y, Screen screen);
	
	/**
	 * Display the Component with Graphics g
	 * @param g
	 */
	void paint(Graphics g);
	
	/**
	 * Stop the the running loop of the component
	 */
	void stop();
}
