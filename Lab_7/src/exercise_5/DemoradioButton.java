package exercise_5;

/*RadioButton using Checkbox demo */
/* <applet code="DemoradioButton.class" width="300" height="150"></applet> */
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class DemoradioButton extends Applet implements ItemListener {
	Checkbox d1, d2, d3;
	CheckboxGroup cg = new CheckboxGroup(); // Initiate a checkbox group
	TextField t1 = new TextField(30);

	public void init() {
		setBackground(new Color(219, 253, 226));
		d1 = new Checkbox("IT", true, cg);
		d2 = new Checkbox("CE", false, cg);
		d3 = new Checkbox("ECE", false, cg);
		add(new Label("Select the department"));
		add(d1);
		add(d2);
		add(d3);
		add(t1);
		t1.setText("I Study in IT");
		d1.addItemListener(this); // Add "this" ItemListener to the radio button
		d2.addItemListener(this);
		d3.addItemListener(this);
	}

	public void itemStateChanged(ItemEvent e) // Called when the state of the item is changed
	{
		String msg = "I study in ";
		if (d1.getState()) // get whether the item is checked or unchecked
			msg = msg + d1.getLabel();
		else if (d2.getState())
			msg = msg + d2.getLabel();
		else
			msg = msg + d3.getLabel();
		t1.setText(msg);
	}
}
