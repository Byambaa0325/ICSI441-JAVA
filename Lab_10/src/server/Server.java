package server;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;


public class Server extends Thread {

	
	//Sending message flag
	private boolean SEND_MESSAGE;
	private String MESSAGE;
	
	//Socket with the client
	Socket socket;
	//Main server to propogate communication back
	MainServer mainServer;
	
	/**
	 * Constuctor for the server
	 * @param main
	 * @param socket
	 */
	Server(MainServer main, Socket socket){
		this.socket = socket;
		this.mainServer = main;
	}


	public void run() {
		
		try {

			System.out.println("New client connected");

			//Configure output stream
			OutputStream output = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(output, true);
			
			//Configure output stream
			InputStream input = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			
			//Communication loop
			do {
				//Message Received
				if(reader.ready()) {
					System.out.println("Server receiving a message");
					String clientString;
					clientString = reader.readLine();
					printMessage(clientString);
				}
				
				//Send message
				if(SEND_MESSAGE) {
					System.out.println("Server sending a message");
					writer.println(MESSAGE);
					SEND_MESSAGE = false;
					MESSAGE = null;
				}
			}while(socket.isConnected());
			
		}catch(IOException e) {
			e.printStackTrace();
		}
			

	}

	private void printMessage(String clientString) {
		mainServer.printMessage(this, clientString);	
	}
	
	public void sendMessage(String message) {
		SEND_MESSAGE = true;
		MESSAGE = message;
	}
}
