package myqueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListQueue<queue> implements MyQueue<queue> {

	private final int HEAD = 0; 
	private final int MAX = 100;
	private final List<queue> dataArr;
	private int size;

	/**
	 * Constructor
	 */
	public ListQueue() {
		this.dataArr = new ArrayList<queue>(MAX);
		this.size = -1;
	}

	/**
	 * @return true if mystack empty, false otherwise
	 */
	@Override
	public boolean isEmpty() {
		return this.size<0;
	}

	/**
	 * @param o object to push into mystack
	 * @return true if added to mystack, false otherwise
	 */
	@Override
	public boolean enqueue(queue o) {
		if(size<MAX){
			dataArr.add(o);
			this.size++;
			return true;
		}
		return false;
	}

	/**
	 * remove and retuns object from size of mystack
	 * @return value at size of mystack
	 */
	@Override
	public queue dequeue() {
		queue temp = null;
		if(this.size>=0){
			temp = dataArr.get(HEAD);
			dataArr.remove(HEAD);
			this.size--;
		}
		return temp;
	}

	/**
	 * @return value at size of mystack
	 */
	@Override
	public queue peek() {
		if(size<HEAD){
			return null;
		}
		return dataArr.get(HEAD);
	}

	/**
	 * Returns the number of elements in this queue
	 * @return size
	 */
	public int size(){
		return this.size;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return Arrays.toString(dataArr.toArray());
	}
	
	//public void sortBy()
}