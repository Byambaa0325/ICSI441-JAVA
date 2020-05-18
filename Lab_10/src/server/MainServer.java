package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JTextArea;

import javafx.scene.control.TextArea;

/**
 * Main server to handle connections and displaying messages
 * @author Byambaa Bayarmandakh
 *
 */
public class MainServer extends Thread {
	
	//Port to host
	int port = 8888;
	//Subservers connected to clients
	ArrayList<Server> servers = new ArrayList<>();
	//Output to display messages to
	TextArea output;

	/**
	 * Assigns ports and toggles output stream
	 * @param messageBoard
	 * @param port
	 */
	public MainServer(TextArea messageBoard, int port) {
		this.output = messageBoard;
		this.port = port;
	}

	/**
	 * @deprecated
	 * @param messageBoard
	 */
	public MainServer(JTextArea messageBoard) {

	}

	
	public void run() {
		//Start the server
		try (ServerSocket serverSocket = new ServerSocket(port)) {

			printMessage(null, "Server is listening on port " + port);

			//Server communication loop
			while (true) {
				//Connect a client
				Socket socket = serverSocket.accept();

				//Branch a server to handle comms with the client
				Server newServer = new Server(this, socket);
				//Add it to list of branched servers
				servers.add(newServer);
				newServer.start();//Start communication process
			}

		} catch (IOException ex) {
			System.out.println("Server exception: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void printMessage(Server source, String clientString) {

		output.appendText(clientString + "\n");

		// Broadcast
		for (Server server : servers) {
			if (!server.equals(source)) {
				server.sendMessage(clientString);
			}
		}
	}

	public void sendMessage(String message) {
		output.appendText("Server: " + message + "\n");
		message = "Server: " + message;
		for (Server server : servers) {
			server.sendMessage(message);
		}
	}

}
