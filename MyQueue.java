package myqueue;

public interface MyQueue<queue> {
	/**
	 * Check wether Queue is empty or not
	 * @return boolean
	 */
	boolean isEmpty();
	
	/**
	 * Add an object of type queue into the top of this queue
	 * @param o the object to be added in queue
	 * @return boolean whether object added or not
	 */
	boolean enqueue(queue o);

	/**
	 * Remove an object of type queue from the top of this queue &
	 * @return the object of type queue from top of this queue
	 */
	queue dequeue();
	
	/**
	 * return item from available at top of 
	 * the queue without removing it
	 * @return the object of type queue from top of this queue
	 */
	queue peek();
}