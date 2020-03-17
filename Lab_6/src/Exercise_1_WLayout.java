import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.util.ArrayList;

public class Exercise_1_WLayout  {
	private static final int WIDTH = 300;
	private static final int HEIGHT = 400;

	public static void main(String[] args) {
		new Exercise_1_WLayout();
	}
	
	public Exercise_1_WLayout() {
		ArrayList<Component> components = getComponents();
		Frame frame = new Frame();
		for(Component comp : components) {
			frame.add(comp,BorderLayout.NORTH);
		}
		frame.setLayout(new GridLayout(components.size(),1));
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		
	}

	private ArrayList<Component> getComponents() {
		ArrayList<Component> components = new ArrayList<>();
		components.add(new TextField("TextField"));
		components.add(new Label("Label"));
		components.add(new Button("Button"));
		components.add(new Checkbox("Checkbox"));
		components.add(new TextArea("TextArea"));
		return components;
	}

}
