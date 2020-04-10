package Assignment4;
import java.util.LinkedList;

/**
 * This class is the data element class for the ConcordanceDataStructure It consists of a word (String) and
 *  a list of page numbers (LinkedList) 
 * @author Moe Diakite
 *
 */
public class ConcordanceDataElement implements Comparable<ConcordanceDataElement>{
	//implementing "Comparable " allows for instances of this class to be used by collections sort() method
	
	private String word; //represents the actual word read from file or string 
	private LinkedList<Integer> list; //list of integers to represent the line numbers associated with the particular word
	private static int PRIME_NUMBER = 31; //the offset value used by the hash function
	
	/**
	 * Consturctor
	 * @param word
	 */
	public ConcordanceDataElement(java.lang.String word) {
		this.word = word;
		this.hashCode();
		list = new LinkedList<Integer>();
	}
	/**
	 * Add a line number to the linked list if the number doesn't exist in the list 
	 * @param lineNum
	 */
	public void addPage(int lineNum) { 
		list.add(lineNum);
	}
	/**
	 * Implentation of comparable method since the interface is being inherited from
	 */
	public int compareTo(ConcordanceDataElement arg0){ 
		return 0;
	}
	
	/**
	 * Returns the linked list of integers that represent the line numbers 
	 * @return list
	 */
	public LinkedList<Integer> getList(){
		return list;
	}
	
	/**
	 * Return the word portion of the Concordance Data Element 
	 * @return word
	 */
	public String getWord() {
		return word;
	}
	
	/**
	 * Returns the hashCode. 
	 * @return hash 
	 */
	public int hashCode() {
		int hash = 0;
		for(int i = 0; i < word.length(); i++) {
			hash = word.charAt(i) * PRIME_NUMBER + hash;
		}
		return hash;
	}
	
	/**
	 * Returns the word followed by page numbers Returns a string in the following 
	 * format: word: page num, page num Example: after: 2,8,15 
	 * @return the word portion of the Concordance Data Element
	 */
	public String toString() {
		String lineNumbers = "";
		for(int i = 0; i < list.size(); i++) {
			if(lineNumbers.length() < 1) { // adds the first line number
				lineNumbers += list.get(i);
			}else {
				lineNumbers += ", " + list.get(i); //adds all remaining line numbers if there is more than 1
			}
			
		}
		return word + ": "+ lineNumbers + "\n"; //concats the word with the string of line numbers
	}
}
