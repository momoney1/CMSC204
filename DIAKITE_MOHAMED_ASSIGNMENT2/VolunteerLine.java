package Assignment2;

/**
 * A generic class that implements from a generic interface.  This class controls the adding and removing of volunteers
 * from a queue of volunteers.
 * @author Moe Diakite
 *
 * @param <T>
 */
public class VolunteerLine<T> implements VolunteerLineInterface<T> {
	private static int DEFAULT_CAPACITY = 5;
	private static int MAX_CAPACITY;
	private MyQueue<T> volunteerQueue;
	
	/**
	 * a no arg constructor that creates a new VolunteerLine that has a queue of default size
	 */
	public VolunteerLine() {
		this(DEFAULT_CAPACITY);
	}
	/**
	 * A parameter accepting constructor that creates a new VolunteerLine with a queue of specified capacity
	 * @param initialCapacity
	 */
	public VolunteerLine(int initialCapacity) {
		@SuppressWarnings("unchecked")
		MyQueue<T>tempQueue = new MyQueue<T>(initialCapacity);
		volunteerQueue = tempQueue;
		
	}
	/**
	 * adds a new Volunteer to the volunteer line Queue
	 * @param v A Volunteer object
	 * @return true if volunteer is queued successfully
	 * @throws VolunteerException("Volunteer Queue is full") is queue is full
	 */
	public boolean  addNewVolunteer(T v) throws VolunteerException{
		if(volunteerQueue.enqueue(v)) {
			return true;
		}
		else {
			throw new VolunteerException();
		}
		
	};
	
	/**
	 * removes volunteer from the volunteer queue line and places the volunteer in back of line
	 * @return Volunteer Object
	 * @throws VolunteerException("Volunteer queue is empty") if queue is empty
	 */
	public  T volunteerTurn () throws VolunteerException{
		if(volunteerQueue.isEmpty()) {
			throw new VolunteerException("Volunteer queue is empty");
		}
		T vol = volunteerQueue.dequeue(); 
		addNewVolunteer((T)vol);
		return (T)vol;
	};

	/**
	 * checks if there are volunteers in line 
	 * @return true if volunteer line is empty, true otherwise
	 */
	public boolean volunteerLineEmpty() {
		return false;
	};
	
	/**
	 * Returns an array of the Volunteers in the queue.  
	 * Because of type erasure by the JVM at run-time, the array of type T that the generic queue
	 * returns from the call to queue.toArray() is an array of type Object, i.e., Object[] temp. 
	 * But since the individual elements of the array are still Volunteers, we can copy them one 
	 * by one into a new array	of type Volunteer and cast each one to Volunteer. 
	 * So create a new array of Volunteers of the same length as temp, run a for-loop that casts each element 
	 * of temp to Volunteer and copies it to the corresponding position in the new array.  Then return the new array.
	 * @return an array of the Volunteers in the queue
	 */
	public Volunteer[] toArrayVolunteer() throws VolunteerException {
		if(volunteerQueue.size() > 0) {
			@SuppressWarnings("unchecked")
			T[] temp =  (T[]) volunteerQueue.toArray();
			Volunteer[] volunteerArray = new Volunteer[volunteerQueue.size()];
			
			for(int i = 0; i < temp.length; i++) {
				volunteerArray[i] = (Volunteer) temp[i];
			}
			
			return  volunteerArray;
		}
		else {
			throw new VolunteerException("The Queue is empty");
		}
		
	};

}
