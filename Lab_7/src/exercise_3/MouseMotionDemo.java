package exercise_3;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

// An AWT GUI program inherits the top-level container java.awt.Frame
public class MouseMotionDemo extends Frame implements MouseListener, MouseMotionListener {
	// This class acts as MouseListener and MouseMotionListener
	// To display the (x, y) coordinates of the mouse-clicked
	private TextField tfMouseClickX;
	private TextField tfMouseClickY;
	// To display the (x, y) coordinates of the current mouse-pointer position
	private TextField tfMousePositionX;
	private TextField tfMousePositionY;

	/** Constructor to setup the GUI */
	public MouseMotionDemo() {
		setLayout(new FlowLayout()); // "this" frame sets to FlowLayout
		add(new Label("X-Click: "));
		tfMouseClickX = new TextField(10);
		tfMouseClickX.setEditable(false);
		add(tfMouseClickX);
		add(new Label("Y-Click: "));
		tfMouseClickY = new TextField(10);
		tfMouseClickY.setEditable(false);
		add(tfMouseClickY);
		add(new Label("X-Position: "));
		tfMousePositionX = new TextField(10);
		tfMousePositionX.setEditable(false);
		add(tfMousePositionX);
		add(new Label("Y-Position: "));
		tfMousePositionY = new TextField(10);
		tfMousePositionY.setEditable(false);
		add(tfMousePositionY);
		addMouseListener(this);
		addMouseMotionListener(this);
		// "this" frame fires MouseEvent to all its registered MouseListener and
		// MouseMotionListener
		// "this" frame adds "this" object as MouseListener and MouseMotionListener
		setTitle("MouseMotion Demo"); // "this" Frame sets title
		setSize(400, 120); // "this" Frame sets initial size
		setVisible(true); // "this" Frame shows
	}

	/** The entry main() method */
	public static void main(String[] args) {
		new MouseMotionDemo(); // Let the constructor do the job
	}

	/** MouseListener handlers */
	// Called back when a mouse-button has been clicked
	@Override
	public void mouseClicked(MouseEvent e) {
		tfMouseClickX.setText(e.getX() + "");
		tfMouseClickY.setText(e.getY() + "");
	}

	// Not Used, but need to provide an empty body for compilation
	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("mousePressed");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("mouseReleased");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("mouseEntered");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("mouseExited");
	}

	/** MouseMotionEvent handlers */
	// Called back when the mouse-pointer has been moved
	@Override
	public void mouseMoved(MouseEvent e) {
		tfMousePositionX.setText(e.getX() + "");
		tfMousePositionY.setText(e.getY() + "");
	}

	// Not Used, but need to provide an empty body for compilation
	@Override
	public void mouseDragged(MouseEvent e) {
	}
}
