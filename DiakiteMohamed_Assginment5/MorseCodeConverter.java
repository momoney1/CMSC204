package Assignment5;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;


public class MorseCodeConverter {
	private static MorseCodeTree tree = new MorseCodeTree();
	public MorseCodeConverter() {
		
	}
	
	
	/**
	 * Converts a file of Morse code into English Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’. 
	   Example: 
	   a file that contains ".... . .-.. .-.. --- / .-- --- .-. .-.. -.." 
	   string returned = "Hello World" 
	 * @param codeFile
	 * @return
	 */
	public static String convertToEnglish(java.io.File codeFile) throws FileNotFoundException {
		Scanner sc = new Scanner(codeFile);
		String code = "", modified = "";
		while(sc.hasNext()) {
			code += sc.nextLine();
		}
		//System.out.println(code.length() + " ");
		modified = convertToEnglish(code);
		return modified;
	}
	
	/**
	 * Converts Morse code into English. Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’. 
	   Example: code = ".... . .-.. .-.. --- /.-- --- .-. .-.. -.." 
	   string returned = "Hello World" 
	 * @param code
	 * @return
	 */
	public static String convertToEnglish(String code) {
		String[] codeWords = code.split("/");
		
		String result = "";
		String[] codeLetters;
		for(int i = 0; i < codeWords.length; i++) {
			codeLetters = codeWords[i].split(" ");
			
			for(int j = 0; j < codeLetters.length; j++) {
				//System.out.println(result + " line 52 converter");
				result += tree.fetch(codeLetters[j]);	
			}
			result += " ";
			System.out.println(result + " line 64 converter");
		}
		result = result.trim();
		
		return result;
	}
	
	/**
	 * returns a string with all the data in the tree in LNR order with an space in between them. Uses the 
	 * toArrayList method in MorseCodeTree It should return the data in this order: "h s v i f u e l r a p w j b d x n c k y t z g q m o" 
	   Note the extra space between j and b - that is because there is an empty string that is the root, and in the 
       LNR traversal, the root would come between the right most child of the left tree (j) and the left most child of the right tree (b). 
       This is used for testing purposes to make sure the MorseCodeTree has been built properly 
	 * @return
	 */
	public static String printTree() {
		ArrayList<String> tempTree = tree.toArrayList();
		String inOrder = "";
		for(int i = 0; i < tempTree.size(); i++) {
			if(tempTree.get(i).equals(" ") == false)
			inOrder += tempTree.get(i) + " ";
			
			if(tempTree.get(i).equals(" ")) {
				inOrder += tempTree.get(i);
			}
		}
		return inOrder;
	}
	
}
