package Assignment4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Collections;

public class ConcordanceDataManager implements ConcordanceDataManagerInterface{
	private ArrayList<String> myList;
	 /**
	    * 
	    * Display the words in Alphabetical Order followed by a :, 
	    * followed by the line numbers in numerical order, followed by a newline
	    * here's an example:
	    * after: 129, 175
	    * agree: 185
	    * agreed: 37
	    * all: 24, 93, 112, 175, 203
	    * always: 90, 128
	    * 
	    * @param input a String (usually consist of several lines) to 
	    * make a concordance of
	    * 
	    * @return an ArrayList of Strings.  Each string has one word,
	    * followed by a :, followed by the line numbers in numerical order,
	    * followed by a newline.
	    */
	   public ArrayList<String> createConcordanceArray(String input){
		   String[] lineArray = input.split("\n");
		   String[] sentence; 
		   ConcordanceDataStructure concordance = new ConcordanceDataStructure(input.split("\\s+").length);
		   ArrayList<String> myList = new ArrayList<>();
		   int lineNumber = 0;
		   for(int i = 0; i < lineArray.length; i++) {
			   sentence = lineArray[i].split("[\\s,.]+");//"[^\\w' ]"   "[\\s,.]+"  \\r?\\n
			   
			   lineNumber++;
			   for(int j = 0; j < sentence.length; j++) {
				   concordance.add(sentence[j].toLowerCase(), lineNumber);
			   }
		   }
		  
		   myList = concordance.showAll();
		   return myList;
	   }
	   
	   /**
	    * Creates a file that holds the concordance  
	    * 
	    * @param input the File to read from
	    * @param output the File to write to
	    *  
	    * Following is an example:
	    * 
		* about: 24, 210
		* abuse: 96
		* account: 79
		* acknowledged: 10
		* 
	    * @return true if the concordance file was created successfully.
	    * @throws FileNotFoundException if file not found
	    */
	   public boolean createConcordanceFile(File input, File output) throws FileNotFoundException{
		   Scanner sc = new Scanner(input);
		   PrintWriter writer = new PrintWriter(output);
		   String inputString = "";
		   String outputString = "";
		   ArrayList<String> orderedList = new ArrayList<>();  
		   
		   while(sc.hasNext()) {
			   inputString += sc.nextLine() + "\n";
		   }
		   
		   orderedList = createConcordanceArray(inputString);
		   for(int i = 0; i < orderedList.size(); i++) {
			   outputString += orderedList.get(i);
		   }
		   writer.print(outputString);
		   sc.close();
		   writer.close();
		   return true;
	   }
}
