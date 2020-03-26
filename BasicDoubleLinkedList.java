package Assignment3;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * This generic double singly-linked list relies on a head (reference to first element of the list) and 
 * tail (reference to the last element of the list) where the last node points to the first element of the list. 
 * Both the head and the tail are set to null when the list is empty. Both point to the same element when there 
 * is only one element in the list, and now the element’s “next” reference points to itself. 
 * @author Moe Diakite
 *
 * @param <T>
 */
public class BasicDoubleLinkedList<T> implements Iterable<T>{
	protected Node firstNode; //represents the node at the front of the list
	protected Node lastNode; //represents the node at the back of the list
	protected int numberOfEntries; //represents the number of entries in the list
	
	/**
	 * Constuctor that initializes fields to default values
	 */
	public BasicDoubleLinkedList() {
		firstNode = null;
		lastNode = null;
		numberOfEntries = 0;
	}
	
	/**
	 * Adds an element to the end of the list
	 * @param data
	 * @return reference to the current object
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data) {
		Node newNode = new Node(data);
		newNode.next = firstNode;
		newNode.prev = lastNode;
		if(numberOfEntries == 0) {
			lastNode = newNode;
			firstNode = lastNode;
			lastNode.next = firstNode;
			firstNode.next = lastNode;
		}else {
			lastNode.next = newNode;
			lastNode = newNode;
		}
		numberOfEntries++;
		return this;
	}
	
	/**
	 * Adds element to the front of the list.
	 * @param data
	 * @return reference to the current object
	 * 
	 */
	public BasicDoubleLinkedList<T> addToFront(T data) {
		Node newNode = new Node(data);
		Node prevNode;
		if(numberOfEntries == 0) {
			firstNode = newNode;
			lastNode = newNode;
			firstNode.next = lastNode;
			lastNode.next = firstNode;
			firstNode.prev = lastNode;
			lastNode.prev = firstNode;
		}else {
			newNode.next = firstNode;
			newNode.prev = lastNode;
			lastNode.next = newNode;
			firstNode.prev = newNode;
			firstNode = newNode;
		}
		numberOfEntries++;
		
		return this;
	}
	/**
	 * Removes the first instance of the targetData from the list
	 * @param targetData
	 * @param comparator
	 * @return data element or null
	 */
	public T remove(T targetData, java.util.Comparator<T> comparator) {
		Node currentNode = firstNode;
		Node prevNode = firstNode.prev;
		T result;
		if(numberOfEntries > 0) {
			if(comparator.compare(targetData, firstNode.data) == 0) {
				result = (T) firstNode.data;
				firstNode.data = null;
				firstNode = firstNode.next;
				lastNode.next = firstNode;
				firstNode.prev = lastNode;
				lastNode.prev = firstNode;
				numberOfEntries--;
				return result;
			}
			while(comparator.compare(targetData, currentNode.data) != 0) {
				currentNode = currentNode.next;
			}
			if(comparator.compare(targetData, currentNode.data) == 0) {
				if(comparator.compare(targetData, lastNode.data) == 0 ) {
					result = (T) currentNode.data;
					prevNode = currentNode.prev;
					prevNode.next = currentNode.next;
					currentNode.data = null; //= prevNode.data
					lastNode = lastNode.prev;
					numberOfEntries--;
					return  result;
				}else {
					result = (T) currentNode.data;
					prevNode = currentNode.prev;
					prevNode.next = currentNode.next;
					currentNode.data = null; //= prevNode.data
					numberOfEntries--;
					return  result;
				}
				
			}
		}
		return null;
	}
	
	/**
	 * Returns but does not remove the first element from the list. If there are no elements the method returns null.
	 * @return data element or null
	 */
	public T getFirst() {
		if(firstNode != null) {
			T result = firstNode.data;
			return result;
		}else {
			return null;
		}
	}
	/**
	 * Returns but does not remove the last element from the list. If there are no elements the method returns null
	 * @return data element or null
	 */
	public T getLast() {
		if(lastNode != null) {
			T result = lastNode.data;
			return result;
		}else {
			return null;
		}
	}
	
	/**
	 * This method just returns the value of the instance variable you use to keep track of size. 
	 * @return the size of the list
	 */
	public int getSize() {
		return numberOfEntries;
	}
	/**
	 * Removes and returns the first element from the list. If there are no elements the method returns null. 
	 * @return data element or null
	 */
	public T retrieveFirstElement() {
		if(numberOfEntries > 0) {
			T result = firstNode.data;
			firstNode.data = null;
			firstNode = firstNode.next;
			firstNode.prev = lastNode;
			lastNode.next = firstNode;
			numberOfEntries--;
			return result;
		}
		else return null;
	}
	
