package pminds_pokemon;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import pminds_pokemon.resources.Messages;

/**
 * @author acaldeira
 *
 */
public class TrainerAsh {
	
	/**
	 * Point representing current grid position of trainer Ash.
	 * It is set to (0,0) before every new request.
	 */
	private Point currentPosition;
	/**
	 * List of Points where trainer Ash has already been.
	 * List if cleared before every new request. 
	 */
	private List<Point> pathTaken;
	/**
	 * Pokemon counter. It is set to 1 after every new request.
	 */
	private int pokemonCounter;
	
	
	/**
	 * Class constructor. Calls initTrainerAsh() to initialise all attributes.
	 */
	public TrainerAsh() {
		pathTaken = new ArrayList<Point>();
		initTrainerAsh();
	}
	
	/**
	 * Method that initialises all attributes to default value.
	 */
	public void initTrainerAsh() {
		currentPosition = new Point(0, 0);
		if(!pathTaken.isEmpty()) { 
			pathTaken.clear(); 
			pathTaken.add(currentPosition.getLocation());
		}
		pokemonCounter = 1;
	}

		
	/**
	 * Getter for pokemon counter attribute.
	 * @return Caught pokemon counter.
	 */
	public int getPokemonCounter() {
		return pokemonCounter;
	}

	
	/**
	 * Method that changes current position of trainer Ash, moving him in a CardinalDirection passed as argument.
	 * @param direction Enum representation of cardinal direction.
	 */
	public void moveInDirection(CardinalDirection direction) {
		Point movement = direction.getVector();
		currentPosition.setLocation(
				currentPosition.getX() + movement.getX(), 
				currentPosition.getY() + movement.getY());
	}
	
	
	/**
	 * Method that receives a String input and process it, moving trainer Ash in the grid and calculating number of pokemons caught.
	 * @param newPath String representing trainer Ash path [e.g.:NSOEEN].
	 */
	public void catchPokemons(String newPath) {
		initTrainerAsh();
		for (int i = 0; i < newPath.length(); i++) {
			String possibleDirection = newPath.substring(i, i+1);
			if( CardinalDirection.isDirection(possibleDirection) ) {
				CardinalDirection direction = CardinalDirection.getDirectionFromString(possibleDirection);
				moveInDirection(direction);
				if(!pathTaken.contains(currentPosition)) {
					pokemonCounter++;
					pathTaken.add(currentPosition.getLocation());
				}
			}
		}
	}
	
	
	/**
	 * Function that return the number of pokemons caught in String format.
	 * It is prepared for internationalization.
	 * @return String information of number of pokemon caught.
	 */
	public String getPokemonsString() {
		String pokemonString = Messages.getString("TreinerAsh.ashCaught") + pokemonCounter;
		if(pokemonCounter == 1) {
			pokemonString = pokemonString + Messages.getString("TreinerAsh.pokemonSingular");
		} else {
			pokemonString = pokemonString + Messages.getString("TreinerAsh.pokemonPlural");
		}
		return pokemonString;
	}
	
}