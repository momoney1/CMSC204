package Assignment1;
/**
 * A class representing an exception that is thrown when the password
 * is less than 6 characters long, extends from RuntimeException class
 * @author Moe Diakite
 *
 */
public class LengthException extends RuntimeException{
	/**
	 * A no arg constructor that invokes overloaed version
	 */
	public LengthException() {
		this("The password must be at least 6 characters long");
	}
	/**
	 * A constructor that accepts one string argument as parameter
	 * @param message
	 */
	public LengthException(String message) {
		super(message);
	}
	
}
