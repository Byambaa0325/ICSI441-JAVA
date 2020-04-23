package screen;

import java.util.ArrayList;

import Main.Game;
import component.Component;

/**
 * Screen for a game. Extends graphic component of the game.
 * Container for grahpic components.
 * @author User
 */
public interface Screen extends Runnable, Component{

	void init();
	void addComponent(Component component);
	void removeComponent(Component component);
	ArrayList<Component> getComponents();
	Game getGame();
	int getWidth();
	int getHeight();
	int getDelay();

}
