package Assignment5;

import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String>{
	private TreeNode<String> root;
	
	
	public MorseCodeTree() {
		buildTree();
		
	}
	/**
	 * Returns a reference to the root
	 * @return reference to root
	 */
	public TreeNode<String> getRoot(){
		return root;
	}
	
	/**
	 * sets the root of the Tree
	 * @param newNode a TreeNode<T> that will be the new root
	 */
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;
	}
	
	
	
	/**
	 * Adds result to the correct position in the tree based on the code
	 * This method will call the recursive method addNode
	 * 
	 * @param code the code for the new node to be added
	 * @return the linkedConverterTree with the new node added
	 */
	public LinkedConverterTreeInterface<String> insert(String code, String result){
		addNode(root, code, result);
		return this;
	}
		
	
	/**
	 * This is a recursive method that adds element to the correct position 
	 * in the tree based on the code.
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of addNode
	 * @param letter the data of the new TreeNode to be added
	 */
	public void addNode(TreeNode<String> root, String code, String letter) {
		//count code's length first, will make it faster to reach particular level based
		//keep splitting the string code during each recursive call and check the first character
		//place the letter at each recursive stop
		if(code.length() > 1 && code.charAt(0) == '.') {
			addNode(root.getLeftChild(), code.substring(1), letter);
			
		}
		
		if(code.length() > 1 && code.charAt(0) == '-') {
			addNode(root.getRightChild(), code.substring(1), letter);
		}
		
		if(code.length() == 1 && code.charAt(0) == '.') {
			root.setLeftChild(new TreeNode<String>(letter));
			//System.out.println(root.getLeftChild().getData() + " line 67 codeTree");
		}
		
		if(code.length() == 1 && code.charAt(0) == '-') {
			root.setRightChild(new TreeNode<String>(letter));
			//System.out.println(root.getRightChild().getData() + " line 73 tree");
		}
	}
	
	
	
	/**
	 * Fetch the data in the tree based on the code
	 * This method will call the recursive method fetchNode
	 * 
	 * @param code the code that describes the traversals within the tree
	 * @return the result that corresponds to the code
	 */
	public String fetch(String code) {
		return fetchNode(root, code);
	}
		
	
	
	/**
	 * This is the recursive method that fetches the data of the TreeNode
	 * that corresponds with the code
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of fetchNode
	 * @return the data corresponding to the code
	 */
	public String fetchNode(TreeNode<String> root, String code) {
		String data = "";
		if(code.length() > 1 && code.charAt(0) == '.') {
			return fetchNode(root.getLeftChild(), code.substring(1));
		}
		
		if(code.length() > 1 && code.charAt(0) == '-') {
			return fetchNode(root.getRightChild(), code.substring(1));
		}
		
		if(code.length() == 1 && code.charAt(0) == '.') {
			 data = root.getLeftChild().getData();
			 System.out.println(data + " line 111 tree");
		}
		if(code.length() == 1 && code.charAt(0) == '-') {
			 data = root.getRightChild().getData();
			 System.out.println(data + " line 115 tree");
		}
		
		return data;
	}
	
	
	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @param data data of node to be deleted
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException{
		throw new UnsupportedOperationException("This operation is not supported for a LinkedConverterTree");
	}
		
	
	
	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException{
		throw new UnsupportedOperationException("This operation is not supported for a LinkedConverterTree");
	}
		

	/**
	 * This method builds the LinkedConverterTree by inserting TreeNodes<T>
	 * into their proper locations
	 * 
	 */
	public void buildTree() {
		root = new TreeNode<String>(" "); //the insert method will traverse the tree based on the code characters
	       insert(".", "e");
	       insert("-", "t");
	      
	       insert("..", "i");
	       insert(".-", "a");
	       insert("-.", "n");
	       insert("--", "m");
	      
	       insert("...", "s");
	       insert("..-", "u");
	       insert(".-.", "r");
	       insert(".--", "w");
	       insert("-..", "d");
	       insert("-.-", "k");
	       insert("--.", "g");
	       insert("---", "o");

	       insert("....", "h");
	       insert("...-", "v");
	       insert("..-.", "f");
	       insert(".-..", "l");
	       insert(".--.", "p");
	       insert(".---", "j");
	       insert("-...", "b");
	       insert("-..-", "x");
	       insert("-.-.", "c");
	       insert("-.--", "y");
	       insert("--..", "z");
	       insert("--.-", "q");  
		
	}
	


	/**
	 * Returns an ArrayList of the items in the linked converter Tree in LNR (Inorder) Traversal order
	 * Used for testing to make sure tree is built correctly
	 * @return an ArrayList of the items in the linked Tree
	 */
	public ArrayList<String> toArrayList(){
		ArrayList<String> listOfItems = new ArrayList<String>();
	       LNRoutputTraversal(root, listOfItems);      
	       return listOfItems;
	}
	
	
	/**
	 * The recursive method to put the contents of the linked converter tree in an ArrayList<T> 
	 * LNR (Inorder)
	 * @param root the root of the tree for this particular recursive instance
	 * @param list the ArrayList that will hold the contents of the tree in LNR order
	 */
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if(root != null && root.hasLeftChild()) 
			LNRoutputTraversal(root.getLeftChild(), list);
		
		list.add(root.getData());
			
		 if(root != null && root.hasRightChild()) {
			LNRoutputTraversal(root.getRightChild(), list);
		}
	}
}
