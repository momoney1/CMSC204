package Assignment1;

/**
 * A class representing an exception that is thrown when passwords don't match, extends from RuntimeException class
 * @author Moe Diakite
 *
 */
public class UnmatchedException extends RuntimeException{
	/**
	 * A no arg constructor that invokes overloaed version
	 */
	public UnmatchedException() {
		this("The passwords do not match");
	}
	/**
	 * A constructor that accepts one string argument as parameter
	 * @param message
	 */
	public UnmatchedException(String message) {
		super(message);
	}
}
