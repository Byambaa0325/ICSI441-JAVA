package Exercise_2;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class Main  {
	private static final int WIDTH = 300;
	private static final int HEIGHT = 400;

	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		ArrayList<Component> components = getComponents();
		Frame frame = new Frame();
		for(Component comp : components) {
			frame.add(comp,BorderLayout.NORTH	);
		}
		frame.setLayout(new BoxLayout(frame, BoxLayout.Y_AXIS));
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		
	}

	private ArrayList<Component> getComponents() {
		ArrayList<Component> components = new ArrayList<>();
		
		Panel paneTop = new Panel();
		paneTop.add(
				makeArgumentPanel(
						new String[] {"X","Y","Width","Height"},
						"Grid Position"
						)
				);
		paneTop.add(
				makeArgumentPanel(
						new String[] {"Top","Left","Bottom","Right"},
						"External Insets"
						)
				);
		paneTop.add(
				makeArgumentPanel(
						new String[] {"Width","Height"},
						"Size Padding"
						)
				);
		paneTop.setLayout(new GridLayout(1,3));
		components.add(paneTop);
		
		Panel paneCenter = new Panel();
		paneCenter.setLayout(new BoxLayout(paneCenter, BoxLayout.X_AXIS));
		paneCenter.add(
				makeArgumentPanel(
						new String[] {"X","Y"},
						"Weight"
						)
				);
		paneCenter.add(
				makeRadioButtonPanel(
						new String[] {"NW","N","NE","W","C","E","SW","S","SE"},
						3,
						3,
						4,
						"Anchor"
						)
				);
		components.add(paneCenter);
		
		components.add(
				makeRadioButtonPanel(
						new String[] {"None","Horizontal","Vertical","Both"},
						1,
						4,
						1,
						"Fill"
						)
				);
		Panel buttonsPanel = new Panel();
		buttonsPanel.add(new Button("Ok"));
		buttonsPanel.add(new Button("Cancel"));
		buttonsPanel.add(new Button("Help"));
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		components.add(buttonsPanel);
		return components;
	}
	
	private JPanel makeArgumentPanel(String[] labels, String title) {
		JPanel newPanel = new JPanel();
		
		
		newPanel.setBorder(BorderFactory.createTitledBorder(
		        BorderFactory.createEtchedBorder(), title));
		//newPanel.setLayout(new GridLayout(labels.length,2));
		newPanel.setLayout(new BoxLayout(newPanel,BoxLayout.Y_AXIS));
		
		for(String label : labels) {
			Panel box = new Panel();
			box.setLayout(new GridLayout(1,2));
			box.add(new Label(label+":"));
			box.add(new TextField("0.0"));
			newPanel.add(box);
		}
		return newPanel;
	}
	
	private JPanel makeRadioButtonPanel(String[] labels, int rows, int columns, int defaultIndex, String title) {
		JPanel newPanel = new JPanel();
		CheckboxGroup cbg = new CheckboxGroup();
		int indexCounter = 0;
		
		newPanel.setBorder(BorderFactory.createTitledBorder(
		        BorderFactory.createEtchedBorder(), title));
		newPanel.setLayout(new GridLayout(rows,columns));
		
		for(String label : labels) {
			newPanel.add(new Checkbox(label, cbg, indexCounter++==defaultIndex));
		}
		return newPanel;
		
	}

}
