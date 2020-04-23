package component;

import screen.Screen;
import utility.Vector;

import java.awt.*;

/**
 * Brick of the game
 * @author User
 *
 */
public class Brick implements Component {

	/**
	 * Width of the brick
	 */
	private int width;
	
	/**
	 * Height of the brick
	 */
	private int height;
	
	/**
	 * x-coordinate of the component
	 */
	private int x;
	
	/**
	 * y-coordinate of the component
	 */
	private int y;
	
	/**
	 * Screen of the component
	 */
	@SuppressWarnings("unused")
	private Screen screen;
	
	/**
	 * Velocity of the brick
	 */
	@SuppressWarnings("unused")
	private Vector velocity;
	
	/**
	 * Acceleration of the brick
	 */
	@SuppressWarnings("unused")
	private Vector acceleration;
	
	/**
	 * Status of the component
	 */
	private boolean active = true;

	/**
	 * Constructor of the brick by width and height
	 * @param width
	 * @param height
	 */
	public Brick(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	public void stop() {
		active = false;
	}

	/**
	 * Initiate a brick on location (x,y) on Screen (screen)
	 */
	@Override
	public void init(int x, int y, Screen screen) {
		this.x = x;
		this.y = y;
		this.screen = screen;
		this.acceleration = new Vector(0,0);
		this.velocity = new Vector(0, 0);
	}

	/**
	 * Display the brick
	 */
	@Override
	public void paint(Graphics g) {
		g.drawRect(this.x, this.y, this.width, this.height);
	}

	/**
	 * No game loop for the brick 
	 */
	@Override
	public void run() {
		while(active) {
			
		}
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
