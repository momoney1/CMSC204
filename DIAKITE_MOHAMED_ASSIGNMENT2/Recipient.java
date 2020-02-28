package Assignment2;

/**
 * A class called Recipient for creating Recipient type objects
 * @author Moe Diakite
 *
 */
public class Recipient{
	private String name;
	
	/**
	 * A constructor that uses a parameter value to initialize the name field
	 * @param name
	 */
	public Recipient(String name) {
		this.name = name;
	}
	/**
	 * A method that sets the field name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * A method that retrieves the name field
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * A method that returns the name string
	 * @return name
	 */
	public String toString() {
		return name;
	}
}
