package screen;

import java.awt.Graphics;
import java.util.ArrayList;

import Main.Game;
import component.Component;

public class VictoryGameScreen implements Screen {
	
	Game game;
	
	public VictoryGameScreen(Game game) {
		this.game = game;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(int x, int y, Screen screen) {
		// TODO Auto-generated method stub

	}

	@Override
	public void paint(Graphics g) {
		g.drawString("You've won! Congrats, I guess?", game.getWidth()/2-50, game.getHeight()/2);
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

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

}
