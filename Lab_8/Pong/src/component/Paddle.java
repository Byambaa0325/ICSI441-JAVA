package component;

import screen.Screen;
import utility.Vector;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Paddle of the game
 * @author User
 *
 */
public class Paddle implements Component, KeyListener {

	/**
	 * Width of the paddle
	 */
	private int width;
	
	/**
	 * Height of the paddle
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
	 * Screen for the component
	 */
	private Screen screen;
	
	/**
	 * Current velocity of the paddle
	 */
	private Vector velocity;
	
	/**
	 * Current velocity of the paddle
	 */
	private Vector acceleration;
	
	/**
	 * Thread for the game loop
	 */
	Thread runner;
	
	/**
	 * Status of the thread
	 */
	private boolean active = true;
	
	/**
	 * Constructor of the paddle by width and height
	 * @param width
	 * @param height
	 */
	public Paddle(int width, int height){
		this.width = width;
		this.height = height;
	}

	/**
	 * Initiates the paddle at location (x,y) on Screen (screen)
	 */
	@Override
	public void init(int x, int y, Screen screen) {
		this.x = x;
		this.y = y;
		this.screen = screen;
		/**
		 * No initial acceleration
		 */
		this.acceleration = new Vector(0,0);
		
		/**
		 * No initial velocity
		 */
		this.velocity = new Vector(0, 0);
		
		/**
		 * Add keyListener to the game containing the screen
		 */
		screen.getGame().addKeyListener(this);
		
		/**
		 * Start the game loop after initiation
		 */
		runner = new Thread(this);
		runner.start();		
	}
	/**
	 * Draw rectangle (width, height) at location (x,y) 
	 */
	@Override
	public void paint(Graphics g) {
		g.drawRect(this.x, this.y, this.width, this.height);
	}
	
	/**
	 * Stop the game loop
	 */
	public void stop() {
		active = false;
	}

	@Override
	public void run() {
		/**
		 * Runs screen.FPS times each second while component is active
		 */
		while(active ) {
			/**
			 * Apply acceleration to the velocity and reset acceleration
			 */
			this.velocity.x += this.acceleration.x;
			this.velocity.y += this.acceleration.y;
			this.acceleration.x = 0;
			this.acceleration.y = 0;
			
			/**
			 * Limit the paddle movement
			 */
			if( x + velocity.x + width >= screen.getWidth() || x + velocity.x < 0) {
				velocity.x = 0;
			}
			
			/**
			 * Apple velocity to the current location x
			 */
			this.x += this.velocity.x;
			this.y += this.velocity.y;
			/**
			 * Apply resistant force 
			 */			
			this.velocity.x *= 0.8;	
			this.velocity.y *= 0.8;
			
			/**
			 * Stop the ball once its super slow
			 */
			if(Math.abs(this.velocity.x) < 1) {
				this.velocity.x = 0;
			}
			
			/**
			 * Sleep the loop to avoid overload
			 */
			try {
				Thread.sleep(screen.getDelay());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public Vector getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector velocity) {
		this.velocity = velocity;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		/**
		 * Key listener for control
		 */
		switch(e.getKeyChar()) {
		/**
		 * d for right
		 */
			case 'd':
				this.acceleration.x +=10;
				break;
		/**
		 * a for left
		 */
			case 'a':
				this.acceleration.x -=10;
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

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
