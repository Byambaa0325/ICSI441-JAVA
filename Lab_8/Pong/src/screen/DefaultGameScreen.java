package screen;

import Main.Game;
import component.Component;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class DefaultGameScreen implements Screen, KeyListener {
	Game game;
	private int width;
	private int height;

	public DefaultGameScreen(Game game, int width, int height) {
		this.game = game;
		this.width = width;
		this.height = height;
	}

	@Override
	public void init() {
		this.game.addKeyListener(this);
	}

	@Override
	public void paint(Graphics g) {
		g.drawString("Press any button to start", game.getWidth()/2-50, game.getHeight()/2);
	}

	@Override
	public void run() {

	}

	@Override
	public Game getGame() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDelay() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void init(int x, int y, Screen screen) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		game.removeKeyListener(this);
	}

	@Override
	public void addComponent(Component component) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeComponent(Component component) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Component> getComponents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		changeToPongGameScreen();
		
	}

	private void changeToPongGameScreen() {
		game.setCurrentScreen(new PongGameScreen(game, width, height));
		game.init();
		this.stop();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
