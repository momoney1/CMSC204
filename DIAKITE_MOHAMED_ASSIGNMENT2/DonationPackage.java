package Assignment2;

/**
 * A class of donated packages
 * @author Moe Diakite
 *
 */
public class DonationPackage {
private String description;
private double weight;

/**
 * A constructor that accepts two arguments, which are used to initialize the corresponding field variables
 * @param description
 * @param weight
 */
public DonationPackage(String description, double weight) {
	this.description = description;
	this.weight = weight;
}
/**
 * A method that determines whether or not a package weight is too heavy or not
 * @return true or false
 */
public boolean isHeavy() {
	if(weight >= 20)
	return true;
	
	return false;
}
/**
 * A method that uses it's parameter value to set the value of the corresponding field value
 * @param description
 */
public void setDescription(String description) {
	this.description = description;
}
/**
 * A method that provides the description of a package
 * @return description
 */
public String getDescription() {
	return description;
}
/**
 * A method that uses it's parameter value to set the value of the weight field
 * @param weight
 */
public void setWeight(double weight) {
	this.weight = weight;
}
/**
 * A method that provides the weight of the package
 * @return weight
 */
public double getWeight() {
	return weight;
}
/**
 * A method that provides the description of the package
 */
public String toString() {
	return description;
}
}
