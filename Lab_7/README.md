<h1>Laboratory 7</h1>
<sub> Byambaa Bayarmandakh 17B1NUM0662<sub>
 
<h2>Exerise 1</h2>

```java
//EXERCISE
//Added event to exit the frame
if (count == COUNT_LIMIT) {
  this.dispose(); //"this" Frame is disposed
}
```

![Screenshot](E1.jpg?raw=true "Result Exercise 1")

<h2>Exerise 2</h2>

```java
@Override
public void windowClosed(WindowEvent e) {
  System.out.println("windowClosed");
}

@Override
public void windowIconified(WindowEvent e) {
  System.out.println("windowIconified");
}

@Override
public void windowDeiconified(WindowEvent e) {
  System.out.println("windowDeiconified");
}

@Override
public void windowActivated(WindowEvent e) {
  System.out.println("windowActivated");
}

@Override
public void windowDeactivated(WindowEvent e) {
  System.out.println("windowDeactivated");
}
```

![Screenshot](E2.jpg?raw=true "Result Exercise 2")

<h2>Exerise 3</h2>

```java
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
```

![Screenshot](E3.jpg?raw=true "Result Exercise 3")

<h2>Exerise 4</h2>

```java
@Override
public void keyPressed(KeyEvent e) {
  System.out.println("keyPressed: "+e.getKeyChar());
}

@Override
public void keyReleased(KeyEvent e) {
  System.out.println("keyReleased");
}
```

![Screenshot](E4.jpg?raw=true "Result Exercise 4")

<h2>Exerise 5</h2>

```java
...
CheckboxGroup cg = new CheckboxGroup(); // Initiate a checkbox group
...
d1.addItemListener(this); // Add "this" ItemListener to the radio button
...
public void itemStateChanged(ItemEvent e) // Called when the state of the item is changed
...
if (d1.getState()) // get whether the item is checked or unchecked
...
```

![Screenshot](E5.jpg?raw=true "Result Exercise 5")

<h2>Exerise 6</h2>

```java
...
public class Mycombo extends Applet implements ItemListener // Applet class that can listen for event item
{
	Choice c1; // Enabled choice
	Label l1; // Label for the choice
	Color col = Color.orange; // Current color
...
		c1 = new Choice(); // Make a choice
...
    c1.addItemListener(this); // "this" applet will observe the state of the choice c1
    add(l1); // Add l1 label to "this" Applet
...
		String s = (String) e.getItem(); // get the item of the event occurred
...
```

![Screenshot](E6.jpg?raw=true "Result Exercise 6")

<h2>Exerise 7</h2>

```java
...
public class ScrollbarApplet extends Applet implements AdjustmentListener {
	Scrollbar sbar;
	TextField t1 = new TextField(5); // Textfield for displaying scrollbar location
...
		setLayout(new BorderLayout());// Set the layout to be BorderLayout
		sbar = new Scrollbar(Scrollbar.HORIZONTAL, 1, 60, 0, 300);// Initiate a scrollbar component
...
		t1.setText(Integer.toString(sbar.getValue()));// Set the initial text
	}
...
	public void adjustmentValueChanged(AdjustmentEvent e) // Called when subject's adjustment value is changed
	{
		t1.setText(Integer.toString(sbar.getValue()));// Change the textfield's text to value of the scroll bar
...
```

![Screenshot](E7.jpg?raw=true "Result Exercise 7")
