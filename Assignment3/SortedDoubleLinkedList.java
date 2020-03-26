package Assignment3;
import java.util.Comparator;
import java.util.ListIterator;

import Assignment3.BasicDoubleLinkedList.Node;

import java.util.Iterator;
import java.util.Collections;

/**
 *A class that implements a generic sorted double list using a provided Comparator. It extends BasicDoubleLinkedList
 *class. 
 *@author Moe Diakite
 *@param <T>
 */
public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T>{
	private Comparator<T> comparator; //represents a comparator object for the list
	
	/**
	 *Creates an empty list that is associated with the specified comparator.
	 * @param comparator
	 */
	public SortedDoubleLinkedList(Comparator<T> comparator) {
		this.comparator = comparator;
	}
	
	/**
	 * creates a new instance of a ListIterator class, by invoking the superclass version of the equivalent method
	 * @return ListIterator object
	 */
	public ListIterator<T> iterator() {
		return super.iterator();
	}
	
	/**
	 * Inserts the specified element at the correct position in the sorted list.
	 * @param data
	 * @return
	 */
	public SortedDoubleLinkedList<T> add(T data){
		Node nodeBefore;
		Node newNode = new Node(data);
		
		if(numberOfEntries == 0) {
			firstNode = newNode;
			lastNode = newNode;
			firstNode.next = lastNode;
			lastNode.next = firstNode;
			firstNode.prev = lastNode;
			lastNode.prev = firstNode;
			numberOfEntries++;
		}else if(numberOfEntries == 1){
			if(comparator.compare(data, firstNode.data) > 0) {
				newNode.next = lastNode;
				newNode.prev = firstNode;
				firstNode.next = newNode;
				firstNode.prev = newNode;
				lastNode = newNode;
				numberOfEntries++;

			}else {
				newNode.next = firstNode;
				newNode.prev = lastNode;
				lastNode.next = newNode;
				lastNode.prev = newNode;
				firstNode = newNode;
				numberOfEntries++;
			}
		}else {
			int i;
			Node currentNode = firstNode;
			for(i = 0; i < numberOfEntries; i++) {
				if(comparator.compare(data, currentNode.data) > 0) {
					currentNode = currentNode.next;
				}else {
					break;
				}
			}
			if(i == numberOfEntries || i == 0) {
				newNode.next = firstNode;
				newNode.prev = lastNode;
				lastNode.next = newNode;
				firstNode.prev = newNode;
				if(i == numberOfEntries)
				lastNode = newNode;
				else firstNode = newNode;
			}
			else {
				newNode.next = currentNode;
				newNode.prev = currentNode.prev;
				currentNode.prev.next = newNode;
				currentNode.prev = newNode;
			}
			numberOfEntries++;
		}
		return this;
	}
	
	/**
	 * @throws UnsupportedOperationException
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data){
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	/**
	 * @throws UnsupportedOperationException
	 */
	public BasicDoubleLinkedList<T> addToFront(T data){
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	/**
	 * Implements the remove operation by calling the super class remove method. 
	 * @param targetData, comparator
	 * @return data element 
	 */
	public T remove(T targetData, java.util.Comparator<T> comparator) {
		return super.remove(targetData, comparator);
	}

}
