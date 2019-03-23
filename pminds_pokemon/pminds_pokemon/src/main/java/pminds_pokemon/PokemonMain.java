package pminds_pokemon;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.stage.Stage;
import pminds_pokemon.resources.Messages;
import javafx.scene.layout.Pane;


/**
 * @author acaldeira
 *
 */
public class PokemonMain extends Application {
	
	/**
	 * Static value representing JavaFx user interface, needed to load said interface.
	 */
	public static String GUI = "PokemonFXMLGui.fxml";

	/* (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	public void start(Stage primaryStage) throws IOException {
		Pane root = FXMLLoader.load(getClass().getResource(GUI), Messages.getResourceBundle());
		Scene scene = new Scene(root, 600, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	/**
	 * Main method.
	 * @param args No arguments are needed.
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
}
