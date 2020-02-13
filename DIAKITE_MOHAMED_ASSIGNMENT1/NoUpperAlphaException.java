package Assignment1;
/**
 * A class representing an exception that is thrown when there is no uppercase letters
 * in the password at all, extends from RuntimeException class
 * @author Moe Diakite
 *
 */
public class NoUpperAlphaException extends RuntimeException{
	/**
	 * A no arg constructor that invokes overloaed version
	 */
	public NoUpperAlphaException() {
		this("The password must contain at least one uppercase alphabetic character");
	}
	/**
	 * A constructor that accepts one string argument as parameter
	 * @param message
	 */
	public NoUpperAlphaException(String message) {
		super(message);
	}
}
