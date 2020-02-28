package Assignment2;

/**
 * A class ContainerException extends RuntimExceptions
 * @author Moe Diakite
 *
 */
public class ContainerException extends RuntimeException{
	/**
	 * A default constructor with a default message
	 */
	public ContainerException() {
		this("The Container Stack is Full ");
	}
	
	/**
	 * A parametized constructor
	 * @param message
	 */
	public ContainerException(String message) {
		super(message);
	}
}
