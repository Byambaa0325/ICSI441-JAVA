package exercise_4;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// An AWT GUI program inherits the top-level container java.awt.Frame
public class KeyEventDemo extends Frame implements KeyListener {
	// This class acts as KeyEvent Listener
	private TextField tfInput; // single-line TextField to receive tfInput key
	private TextArea taDisplay; // multi-line TextArea to taDisplay result

	/** Constructor to setup the GUI */
	public KeyEventDemo() {
		setLayout(new FlowLayout()); // "this" frame sets to FlowLayout
		add(new Label("Enter Text: "));
		tfInput = new TextField(10);
		add(tfInput);
		taDisplay = new TextArea(5, 40); // 5 rows, 40 columns
		add(taDisplay);
		tfInput.addKeyListener(this);
		// tfInput TextField fires KeyEvent to its registered KeyListener
		// It adds "this" object as a KeyEvent listener
		setTitle("KeyEvent Demo"); // "this" Frame sets title
		setSize(400, 200); // "this" Frame sets initial size
		setVisible(true); // "this" Frame shows
	}

	/** The entry main() method */
	public static void main(String[] args) {
		new KeyEventDemo(); // Let the constructor do the job
	}

	/** KeyEvent handlers */
	// Called back when a key has been typed (pressed and released)
	@Override
	public void keyTyped(KeyEvent e) {
		taDisplay.append("You have typed " + e.getKeyChar() + "\n");
	}

	// Not Used, but need to provide an empty body for compilation
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("keyPressed: "+e.getKeyChar());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("keyReleased");
	}
}