	/**
	 * Removes and returns the last element from the list. If there are no elements the method returns null.
	 * @return data element or null
	 */
	public T retrieveLastElement() {
		Node previousNode;
		if(lastNode != null) {
			previousNode = lastNode.prev;
			T result = lastNode.data;
			lastNode.data = null;
			lastNode = previousNode;
			lastNode.next = firstNode;
			firstNode.prev = lastNode;
			numberOfEntries--;
			return result;
		}
		else return null;
	}
	/**
	 * A method that creates an instance of an iterator for the class
	 * returns IteratorForDoubleLinkedList
	 * @throws java.lang.UnsupportedOperationException, java.util.NoSuchElementException
	 */
	public ListIterator<T> iterator() throws java.lang.UnsupportedOperationException, java.util.NoSuchElementException{
		return new IteratorForDoubleLinkedList();
	}
	
	/**
	 * Returns an arraylist of the items in the list from head of list to tail of list 
	 * @return an arraylist of the items in the list
	 */
	public ArrayList<T> toArrayList() {
		ArrayList<T> myList =  new ArrayList<>();
		Node currentNode = firstNode;
		for(int i = 0; i < numberOfEntries; i++) {
			myList.add((T) currentNode.data);
			currentNode = currentNode.next;
		}
		return myList;
	}
	
	/**
	 * A private method that can retrieve a node at a specific position in the list
	 * @param givenPosition
	 * @return node at given position
	 */
	private Node getNodeAt(int givenPosition) {
		Node currentNode = null;
		if(firstNode != null && givenPosition <= numberOfEntries && 1 <= givenPosition) {
			  currentNode =  firstNode;
			for(int i = 1; i <= givenPosition; i++) {
				currentNode = currentNode.next;
			}
		}
		return  currentNode;
	}
	
	/**
	 * A protected inner class that produces instances of iterators for the BasicDoubleLinked list, may be
	 * accesses by subclasses of BasicDoubleLinkedList
	 * @author Moe Diakite
	 *
	 * @param <T>
	 */
	protected class IteratorForDoubleLinkedList<T> implements Iterator<T>, ListIterator<T>{
		protected Node nextNode; //represents the next node in the chain
		protected Node previousNode; //represents the previous node in the chain
		protected int count = 0; //keeps track of the position of the iterator
		
		/**
		 * Constructor that initializes fields
		 */
		protected IteratorForDoubleLinkedList() {
			count = 0;
			nextNode = firstNode;
			previousNode = lastNode; 
		}

        /**
         * retrieves the data in the  previous node in the list
         * @return data element 
         * @throws NoSuchElementException
         */
		public T previous(){
			if(hasPrevious()) {
				T result = (T) previousNode.getData();
				nextNode = previousNode;
				previousNode = previousNode.prev;
				count--;
				return result;
			}else {
				 throw new NoSuchElementException("Illegal call to previous()");
			}
		}
		
		/**
		 * retrieves the data in the next node in the list
		 * 
		 */
		public T next() {
			if(hasNext()) {
				T result = (T) nextNode.getData();
				previousNode = nextNode;
				nextNode = nextNode.next;
				count++;
				return result;
			}
			else throw new NoSuchElementException("Illegal call to next()");
		}
		
		/**
		 * verifies the list to see if there is a next node
		 * @return true or false 
		 * @throws NoSuchElementException
		 */
		public boolean hasNext() {
				return count < numberOfEntries;
		}
		
		/**
		 * verifies the lsit to see if there is a previous node
		 * @return true or false
		 * @throws NoSuchElementException
		 */
		public boolean hasPrevious() {
				return count > 0;	
		}
		
		/**
		 * @throws UnsupportedOperationException
		 */
		public void remove() {
			throw new UnsupportedOperationException("remove() is not supported by this iterator");
		}
		
		/**
		 * @throws UnsupportedOperationException
		 */
		public int nextIndex() {
			throw new UnsupportedOperationException("nextIndex() is not supported by this iterator");
		}
		
		/**
		 * @throws UnsupportedOperationException
		 */
		public int previousIndex() {
			throw new UnsupportedOperationException("nextIndex() is not supported by this iterator");

		}
		/**
		 * @throws UnsupportedOperationException
		 */
		public void add(T data) {
			throw new UnsupportedOperationException("remove() is not supported by this iterator");

		}
		/**
		 * @throws UnsupportedOperationException
		 */
		public void set(T data) {
			throw new UnsupportedOperationException("remove() is not supported by this iterator");

		}
	}
	/**
	 * A protected node class used to create instances of a Node element for the linked list
	 * @author Moe Diakite
	 *
	 */
	protected class Node{
		T data; //represents the data in the node
		Node next; //represents the next node
		Node prev; //represents the previous node
	
		/**
		 * A constructor that initializes the data field with the argument
		 * @param data
		 */
		public Node(T data) {
			this.data = data;
		}
		
		/**
		 * retrieves the data field
		 * @return data
		 */
		public T getData() {
			return data;
		}
		
		
	}

}
