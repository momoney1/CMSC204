package Assignment2;

/**
 * A class RecipientException extends RuntimExceptions
 * @author Moe Diakite
 *
 */
public class RecipientException extends RuntimeException{
	/**
	 * A default constructor with a default message
	 */
	public RecipientException() {
		this("The Recipent Queue is Full ");
	}
	
	/**
	 * A parametized constructor
	 * @param message
	 */
	public RecipientException(String message) {
		super(message);
	}
}
