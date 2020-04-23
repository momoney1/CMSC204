package Assignment5;

public class TreeNode<T> {
	private T data;
	private TreeNode<T> leftChild;
	private TreeNode<T> rightChild;
	
	public TreeNode(T dataNode) {
		data = dataNode;
		leftChild = null;
		rightChild = null;
	}
	
	public TreeNode(TreeNode<T> node) {
		data = node.getData();
		System.out.println(data + " ");
		
		if(node.hasLeftChild()) {
			leftChild = copy(node.leftChild);
		}
		if(node.hasRightChild()) {
			rightChild = copy(node.rightChild);
		}
		
		node.data = null; //to maintain only one reference to the node's data
		node.leftChild = null;
		node.rightChild = null;
		//use copy constructor to copy the left and right child such as leftChild = node.leftChild.copy()
	}
	
	public TreeNode<T> getLeftChild(){
		return leftChild;
	}
	
	public TreeNode<T> getRightChild(){
		return rightChild;
	}
	
	public void setLeftChild(TreeNode<T> leftChild) {
		this.leftChild = leftChild;
	}
	
	public void setRightChild(TreeNode<T> rightChild) {
		this.rightChild = rightChild;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T dataNode) {
		data = dataNode;
	}
	
	public boolean hasLeftChild() {
		return leftChild != null;
	}
	public boolean hasRightChild() {
		return rightChild != null;
	}
	
	
	//Assertion node is not null
	private TreeNode<T> copy(TreeNode<T> node){
		TreeNode<T> copyTree = new TreeNode<>(node.getData());
		
		if(node.hasLeftChild()) {
			copyTree.leftChild = copy(node.leftChild);
		}
		if(node.hasRightChild()) {
			copyTree.rightChild = copy(node.rightChild);
		}
		
		return copyTree;
	}
}
