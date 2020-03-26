package exercise_6;

/* Choice Demo */
/*<applet code = "Mycombo.class" width = 250 height = 150></applet> */
import java.awt.*;
import java.applet.*;
import java.awt.event.*;

public class Mycombo extends Applet implements ItemListener // Applet class that can listen for event item
{
	Choice c1; // Enabled choice
	Label l1; // Label for the choice
	Color col = Color.orange; // Current color

	public void init() {
		setBackground(col);
		l1 = new Label("Select the background color from the Choice");
		c1 = new Choice(); // Make a choice
		c1.addItem("Red");
		c1.addItem("Green");
		c1.addItem("Yellow");
		c1.addItem("Pink");
		c1.addItemListener(this); // "this" applet will observe the state of the choice c1
		add(l1); // Add l1 label to "this" Applet
		add(c1);
	}

	public void itemStateChanged(ItemEvent e) {
		String s = (String) e.getItem(); // get the item of the event occurred
		if (s == "Red")
			col = Color.RED;
		else if (s == "Green")
			col = Color.GREEN;
		else if (s == "Yellow")
			col = Color.YELLOW;
		else if (s == "Pink")
			col = Color.PINK;
		setBackground(col);
		l1.setBackground(col);
	}
}
