package pminds_pokemon;

import java.awt.Point;

/**
 * @author acaldeira
 *
 */
public enum CardinalDirection {
	
	
	NORTH ("N", new Point(0, 1)),
	SOUTH ("S", new Point(0, -1)),
	EAST ("E", new Point(1, 0)),
	WEST ("O", new Point(-1, 0));
		
	/**
	 * String representation of cardinal direction [N,S,E,O].
	 */
	private String direction;
	/**
	 * Vector representation of cardinal direction [e.g. N=(0,1)].
	 */
	private Point vector;
	
	
	/**
	 * Class constructor.
	 * @param diretion String representation of cardinal direction [N,S,E,O].
	 * @param vector Vector representation of cardinal direction [e.g. N=(0,1)].
	 */
	private CardinalDirection(String diretion, Point vector) {
		this.vector = vector;
		this.direction = diretion;
	}

	/**
	 * Getter for direction attribute.
	 * @return String representation of cardinal direction [N,S,E,O].
	 */
	public String getDiretion() {
		return direction;
	}
		
	/**
	 * Setter for direction attribute.
	 * @param diretion String representation of cardinal direction [N,S,E,O].
	 */
	public void setDiretion(String diretion) {
		this.direction = diretion;
	}

	/**
	 * Getter for vector attribute.
	 * @return  Vector representation of cardinal direction [e.g. N=(0,1)].
	 */
	public Point getVector() {
		return vector;
	}

	/**
	 * Setter for vector attribute.
	 * @param vector  Vector representation of cardinal direction [e.g. N=(0,1)].
	 */
	public void setVector(Point vector) {
		this.vector = vector;
	}
	
	/**
	 * Static function that returns a CardinalDirection given a String representation of its direction.
	 * Returns null if String parameter doesn't match any known direction.
	 * @param possibleDirection String representation of cardinal direction [N,S,E,O].
	 * @return Enum representation of cardinal direction.
	 */
	public static CardinalDirection getDirectionFromString(String possibleDirection) {
		for(CardinalDirection direction: CardinalDirection.values()) {
			if(direction.getDiretion().equals(possibleDirection)
					|| direction.getDiretion().equals(possibleDirection.toUpperCase())) {
				return direction;
			}
		}
		return null;
	}
	
	/**
	 * Static function thats returns true if String parameter matches any known direction.
	 * @param possibleDirection String representation of cardinal direction [N,S,E,O].
	 * @return Validation if String parameter matches any know direction.
	 */
	public static boolean isDirection(String possibleDirection) {
		for(CardinalDirection direction: CardinalDirection.values()) {
			if(direction.getDiretion().equals(possibleDirection)
					|| direction.getDiretion().equals(possibleDirection.toUpperCase())) {
				return true;
			}
		}
		return false;
	}
	
}