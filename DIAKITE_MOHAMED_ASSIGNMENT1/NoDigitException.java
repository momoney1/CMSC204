package Assignment1;
/**
 * A class representing an exception that is thrown when the password 
 * contains no digits at all, extends from RuntimeException class
 * @author Moe Diakite
 *
 */
public class NoDigitException extends RuntimeException{
	/**
	 * A no arg constructor that invokes overloaed version
	 */
	public NoDigitException() {
		this("The password must contain at least one digit");
	}
	/**
	 * A constructor that accepts one string argument as parameter
	 * @param message
	 */
	public NoDigitException(String message) {
		super(message);
	}
}
