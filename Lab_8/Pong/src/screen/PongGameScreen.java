package screen;

import Main.Game;
import component.Ball;
import component.Brick;
import component.Component;
import component.Paddle;
import utility.Vector;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Pong game screen of the game
 * @author User
 *
 */
public class PongGameScreen implements Screen {
	/**
	 * Game containing the screen
	 */
	public Game game;
	
	/**
	 * Components of the screen. Bricks are here
	 */
	ArrayList<Component> components;
	
	/**
	 * Ball of the game
	 */
	Ball ball;
	
	/**
	 * Paddle of the game
	 */
	Paddle paddle;
	
	/**
	 * Thread for the control
	 */
	Thread controllerThread;
	
	/**
	 * Frames per second to display
	 */
	private int FPS = 60;
	
	/**
	 * Delay on the tread according to FPS
	 */
	public int delay = 1000/FPS;

	/**
	 * Width of the screen
	 */
	private int width;

	/**
	 * Height of the screen
	 */
	private int height;

	/**
	 * Game loop status
	 */
	private boolean active = true;

	/**
	 * Constructor for the screen.
	 * @param game Game containing the screen
	 * @param width Width of the display
	 * @param height Height of the display
	 */
	public PongGameScreen(Game game, int width, int height) {
		this.game = game;
		this.width = width;
		this.height = height;
	}

	/**
	 * Initiate a fresh pong game
	 */
	@Override
	public void init() {
		/**
		 * New Components
		 */
		components = new ArrayList<>();
		
		//Boolean for alternating brick starting location
		boolean startNoGap = true;
		/**
		 * Spawn bricks
		 */
		for(int j = 100; j < 300; j += 20) {
			
			/**
			 * Starting position toggler
			 */
			int initialValue = 0;
			if(startNoGap) {
				startNoGap = false;
			}
			else {
				initialValue = 20;
				startNoGap = true;
			}
			
			/**
			 * Row generator
			 */
			for(int i = initialValue; i + 60 < width; i+=60) {
				Brick brick = new Brick(50,10);
				brick.init(i, j, this);
				addComponent(brick);
			}
		}
		
		/**
		 * Create a paddle
		 */
		paddle = new Paddle(150,20);
		paddle.init(100, 500, this);

		/**
		 * Create a ball
		 */
		ball = new Ball(10);
		ball.init(200, 300, this);
		
		/**
		 * Set game loop active
		 */
		active = true;
		
		/**
		 * Start the controller if its not initiated
		 */
		if(controllerThread == null) {
			controllerThread = new Thread(this);
			controllerThread.start();
		}		
	}

	/**
	 * Display every component inside the screen
	 */
	@Override
	public void paint(Graphics g) {
		for (Component component : components) {
			component.paint(g);
		}
		if (ball != null) {
			ball.paint(g);
		}
		if(paddle != null) {
			paddle.paint(g);
		}
	}

	/**
	 * Game loop
	 */
	@Override
	public void run() {
		/**
		 * While it is active
		 */
		while(active ) {
			/**
			 * Check if there is brick hits
			 */
			ArrayList<Component> toRemove = new ArrayList<>();
			for (Component component : components) {
				Brick brick = (Brick) component;
				if(ballCollidesWithBrick(brick)) {
					toRemove.add(component);
				}
			}
			
			/**
			 * Remove bricks that got hit if there is any
			 */
			if(toRemove.size() != 0) {
				for (Component component : toRemove) {
					removeComponent(component);
				}
				//Ball hit something now bounce
				ball.flipVelocityY();
			}
			
			/**
			 * Victory condition
			 */
			if(components.size() == 0 ) {
				game.setCurrentScreen(new VictoryGameScreen(game));
				this.stop();
			}
			
			/**
			 * Ball hits the paddle
			 */
			if(ballCollidesWithPaddle()) {
				/**
				 * Adjust ball velocity relative to paddle velocity
				 * If in the same direction increase horizontal speed
				 * else increase vertical speed
				 */
				Vector newVelocity = ball.getVelocity();
				if(paddle.getVelocity().x > 0 && ball.getVelocity().x > 0) {
					newVelocity.x *= 1.2;
					newVelocity.y *= 0.8;
				}
				else if(paddle.getVelocity().x > 0 && ball.getVelocity().x < 0) {
					newVelocity.y *= 1.2;
					newVelocity.x *= 0.8;
				}
				else if(paddle.getVelocity().x < 0 && ball.getVelocity().x < 0) {
					newVelocity.x *= 1.2;
					newVelocity.y *= 0.8;					
				}
				else if(paddle.getVelocity().x < 0 && ball.getVelocity().x > 0) {
					newVelocity.y *= 1.2;
					newVelocity.x *= 0.8;
				}
				ball.setVelocity(newVelocity);
				
				// Ball bounce
				ball.flipVelocityY();
			}
			
			/**
			 * Losing condition
			 */
			if(ball.getY() + ball.getRadius()*2 + ball.getVelocity().y >= getHeight()) {
				System.out.println("Game Over");
				this.stop();
				this.init();
			}
			
			try {
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Method to check Rectangle collision
	 * @param brick Brick to check
	 * @return Whether the ball is colliding with the brick
	 */
	private boolean ballCollidesWithBrick(Brick brick) {
		if (ball.getX() + ball.getRadius()*2 + ball.getVelocity().x >= brick.getX() &&
			    ball.getX() + ball.getVelocity().x <= brick.getX() + brick.getWidth() &&
			    ball.getY() + ball.getRadius()*2 + ball.getVelocity().y >= brick.getY() &&
			    ball.getY() + ball.getVelocity().y <= brick.getY() + brick.getHeight())
		{
			return true;
		}
		return false;
	}
	
	/**
	 * Method to check Rectangle collision
	 * @return Whether the ball is colliding with the paddle
	 */
	private boolean ballCollidesWithPaddle() {
		if (ball.getX() + ball.getRadius()*2 + ball.getVelocity().x >= paddle.getX() &&
			    ball.getX() + ball.getVelocity().x <= paddle.getX() + paddle.getWidth() &&
			    ball.getY() + ball.getRadius()*2 + ball.getVelocity().y >= paddle.getY() &&
				ball.getY() + ball.getVelocity().y <= paddle.getY() + paddle.getHeight())
		{
			return true;
		}
		return false;
	}

	@Override
	public Game getGame() {
		return game;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public int getDelay() {
		return delay;
	}

	@Override
	public void init(int x, int y, Screen screen) {
	}

	/**
	 * Unreference all components and stop game loops
	 */
	@Override
	public void stop() {
		for (Component component : components) {
			component.stop();
		}
		components = null;
		ball.stop();
		ball = null;
		paddle.stop();
		paddle = null;
		active = false;
	}

	@Override
	public void addComponent(Component component) {
		components.add(component);		
	}

	@Override
	public void removeComponent(Component component) {
		components.remove(component);		
	}

	@Override
	public ArrayList<Component> getComponents() {
		return components;
	}
}
