package pminds_pokemon;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.TextFormatter.Change;
import javafx.scene.image.ImageView;

/**
 * @author acaldeira
 *
 */
public class PokemonFXMLController implements Initializable {

	/**
	 * Integer that limits the size of JavaFx TextField input, prevent crash from memory full.
	 */
	public static int MAX_INPUT_SIZE = 10000;
	
	/**
	 * JavaFx TextField representing textfield where user writes the input.
	 */
	@FXML
	private TextField ashPath;
	/**
	 * JavaFx Button representing button to calculate number of pokemons caught.
	 */
	@FXML
	private Button goButton;
	/**
	 * JavaFx Label representing label where the number of pokemons caught is announced.
	 */
	@FXML
	private Label pokemonLabel;
	/**
	 * JavaFx ImageView representing pokeball image.
	 */
	@FXML
	private ImageView pokeballImage;
	
	/**
	 * Java instance representing trainer Ash.
	 */
	private TrainerAsh ash = new TrainerAsh();

	
	/**
	 * Method associated with button click. Calculates number of pokemons caught and prints it on the user interface. 
	 * @param event Event associated with clicking the user interface "Go!" button.
	 */
	@FXML
	void goButtonAction(ActionEvent event) {
		String ashPathString = ashPath.getText();
		ash.catchPokemons(ashPathString);
		pokemonLabel.setVisible(true);
		pokemonLabel.setText(ash.getPokemonsString());
		pokeballImage.setVisible(true);
	}
	
	
	/**
	 * Method that limits the size of JavaFx TextField input.
	 * This method prevents the programme from breaking from lack of memory space.
	 */
	private void limitTextFieldInputSize() {
		final Pattern pattern = Pattern.compile(".{0," + MAX_INPUT_SIZE + "}");
		UnaryOperator<TextFormatter.Change> textFilter = new UnaryOperator<Change>() {
			public Change apply(Change change) {
				return pattern.matcher(change.getControlNewText()).matches() ? change : null;
			}
		};
		TextFormatter<String> formatter = new TextFormatter<String>(textFilter);	
	    ashPath.setTextFormatter(formatter);
	}

	/* (non-Javadoc)
	 * @see javafx.fxml.Initializable#initialize(java.net.URL, java.util.ResourceBundle)
	 */
	public void initialize(URL arg0, ResourceBundle arg1) {
		pokeballImage.setVisible(false);
		pokemonLabel.setVisible(false);
		limitTextFieldInputSize();
	}


}
