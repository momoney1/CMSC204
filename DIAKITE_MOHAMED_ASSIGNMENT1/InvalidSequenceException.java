package Assignment1;
/**
 * A class representing an exception that is thrown when there is more than
 * two of the same character in a sequence, extends from RuntimeException class
 * @author Moe Diakite
 *
 */
public class InvalidSequenceException extends RuntimeException{
	/**
	 * A no arg constructor that invokes overloaed version
	 */
	public InvalidSequenceException() {
		this("The password cannot contain more than two of the same character in sequence");
	}
	/**
	 * A constructor that accepts one string argument as parameter
	 * @param message
	 */
	public InvalidSequenceException(String message) {
		super(message);
	}
}
