package Assignment2;


public interface VolunteerLineInterface<T> {

	/**
	 * Provide two constructors:
	 * VolunteerLine(int size) make internal queue this size
	 * VolunteerLine() make internal queue default size
	 */
	/**
	 * adds a new Volunteer to the volunteer line Queue
	 * @param v A Volunteer object
	 * @return true if volunteer is queued successfully
	 * @throws VolunteerException("Volunteer Queue is full") is queue is full
	 */
	public boolean  addNewVolunteer(T v) throws VolunteerException;
	 
	/**
	 * removes volunteer from the volunteer queue line
	 * @return Volunteer Object
	 * @throws VolunteerException("Volunteer queue is empty") if queue is empty
	 */
	public  T volunteerTurn () throws VolunteerException;
 	  
	/**
	 * checks if there are volunteers in line 
	 * @return true if volunteer line is empty, true otherwise
	 */
	public boolean volunteerLineEmpty();

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
	public Volunteer[] toArrayVolunteer();
}
