package gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import server.MainServer;

public class ServerGUI extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4391806942467557530L;
	JTextArea messageBoard;
	JTextField messageInput;
	JTextField host;
	JTextField port;
	JButton spawnServer;
	JButton spawnClient;
	JButton sendButton;
	
	MainServer server;
	
	
	public ServerGUI() {
		
		setSize(500, 500);
		setTitle("Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
		
		setLayout(new GridLayout(7,1));  
		
		messageBoard = new JTextArea();
		server = new MainServer(messageBoard);
		messageInput = new JTextField();
		host = new JTextField();
		port = new JTextField();
		spawnServer = new JButton("Server");
		spawnClient = new JButton("Client");
		sendButton = new JButton("Send");
		
		sendButton.addActionListener(new ActionListener()
	    {
	      public void actionPerformed(ActionEvent e)
	      {
	       server.sendMessage(messageInput.getText());
	       messageInput.setText("");
	      }
	    });
		
		spawnClient.addActionListener(new ActionListener()
	    {
		      public void actionPerformed(ActionEvent e)
		      {
		       new ClientGUI();
		      }
		    });
		
		JScrollPane scrollPane = new JScrollPane(messageBoard);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);  
		scrollPane.setSize(200,200);
		this.add(scrollPane);
		this.add(messageInput);
		this.add(sendButton);
		this.add(host);
		this.add(port);
		this.add(spawnServer);
		this.add(spawnClient);
		
		server.start();
		setVisible(true);
	
	}

}
