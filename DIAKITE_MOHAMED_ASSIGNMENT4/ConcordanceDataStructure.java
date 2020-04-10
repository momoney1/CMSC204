package Assignment4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class ConcordanceDataStructure implements ConcordanceDataStructureInterface{
	   private ConcordanceDataElement[] hashTable;
	   private int numOfWords;
	   private String test;
	   private int size;
	   
	   public ConcordanceDataStructure(int num) {
		   size = num;
		   hashTable = new ConcordanceDataElement[size]; 
	   }
	   public ConcordanceDataStructure(String test, int size) {
		   this.test = test;
		   this.size = size;
		   hashTable = new ConcordanceDataElement[this.size];
	   }
	  /**
	    * Returns the size of the ConcordanceDataStructure (number of indexes in the array)
	    */
	   public int getTableSize() {
		   return size;
	   }
	   
	   /**
	    * Returns an ArrayList of the words at this index
	    * [0] of the ArrayList holds the first word in the "bucket" (index)
	    * [1] of the ArrayList holds the next word in the "bucket", etc.
	    * This is used for testing
	    * @param index location within the hash table
	    * @return an Arraylist of the words at this index
	    */
	   public ArrayList<String> getWords(int index){
		   ArrayList<String> wordsList = new ArrayList<String>();
		   wordsList.add(hashTable[index].getWord());
		   return wordsList;
	   }
	   
	   /**
	    * Returns an ArrayList of the Linked list of page numbers for each word at this index
	    * [0] of the ArrayList holds the LinkedList of page numbers for the first word in the "bucket" (index)
	    * [1] of the ArrayList holds the LinkedList of page numbers for next word in the "bucket", etc.
	    * This is used for testing
	    * @param index location within the hash table
	    * @return an ArrayList of the Linked list of page numbers for each word at this index
	    */
	   public ArrayList<LinkedList<Integer>> getPageNumbers(int index){
		   ArrayList<LinkedList<Integer>> intList = new ArrayList<LinkedList<Integer>>();
		   intList.add(hashTable[index].getList());
		   return intList;
	   }
	   //Type mismatch: cannot convert from LinkedList<Integer> to ArrayList<LinkedList<Integer>>
	   //    List<String> list = new ArrayList<String>(linkedlist);

	   /** 
	    * Use the hashcode of the ConcordanceDataElement to see if it is 
	    * in the hashtable.
	    * 
	    * If the word does not exist in the hashtable - Add the ConcordanceDataElement 
	    * to the hashtable. Put the line number in the linked list
	    *  
	    * If the word already exists in the hashtable
	    * 1. add the line number to the end of the linked list in the ConcordanceDataElement 
	    * (if the line number is not currently there).  
	    * 
	    * @param word the word to be added/updated with a line number.
	    * @param lineNum the line number where the word is found
	    */
   public void add(String word, int lineNum) {
	   if(word.length() > 2 && word.equalsIgnoreCase("and") == false && word.equalsIgnoreCase("the") == false) {// string validation
		   ConcordanceDataElement newWord = new ConcordanceDataElement(word);
		   int hashIndex = newWord.hashCode() % hashTable.length; //here is where the compression is done
		   int offSet = 19; //prime number
		   
		   while(hashIndex < 0)
			   hashIndex = (hashIndex + offSet) % hashTable.length; //validate hash value to fit into array
		   
		   
		   while(hashTable[hashIndex] != null) {
			   if(hashTable[hashIndex].getWord().equals(newWord.getWord())) {
				   for(int i = 0; i < hashTable[hashIndex].getList().size(); i++) {
					   if(lineNum == hashTable[hashIndex].getList().get(i)) {
						   return;
					   }
				   }
				   hashTable[hashIndex].addPage(lineNum);
				   return;
			   }else {
				   hashIndex = (hashIndex + offSet)% hashTable.length;
			   }
		   }
		   newWord.addPage(lineNum);
		   hashTable[hashIndex] = newWord;
		   numOfWords++;
		   return;
		   
	   }
   }
   
   /** 
    * Display the words in Alphabetical Order followed by a :, 
    * followed by the line numbers in numerical order, followed by a newline
    * here's an example:
    * after: 129, 175
	   * agree: 185
    * agreed: 37
    * all: 24, 93, 112, 175, 203
    * always: 90, 128
	   * 
    * @return an ArrayList of Strings.  Each string has one word,
    * followed by a :, followed by the line numbers in numerical order,
    * followed by a newline.
    */
   public ArrayList<String> showAll(){ //have the manager class call this method from inside create concordance array
	   ArrayList<String> orderedList = new ArrayList<>();
	   String[] beforeOrder = new String[numOfWords];
	   for(int i = 0, j = 0; i < hashTable.length; i++) {
		   if(hashTable[i] != null) {
			   beforeOrder[j] = hashTable[i].toString(); 
			   j++;
		   }     
	   }
	   Arrays.sort(beforeOrder);
	   orderedList = new ArrayList<>(Arrays.asList(beforeOrder));
	   return orderedList;
   }
}
