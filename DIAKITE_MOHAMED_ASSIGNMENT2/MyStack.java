package Assignment2;

import java.util.Arrays;

/**
 * A class that creates instances of a generic data structure
 * @author Moe Diakite
 *
 * @param <T>
 */
public class MyStack <T> implements StackInterface<T>{
	private static int DEFAULT_CAPACITY;
	private static int MAX_CAPACITY = 100;
	private T[] stackArray;
	private int entries;
	int topIndex;
	T top;
	
	/**
	 * A default constructor that creates a stack with default capacity
	 */
	public MyStack() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * A constructor that creates a stack of specified size
	 * @throws IllegalStateException
	 * @param initialCapacity
	 */
	public MyStack(int initialCapacity) {
		if(initialCapacity <= MAX_CAPACITY) {
			@SuppressWarnings("unchecked")
			T[] tempStack = (T[]) new Object[initialCapacity];
			stackArray = tempStack;
			
		}
		else {
			throw new IllegalStateException("Attempt to create a stack whose size is greater than the max");
		}
		
	}
	
	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	public boolean isEmpty() {
		return entries <= 0;		
	};
	
	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	public boolean isFull() {
		return entries >= stackArray.length;
		
	};
	
	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 */
	public T pop() {
		if(!isEmpty()) {
			top = stackArray[topIndex - 1];
			topIndex--;
			entries--;
		}
		return top;
	};
	
	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	public int size() {
		return entries;// fix issue here
	};
	
	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 */
	public boolean push(T e) {
		if(!isFull()) {
			stackArray[topIndex] = e;
			//System.out.print(stackArray[topIndex].toString());
			topIndex++;
			entries++;
			return true;
		}else {
			return false;
		}
	};
	
	/**
	 * A method that resizes the size of the array if it the array becomes full of entries
	 */
	private void ensureCapacity() {
		if(topIndex >= MAX_CAPACITY) {
			stackArray = Arrays.copyOf(stackArray, stackArray.length * 2);
		}
	}
	
	/**
	 * A method that checks to make sure the proposes capacity by the client does not exceed the maximum
	 * capacity
	 * @param capacity
	 */
	private void checkCapacity(int capacity) {
		if(capacity > MAX_CAPACITY) {
			throw new IllegalStateException("Attempt to create a stack whose capcity exeeds the maximum size");
		}
	}

	/**
	 * Returns the elements of the Stack in an array, [0] is top of Stack, [1] is next in Stack, etc.
	 * @return an array of the Objects in the Stack
	 */
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[entries];
		for(int i = 0; i < result.length; i++) {
			result[i] = stackArray[i];
		}
		return result;
	};
}
