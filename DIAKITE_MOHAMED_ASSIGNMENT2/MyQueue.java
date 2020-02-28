package Assignment2;
import java.util.Arrays;

/**
 * A generic class that implements a generic interface for a queue data structure
 * @author Moe Diakite
 *
 * @param <T>
 */
public class MyQueue<T> implements QueueInterface<T> {
	private static int DEFAULT_CAPACITY = 5;
	private static int MAX_CAPACITY;
	private T[] queue;
	private int frontIndex;
	private int lastIndex;
	private T frontObject;
	private T lastObject;
	private int entries;
	
	/**
	 * A no arg constructor that creates a new queue of default capacity
	 */
	public MyQueue() {
		this(DEFAULT_CAPACITY);
	}
	
	/**
	 * A paramterized constructor that creates a new queue of specified capacity
	 * @param initialCapacity
	 */
	public MyQueue(int initialCapacity) {
		@SuppressWarnings("unchecked")
		T[] tQueue = (T[]) new Object[initialCapacity];
		//check to ensure capacity
		queue = tQueue;
	}
	/**
	 * Number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	public boolean isEmpty() {
		return entries <= 0;		
	};
	
	/**
	 * A bolean method that informs the client on whether or not the queue is full
	 * @return true or false
	 */
	public boolean isFull() {
		return entries >= queue.length;
	};
	
	/**
	 * Deletes and returns the element at the front of the Queue
	 * @throws IllegalStateException
	 * @return the element at the front of the Queue
	 */
	public T dequeue() {
		if(!isEmpty()) {
			frontObject = queue[0];
			for(int i = 0; i < entries - 1; i++) {
				queue[i] = queue[i + 1];
			}
			entries--;
			lastIndex--;
			
		}
		else {
			throw new IllegalStateException("Attempt to remove an object from an empty queue");
		}
		
		return frontObject;
	};
	
	/**
	 * Number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	public int size() {
		return entries;
	};
	
	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful, false if not
	 */
	public boolean enqueue(T e) {
		if(!isFull()) {
			queue[lastIndex] = e;
			lastIndex++;
			entries++;	
			return true;
		}
		else {
			return false;
		}
		
	}
	
	/**
	 * Returns the elements of the Queue in an array, [0] is front of Queue, [1] is next in Queue, etc.
	 * @return an array of the Object elements in the Queue
	 */
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[entries];
		for(int i = 0; i < result.length; i++) {
			result[i] =  queue[i];
		}
		return result;
	}
	
	
}
