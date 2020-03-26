package exercise_7;

/* Scrollbar Demo */
/* <applet code="ScrollbarApplet.class" width=300 height=50></applet> */
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

// Applet program 
public class ScrollbarApplet extends Applet implements AdjustmentListener {
	Scrollbar sbar;
	TextField t1 = new TextField(5); // Textfield for displaying scrollbar location

	public void init() {
		setLayout(new BorderLayout());// Set the layout to be BorderLayout
		sbar = new Scrollbar(Scrollbar.HORIZONTAL, 1, 60, 0, 300);// Initiate a scrollbar component
		sbar.setBackground(Color.pink);
		sbar.addAdjustmentListener(this);
		add(sbar, BorderLayout.CENTER);
		add(t1, BorderLayout.SOUTH);
		t1.setText(Integer.toString(sbar.getValue()));// Set the initial text
	}

	public void adjustmentValueChanged(AdjustmentEvent e) // Called when subject's adjustment value is changed
	{
		t1.setText(Integer.toString(sbar.getValue()));// Change the textfield's text to value of the scroll bar
	}
}