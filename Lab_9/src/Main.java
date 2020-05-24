import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Main extends JFrame {
	
	CustomerDAO db = new CustomerDAO();
	
	public static void main(String args[]) {
		JFrame myframe = new Main();
		
		myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public Main() {
		setSize(400,400);  
		
		JMenuBar menuBar = new JMenuBar();

		String[] menuSections = new String[] { "File", "Edit", "Customer", "Help" };
		for (String menuName : menuSections) {
			JMenu menu = new JMenu(menuName);
			for (int i = 0; i < 5; i++) {
				JMenuItem item = new JMenuItem(new AbstractAction("Item " + i) {
					String containerMenu = menuName;
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
		menuBar.setBounds(0, 0, getWidth(), getHeight()/10);
		
		this.add(menuBar);

		/**
		 * 
		 */
		JToolBar toolbar = new JToolBar();
		toolbar.setRollover(true);
		JButton b1 = new JButton("Icon 1"); 
		b1.addActionListener( new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		        System.out.println(b1.getText() +" has been clicked ");
		    }
		});
		JButton b2 = new JButton("Icon 2");
		b2.addActionListener( new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		        System.out.println(b2.getText() +" has been clicked ");
		    }
		});
		JButton b3 = new JButton("Icon 3");
		b3.addActionListener( new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		        System.out.println(b3.getText() +" has been clicked ");
		    }
		});
		JButton b4 = new JButton("Icon 4");
		b4.addActionListener( new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		        System.out.println(b4.getText() +" has been clicked ");
		    }
		});
		toolbar.add(b1);toolbar.add(b2);toolbar.add(b3);toolbar.add(b4);
		toolbar.setBounds(0, getHeight()/10, getWidth(), getHeight()/10);
		this.add(toolbar);

		/**
		 * customerOverviewFrame
		 */
		JInternalFrame customerOverviewFrame = new JInternalFrame("Customer overview");
		JTable customerTable = new JTable();
		
		DatabaseTableView model = new DatabaseTableView(db);
		customerTable.setModel(model);
		customerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		ListSelectionModel selectionModel = customerTable.getSelectionModel();

		selectionModel.addListSelectionListener(new ListSelectionListener() {
		    public void valueChanged(ListSelectionEvent e) {
		    	int row = customerTable.getSelectedRow();
				if(row == -1) {
					return;
				}
				System.out.println("Customer has been selected");
				System.out.println(db.getData()[row].toString());
		    }
		});
		customerOverviewFrame.add(customerTable);
		
		customerOverviewFrame.setBounds(0, 2*(getHeight()/10), getWidth()/10*4, getHeight()/10*8);
		customerOverviewFrame.setVisible(true);
		this.add(customerOverviewFrame);

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
		
		customerSearchFrame.setBounds(getWidth()/10*4, 2*(getHeight()/10), getWidth()/10*6, getHeight()/10*4);
		customerSearchFrame.setVisible(true);
		this.add(customerSearchFrame);

		/**
		 * customerDataFrame
		 */
		JInternalFrame customerDataFrame = new JInternalFrame("Customer -- main data");
		customerDataFrame.setLayout(new FlowLayout());
		
		Label idInputLabel = new Label("Id:");
		customerDataFrame.add(idInputLabel);
		
		TextField idAddInput = new TextField();
		customerDataFrame.add(idAddInput);
		
		Label lNameInputLabel = new Label("Last Name:");
		customerDataFrame.add(lNameInputLabel);
		
		TextField lNameAddInput = new TextField();
		customerDataFrame.add(lNameAddInput);
		
		Label fNameInputLabel = new Label("First Name:");
		customerDataFrame.add(fNameInputLabel);
		
		TextField fNameAddInput = new TextField();
		customerDataFrame.add(fNameAddInput);
		
		JButton saveButton = new JButton("Save");
		JButton resetButton = new JButton("Reset");
		JButton closingButton = new JButton("Close");
		
		saveButton.addActionListener( new ActionListener()
		{
		    @Override
		    public void actionPerformed(ActionEvent e)
		    {
		        int id = Integer.parseInt(idAddInput.getText());
		        Customer toAdd = new Customer(id,lNameAddInput.getText(),fNameAddInput.getText());
		        db.insert(toAdd);
		        System.out.println("Customer Added ");
		        model.setDataVector(DatabaseTableView.getData(), DatabaseTableView.getHeaders());
		        
		    }
		});
		customerDataFrame.add(saveButton);
		customerDataFrame.add(resetButton);
		customerDataFrame.add(closingButton);
		
		customerDataFrame.setBounds(getWidth()/10*4, 6*(getHeight()/10), getWidth()/10*6, getHeight()/10*4);
		customerDataFrame.setVisible(true);
		this.add(customerDataFrame); 
		
		
		
	    setLayout(null);  
	    setVisible(true);
		
	}

}
