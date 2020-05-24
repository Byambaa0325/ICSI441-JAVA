import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JToolBar;

public class Main extends JFrame {
	public static void main(final String args[]) {
		JFrame myframe = new JFrame("JToolBar Example");
		myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void init() {
		JMenuBar menuBar = new JMenuBar();

		String[] menuSections = new String[] { "File", "Edit", "Customer", "Help" };
		for (String menuName : menuSections) {
			JMenu menu = new JMenu(menuName);
			for (int i = 0; i < 5; i++) {
				JMenuItem item = new JMenuItem(new AbstractAction("Item " + i) {
					String containerMenu = menu.getName();
					String itemName = this.NAME;

					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("Clicked: " + itemName + " in " + containerMenu);
					}
				});
				menu.add(item);
			}
			menuBar.add(menu);
		}

		/**
		 * 
		 */
		JToolBar toolbar = new JToolBar();
		toolbar.setRollover(true);

		/**
		 * customerOverviewFrame
		 */
		JInternalFrame customerOverviewFrame = new JInternalFrame("Customer overview");
		JTable customerTable = new JTable();
		CustomerDAO db = new CustomerDAO();
		DatabaseTableView model = new DatabaseTableView(db);
		customerTable.setModel(model);
		customerOverviewFrame.add(customerTable);

		/**
		 * customerSearchFrame
		 */
		JInternalFrame customerSearchFrame = new JInternalFrame("Search for customers");
		customerSearchFrame.setLayout(new FlowLayout());

		Label idLabel = new Label("Id:");
		customerSearchFrame.add(idLabel);

		TextField idInput = new TextField();
		customerSearchFrame.add(idInput);

		Label nameLabel = new Label("Last name:");
		customerSearchFrame.add(nameLabel);

		TextField nameInput = new TextField();
		customerSearchFrame.add(nameInput);
		
		JButton searchButton = new JButton("Search");
		JButton searchCloseButton = new JButton("Close");
		
		customerSearchFrame.add(searchButton);
		customerSearchFrame.add(searchCloseButton);		
		

		/**
		 * customerDataFrame
		 */
		JInternalFrame customerDataFrame = new JInternalFrame("Customer -- main data");
		customerDataFrame.setLayout(new FlowLayout());
		
		Label idInputLabel = new Label("Id:");
		customerDataFrame.add(idInputLabel);
		
		TextField idAddInput = new TextField();
		customerDataFrame.add(idAddInput);
		
		
	}

}
