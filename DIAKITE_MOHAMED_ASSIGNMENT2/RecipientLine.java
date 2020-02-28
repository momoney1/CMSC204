package Assignment2;

/**
 * A generic class RecipientLine, that implements generic interface RecipientLineInterface
 * @author Moe Diakite
 *
 * @param <T>
 */
public class RecipientLine<T> implements RecipientLineInterface<T> {
	private static int DEFAULT_SIZE = 5;
	private MyQueue<T> recipientQueue;
	
	/**
	 * A default constructor that creates a new RecipientLine with a queue of default size
	 */
	public RecipientLine() {
		this(DEFAULT_SIZE);
	}
	
	/**
	 * A constructor with a parameter that is used to create a new Recipient line with a queue of specified
	 * size
	 * @param size
	 */
	public RecipientLine(int size) {
		recipientQueue = new MyQueue<T>(size);
	}
	
	/**
	 * Enqueue a new Recipient to the queue of the Recipients in the Recipient line
	 * @param rc a Recipient
	 *return true if recipient is queued successfully
	 * @throws RecipientException("The Recipent Queue is Full") if queue is full
	 */
	public boolean  addNewRecipient(T rc ) throws RecipientException{
		if(recipientQueue.enqueue(rc)) {
			return true;
		}
		else {
			throw new RecipientException();
		}
	};
	
	/**
	 * When it is the recipient turn, recipient will be dequeued from the recipient line
	 * @return a Recipient object
	 * @throws RecipientException("The Recipient Queue is empty") if there is no Recipient in the line
	 */
	public  Recipient recipientTurn ()  throws RecipientException{
		if(recipientQueue.isEmpty()) {
			throw new RecipientException("The Recipient Queue is Empty");
		}
		return (Recipient) recipientQueue.dequeue();
	};
	
	/**
	 * check if Recipient  queue line is empty
	 * @return true if queue is empty, false otherwise
	 */
	public  boolean recipientLineEmpty() {
		return false;
	};
	
	/**
	 * Returns an array of the Recipients in the queue.  
	 * Because of type erasure by the JVM at run-time, the array of type T that the generic queue
	 * returns from the call to queue.toArray() is an array of type Object, i.e., Object[] temp. 
	 * But since the individual elements of the array are still Recipients, we can copy them one 
	 * by one into a new array	of type Recipient and cast each one to Recipient. 
	 * So create a new array of Recipients of the same length as temp, run a for-loop that casts each element 
	 * of temp to Recipient and copies it to the corresponding position in the new array.  Then return the new array.
	 * @return an array of the Recipients in the queue
	 * 
	 */
	public Recipient[] toArrayRecipient() {
		T[] tempLine = recipientQueue.toArray();
		Recipient[] recipientLine = new Recipient[recipientQueue.size()];
		for(int i = 0; i < tempLine.length; i++) {
			recipientLine[i] = (Recipient)tempLine[i];
		}
		return recipientLine;
	};
}
