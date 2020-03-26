package exercise_1;

import java.awt.*; // using AWT containers and components
import java.awt.event.*; // using AWT events and listener interfaces

// An AWT GUI program inherits the top-level container java.awt.Frame
@SuppressWarnings("serial")
public class Counter extends Frame implements ActionListener{
	
	private static final int COUNT_LIMIT = 10;
	private Label lblCount; // declare component Label
	private TextField tfCount; // declare component TextField
	private Button btnCount; // declare component Button
	private int count = 0; // counter's value

	/** Constructor to setup GUI components */
	public Counter() {
		
		setLayout(new FlowLayout());
		// "this" Frame sets its layout to FlowLayout, which arranges the components
		// from left-to-right, and flow to next row from top-to-bottom.
		
		lblCount = new Label("Counter"); // construct Label
		add(lblCount); // "this" Frame adds Label
		
		tfCount = new TextField("0", 10); // construct TextField
		tfCount.setEditable(false); // set to read-only
		add(tfCount); // "this" Frame adds tfCount
		
		btnCount = new Button("Count"); // construct Button
		add(btnCount); // "this" Frame adds Button
		
		btnCount.addActionListener(this); // for event-handling
		
		setTitle("AWT Counter"); // "this" Frame sets title
		setSize(250, 100); // "this" Frame sets initial window size
		setVisible(true); // "this" Frame shows
	}

	public static void main(String[] args) {
		// Invoke the constructor to setup the GUI, by allocating an instance
		Counter app = new Counter();
	}

	/** ActionEvent handler - Called back when user clicks the button.
	 *  Exits the frame when counter goes above the limit
	 *  */
	@Override
	public void actionPerformed(ActionEvent evt) {
		count++; // increase the counter value
		// Display the counter value on the TextField tfCount
		tfCount.setText(count + ""); // convert int to String
		
		//EXERCISE
		//Added event to exit the frame
		if (count == COUNT_LIMIT) {
			this.dispose(); //"this" Frame is disposed
		}
	}
}
