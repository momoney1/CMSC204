package Assignment2;

/**
 * A generic class that implements the methods from a generic interface, uses a Stack of DonationPackage to simulate stacking and removing DonationPackages
 * to and from the container.
 * @author Moe Diakite
 *
 * @param <T>
 */
public class Container<T> implements ContainerInterface<T> {
	private static int DEFAULT_SIZE = 5;
	private MyStack<T> donationStack;
	/**
	 * A no arg constructor that creates a container of default size
	 */
	public Container() {
		this(DEFAULT_SIZE);
	}
	/**
	 * A constructor that accepts an int argument, which represents the value that will determine the size
	 * of the stack in the container
	 * @param size
	 */
	public Container(int size) {
		@SuppressWarnings("unchecked")
		MyStack<T> tempStack = new MyStack<T>(size);
		donationStack = tempStack;
	}
	/**
	 * Stacks a new donation package  in to the container
	 * @param dPackage a DonationPackage Object to be stacked to the container
	 * Return true if the package is stacked, false if the container is full
	 * @throws ContainerException("The Container is Full") if the containerSize = containerCount (stack is full)
	 */
	public boolean loadContainer(T dPackage) throws ContainerException{
		if(donationStack.push(dPackage)) {
			return true;
		}
		else {
			throw new ContainerException();
		}
	};
	
	/**
	 * Removes  a DonationPackage from the stack of packages in the container
	 * @return a DonationPackage from the stack of Packages in the container
	 * @throws ContainerException("The Container is Empty") if there is no package in the container
	 */
	public  T removePackageFromContainer() throws ContainerException{
		T top = donationStack.pop();
		if(top != null) {
		return top;
		}
		else {
			throw new ContainerException("The container is currently empty");
		}
		
	};
	/**
	 * A method that returns the size of the container 
	 * @return the size of the container stack
	 */
	public int getSize() {
		return donationStack.size();
	}
	
	/**
	 * Returns an array of the DonationPackages in the stack.  
	 * Because of type erasure by the JVM at run-time, the array of type T that the generic stack returns is an array of 
	 * type Object , i.e., Object[] temp. But since the individual elements of the array are still DonationPackages,
	 * we can copy them one by one into a new array	of type DonationPackage and cast each one to DonationPackage. 
	 * So create a new array of DonationPackages of the same length as temp, run a for-loop that casts each element 
	 * of temp to DonationPackage, and copies it to the corresponding position in the new array.  Then return the new array.
	 * 
	 * @return an array of the DonationPackages in the stack
	 */
	public DonationPackage[] toArrayPackage() throws ContainerException{
		System.out.print(" " + donationStack.size()); //stack becomes zero too early 
		if(donationStack.size() >= 0) {
			@SuppressWarnings("unchecked")
			T[] tempArray =  donationStack.toArray();
			DonationPackage[] d = new DonationPackage[donationStack.size()];
			for(int i = 0; i < d.length; i++) {
				d[i] = (DonationPackage) tempArray[i];
			}
			return d;
		}
		else {
			System.out.print("    yo");
			throw new ContainerException("The container is currently empty");
		}
		
	};
}
