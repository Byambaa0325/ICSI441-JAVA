package Exercise_1;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.util.ArrayList;

public class Exercise_1_WOLayout  {
	private static final int WIDTH = 300;
	private static final int HEIGHT = 400;

	public static void main(String[] args) {
		new Exercise_1_WOLayout();
	}
	
	public Exercise_1_WOLayout() {
		ArrayList<Component> components = getComponents();
		Frame frame = new Frame();
		
		int y = 40;
		int height = (HEIGHT-40)/components.size();
		
		for(Component comp : components) {
			comp.setBounds(10, y, WIDTH, height);
			y+=height;
			frame.add(comp);
		}
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setLayout(null);
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
