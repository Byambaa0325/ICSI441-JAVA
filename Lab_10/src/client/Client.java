package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JTextArea;

import javafx.scene.control.TextArea;

/**
 * Client thread that handles server connection
 * @author Byambaa Bayarmandakh
 *
 */
public class Client extends Thread {

	//Total client cound to assign ID
	private static int clientCount = 0;

	//Hostname to connect
	public String hostname = "127.0.0.1";
	//Port to connect
	public int port = 8888;
	
	//Message Send flags
	private boolean SEND_MESSAGE;
	private String MESSAGE;
	
	//Output text area to print
	TextArea output;

	//Client name based on static object count
	public String name = "Client " + clientCount;

	/**
	 * @deprecated
	 * @param output
	 */
	public Client(JTextArea output) {
		this.start();
		clientCount++;
	}

	/**
	 * Constructor to setup the client
	 * @param output
	 * @param host
	 * @param port
	 */
	public Client(TextArea output, String host, int port) {
		this.hostname = host;
		this.port = port;
		this.output = output;
		this.start();
		clientCount++;
	}

	
	public void run() {
		System.out.println("Starting a client");
		try (Socket socket = new Socket(hostname, port)) {

			//Configure input stream
			InputStream input = socket.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));

			//Configure output stream
			OutputStream output = socket.getOutputStream();
			PrintWriter writer = new PrintWriter(output, true);

			// Client Communication loop while it is connected
			do {

				//Message Received
				if (reader.ready()) {
					System.out.println("Client received a message");
					String serverString;
					serverString = reader.readLine();
					printMessage(serverString);
				}

				//Send message flag active
				if (SEND_MESSAGE) {
					System.out.println("Client sending message");
					writer.println(MESSAGE);
					SEND_MESSAGE = false;
				}
			} while (socket.isConnected());

		} catch (UnknownHostException ex) {
			System.out.println("Server not found: " + ex.getMessage());
		} catch (IOException ex) {
			System.out.println("I/O error: " + ex.getMessage());
		}
	}

	public void printMessage(String clientString) {
		output.appendText(clientString + "\n");
	}

	/**
	 * Toggles send message flag active and saves the message
	 * @param message
	 */
	public void sendMessage(String message) {
		SEND_MESSAGE = true;
		MESSAGE = name + ": " + message;
		output.appendText(MESSAGE + "\n");
	}

	/**
	 * For assigning ID
	 * @return
	 */
	public static int getCLientID() {
		return clientCount;
	}

}
