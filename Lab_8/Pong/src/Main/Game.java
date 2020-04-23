package Main;

import screen.DefaultGameScreen;
import screen.Screen;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Game extends Frame implements Runnable{
	
	private static final long serialVersionUID = -6894970809181119041L;
	/**
	 * Current screen displayed and played
	 */
	Screen currentScreen = new DefaultGameScreen(this, 600,600);
	
	/**
	 * Thread for the game loop
	 */
	private Thread updateThread = null;

	public static void main(String[] args){
		Game game = new Game();
		game.init(); 	
	}

	/**
	 * Initiate the game and start game loops
	 */
	public void init(){
		addWindowListener(new WindowAdapter(){  
            public void windowClosing(WindowEvent e) {  
                dispose();  
            }  
        });  
		setSize(600,600);
		setVisible(true);
		currentScreen.init();
		if ( updateThread == null ) {  
            updateThread = new Thread(this);  
            updateThread.start( );  
        }
	}

	/**
	 * Display the current screen
	 */
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		currentScreen.paint(g);
	}

	public Screen getCurrentScreen() {
		return currentScreen;
	}

	public void setCurrentScreen(Screen currentScreen) {
		this.currentScreen = currentScreen;
	}

	@Override
	public void run() {
		/**
		 * While game is running
		 */
		while ( updateThread != null ) {
			//Redisplay the frame
			this.repaint();	
			
			//Somehow makes flickering a lil better
			getToolkit().sync();
			
			try {
				Thread.sleep(currentScreen.getDelay());
			} catch (InterruptedException e) {
				System.out.println("Game exiting");
			}
		}
	}

    public void stop( ) {  
        if ( updateThread != null ) {  
            Thread runner = updateThread;
            updateThread = null;  
            runner.interrupt( );   
        }  
    }  
}
