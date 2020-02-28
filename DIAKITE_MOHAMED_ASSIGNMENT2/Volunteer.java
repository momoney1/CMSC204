package Assignment2;

/**
 * A class that creates instances of Volunteers
 * @author Moe Diakite
 *
 */
public class Volunteer {
	private String name;
	
	/**
	 * A constructor that uses it's parameter to initialize name field
	 * @param name
	 */
	public Volunteer(String name) {
		this.name = name;
	}
	
	/**
	 * A method that sets the name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * A method that retrieves the name
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * A method that returnes the name string
	 * @return name
	 */
	public String toString() {
		return name;
	}
}
