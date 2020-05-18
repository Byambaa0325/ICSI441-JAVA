package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import client.Client;

public class ClientGUI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1726516610528283754L;
	JTextArea messageBoard;
	JTextField messageInput;
	JTextField host;
	JTextField port;
	JButton spawnServer;
	JButton spawnClient;
	JButton sendButton;
	
	Client client;
	
	
	public ClientGUI() {
		
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
		
		setLayout(new GridLayout(7,1)); 
		
		messageBoard = new JTextArea();
		messageInput = new JTextField();
		host = new JTextField();
		port = new JTextField();
		spawnServer = new JButton("Server");
		spawnClient = new JButton("Client");
		sendButton = new JButton("Send");
		
		client = new Client(messageBoard);
		
		sendButton.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	       client.sendMessage(messageInput.getText());
	       messageInput.setText("");
	      }
	    });
		
		JScrollPane scrollPane = new JScrollPane(messageBoard);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
		this.add(scrollPane);
		this.add(messageInput);
		this.add(sendButton);
		this.add(host);
		this.add(port);
		this.add(spawnServer);
		this.add(spawnClient);
		setTitle(client.name);
		setVisible(true);
		
	
	}

}
