package component;

import screen.Screen;
import utility.Vector;

import java.awt.*;

/**
 * Ball of the pong game
 * @author User
 *
 */
public class Ball implements Component {

	/**
	 * Radius of the ball
	 */
	private int radius;
	
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
	 * Current velocity of the ball 
	 */
	private Vector velocity;
	
	/**
	 * Acceleration of the ball
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
	 * Constructor of the ball
	 * @param radius Radius of the ball
	 */
	public Ball(int radius){
		this.radius = radius;
	}
	
	/**
	 * Initiates the ball at location (x,y) on Screen (screen)
	 */
	@Override
	public void init(int x, int y, Screen screen) {
		this.x = x;
		this.y = y;
		this.screen = screen;
		
		/**
		 * Set acceleration to gradually increase as game goes on
		 */
		this.acceleration = new Vector(0.0001 ,0.0001);
		
		/**
		 * Set initial velocity
		 */
		this.velocity = new Vector(2, 2);
		
		/**
		 * Start the game loop after initiation
		 */
		runner = new Thread(this);
		runner.start();
	}

	/**
	 * Draw black oval for the ball at location(x,y) with diameters(radius*2)
	 */
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillOval(this.x, this.y, this.radius*2, this.radius*2);
	}
	
	/**
	 * Stop the game loop
	 */
	public void stop() {
		active = false;
	}

	/**
	 * Game loop of the ball
	 */
	@Override
	public void run() {
		/**
		 * Runs screen.FPS times each second while component is active
		 */
		while (active) {
			/**
			 * Apply acceleration to the absolute value of the velocity
			 */
			velocity.x += (Math.abs(velocity.x)/velocity.x)*acceleration.x;
			velocity.y += (Math.abs(velocity.y)/velocity.y)*acceleration.y;
			
			/**
			 * Prevent the ball from stopping by clamping the values to 1 as min
			 */
			velocity.x = (Math.abs(velocity.x)/velocity.x) * Math.max(Math.abs(velocity.x), 1);
			velocity.y = (Math.abs(velocity.y)/velocity.y) * Math.max(Math.abs(velocity.y), 1);
			
			/**
			 * Ball hits the screen change direction
			 */
			if (x + velocity.x < 0 || x + radius*2 + velocity.x > screen.getWidth()) {
                velocity.x *= -1;
            }
            if (y + velocity.y < 0 || y + radius*2 + velocity.y > screen.getHeight()) {
                velocity.y *= -1;
            }            
            
            /**
             * Apply velocity to the current location
             */
			this.x += this.velocity.x;
			this.y += this.velocity.y;
			
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
	/**
	 * Change the y-axis velocity direction 
	 */
	public void flipVelocityY() {
		this.velocity.y *= -1; 
	}
	
	public Vector getVelocity() {
		return velocity;
	}
	public void setVelocity(Vector velocity) {
		this.velocity = velocity;
	}
	public int getRadius() {
		return radius;
	}
	
	public void setRadius(int radius) {
		this.radius = radius;
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
