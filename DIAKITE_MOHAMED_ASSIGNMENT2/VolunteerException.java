package Assignment2;

/**
 * A class VolunteerException extends RuntimExceptions
 * @author Moe Diakite
 *
 */
public class VolunteerException extends RuntimeException{
	/**
	 * A default constructor with a default message
	 */
	public VolunteerException() {
		this("Volunteer Queue is full ");
	}
	/**
	 * A parametized constructor
	 * @param message
	 */
	public VolunteerException(String message) {
		super(message);
	}
}
