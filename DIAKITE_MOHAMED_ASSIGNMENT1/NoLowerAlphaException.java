package Assignment1;
/**
 * A class representing an exception that is thrown when there is no lowercase
 * letters in the password, extends from RuntimeException class
 * @author Moe Diakite
 *
 */
public class NoLowerAlphaException extends RuntimeException{
	/**
	 * A no arg constructor that invokes overloaed version
	 */
	public NoLowerAlphaException() {
		this("The password must contain at least one lowercase alphabetic character");
	}
	/**
	 * A constructor that accepts one string argument as parameter
	 * @param message
	 */
	public NoLowerAlphaException(String message) {
		super(message);
	}
}
