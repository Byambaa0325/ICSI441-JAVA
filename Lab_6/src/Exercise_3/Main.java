package Exercise_3;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Main {

	private static final int WIDTH = 600;
	private static final int HEIGHT = 400;
	Frame frame;

	public static void main(String[] args) {
		new Main();
	}
	
	public Main() {
		ArrayList<Component> components = getComponents();
		frame = new Frame();
		for(Component comp : components) {
			frame.add(comp,BorderLayout.NORTH);
		}
		frame.setLayout(new GridLayout(1,2));
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		
	}

	private ArrayList<Component> getComponents() {
		ArrayList<Component> components = new ArrayList<>();
		
		//Right
		Panel rightPanel = new Panel();
		rightPanel.add(new Label("Data"));
		
		TextArea dataTextField = new TextArea();
		rightPanel.add(dataTextField);
		
		rightPanel.add(new Button("Save"));
		
		//Left
		Panel leftPanel = new Panel();
		
		leftPanel.add(new Label("Application Form"));
		JPanel argumentPanel = makeArgumentPanel(new String[] {"First Name","Last Name","Address","E-MailID"});
		leftPanel.add(argumentPanel);
		
		
		Panel buttonsPanel = new Panel();
		
		Button submitButton = new Button("Submit");
		Button clearButton = new Button("Clear");
		Button exitButton = new Button("Exit");
		
		buttonsPanel.add(submitButton);
		buttonsPanel.add(clearButton);		
		buttonsPanel.add(exitButton);
		
		submitButton.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){
		    	String dataText = "";
		    	
		    	for(Component arg : argumentPanel.getComponents()){
		    		System.out.println(dataText);
		    		Panel argBox = (Panel) arg;
		    		Label label = (Label) argBox.getComponent(0);
		    		TextField tf = (TextField) argBox.getComponent(1);
		    		dataText+=label.getText()+" "+tf.getText();
		    		dataText+="\n";
		    	}
		    	dataTextField.setText(dataText);
		    }  
		});
		clearButton.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){
		    	for( Component arg : argumentPanel.getComponents()){
		    		Panel argBox = (Panel) arg;
		    		TextField tf = (TextField) argBox.getComponent(1);
		    		tf.setText("");
		    	}
		    	dataTextField.setText("");
		    }  
		});
		exitButton.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		           frame.dispose();
		    }  
		});
		
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		leftPanel.add(buttonsPanel);
		leftPanel.setLayout(new GridLayout(3,1));
		rightPanel.setLayout(new GridLayout(3,1));
		
		components.add(leftPanel);
		components.add(rightPanel);
	    
		return components;
	}
	
	private JPanel makeArgumentPanel(String[] labels) {
		JPanel newPanel = new JPanel();
		
		newPanel.setLayout(new GridLayout(labels.length,2));
		
		for(String label : labels) {
			Panel box = new Panel();
			box.setLayout(new GridLayout(1,2));
			box.add(new Label(label+":"));
			box.add(new TextField("0.0"));
			newPanel.add(box);
		}
		return newPanel;
	}
}
