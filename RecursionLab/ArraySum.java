package Lab2;
/**

 * @author Moe Diakite
 *
 */
public class ArraySum {
	/**
	 * A method that calls a recursive method to retrieve the sum of the elements in an array
	 * @param myArray
	 * @param num
	 * @return sum of array
	 */
	public int sumOfArray(Integer[] myArray, int num) {
		return sumCalculator(myArray, num);
	}
	
	/**
	 * A recursive method that retrieves the sum of an array
	 * @param myArray
	 * @param num
	 * @return
	 */
	public int sumCalculator(Integer[] myArray, int num) {
		if(num > 0) {
			 return myArray[num] + sumCalculator(myArray, num - 1); //general solution using reduced case
		}
		return myArray[num]; //base case
	}

}
