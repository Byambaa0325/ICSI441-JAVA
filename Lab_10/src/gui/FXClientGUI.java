package gui;


import client.Client;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Client Stage for FX Server application
 * @author Byambaa Bayarmandakh
 *
 */
public class FXClientGUI extends Stage {
	TextArea messageBoard;
	TextField messageInput;
	TextField host;
	TextField port;
	Button spawnServer;
	Button spawnClient;
	Button sendButton;

	Client server;

	public FXClientGUI() {
		GridPane root = new GridPane();
		root.setPadding(new Insets(10));
		root.setHgap(25);
		root.setVgap(5);
		root.setAlignment(Pos.CENTER);

		messageBoard = new TextArea();
		messageBoard.setEditable(false);
		root.add(messageBoard, 0, 0, 3, 4);

		Label messageLabel = new Label("Message:");
		messageInput = new TextField();
		root.add(messageLabel, 0, 6);
		root.add(messageInput, 0, 7, 3, 1);

		Label hostLabel = new Label("Host:");
		host = new TextField("127.0.0.1");
		root.add(hostLabel, 3, 0);
		root.add(host, 4, 0);

		Label portLabel = new Label("Port:");
		port = new TextField("8888");
		root.add(portLabel, 3, 1);
		root.add(port, 4, 1);

		spawnServer = new Button("Connect to Server");
		GridPane.setHalignment(spawnServer, HPos.LEFT);
		root.add(spawnServer, 3, 3, 1, 1);
		spawnServer.setOnAction(actionEvent -> {
			if (server == null) {

				server = new Client(messageBoard, host.getText(), Integer.parseInt(port.getText()));
				this.setTitle(server.name);
				messageBoard.appendText("Connection Successful  \n");
			} else {
				messageBoard.appendText("Connection already active  \n");
			}
		});

		spawnClient = new Button("Spawn Client");
		GridPane.setHalignment(spawnClient, HPos.LEFT);
		root.add(spawnClient, 4, 3, 1, 1);
		spawnClient.setOnAction(actionEvent -> {
			new FXClientGUI();
		});

		sendButton = new Button("Send");
		root.add(sendButton, 3, 7, 1, 1);

		sendButton.setOnAction(actionEvent -> {
			server.sendMessage(messageInput.getText());
			messageInput.setText("");
		});

		Scene scene = new Scene(root, 500, 500);
		this.setTitle("Client");
		this.setScene(scene);
		this.show();

	}
}
