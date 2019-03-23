package pminds_pokemon.resources;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * @author acaldeira
 *
 */
public class Messages {
	
	
	private static final String BUNDLE_NAME = "pminds_pokemon.resources.messages";
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	
	private Messages() {}

	
	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
	
	
	public static ResourceBundle getResourceBundle() {
		return RESOURCE_BUNDLE;
	}
}
