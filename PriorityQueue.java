package priorityQueue;
public class PriorityQueue implements PriorityQueueInterface{

	private int sizeOfQueue;
	private int[] priorityQueue;
	private int front;
	private int rear;
	
	//constructor
	public PriorityQueue(int sizeOfQueue) throws Exception{
		this.sizeOfQueue = sizeOfQueue;
		this.priorityQueue = new int[this.sizeOfQueue];
		this.front =-1;
		this.rear =-1;
	}
	
	/*
	 * function to add element to queue
	 * @elemnt to be added
	 * throws Exception if queue is full
	 */
	@Override
	public void enQueue(int element) throws Exception {
			
		if (isFull()){
			throw new Exception ("Queue is full");
		}
		
		//first element being added to queue
		if ((front==-1) && (rear==-1)){
			front = 0;
			rear =0;
			priorityQueue[rear] = element;
		}
		else {
			rear = rear+1;
			priorityQueue[rear] = element;
			checkHeapforEnqueue(rear);
		}
	}

	/*
	 * function to rearrange elements after enqueue
	 * @currentElementPosition is the position of latest element entered
	 * If current element value is greater than parent then they are swapped.
	 */
	private void checkHeapforEnqueue(int currentElementPosition) {
		int parentPosition = (currentElementPosition-1)/2;
		while ((parentPosition>=0) && ((priorityQueue[currentElementPosition])>priorityQueue[parentPosition])){
			int temp = priorityQueue[currentElementPosition];
			priorityQueue[currentElementPosition] = priorityQueue[parentPosition];
			priorityQueue[parentPosition] = temp;
			currentElementPosition = parentPosition;
			parentPosition = (parentPosition-1)/2;	
		}
	}
	
	/*
	 * function to remove 
	 */
	@Override
	public int deQueue() throws Exception {

		if (isEmpty()) {
			throw new Exception("Queue is empty");
		}

		int element = priorityQueue[0];
		priorityQueue[0] = priorityQueue[rear];
		rear--;
		checkHeapForDequeue();
		return element;
	}

	/*
	 * function to rearrange elements after dequeue
	 */
	private void checkHeapForDequeue() {
		int leftChild = 1;
		int rightChild = 2;
		int childIndex = 0;
		int parentIndex = 0;
		
		//traversing through the queue
		while ((parentIndex < rear) && (leftChild < rear) && (rightChild <= rear)) {
			if (priorityQueue[leftChild] > priorityQueue[rightChild]) {
				childIndex = leftChild;
			} else {
				childIndex = rightChild;
			}
			
			//comparing child with parent element
			if (priorityQueue[childIndex] > priorityQueue[parentIndex]) {
				
				//swapping parent and child
				int temp = priorityQueue[childIndex];
				priorityQueue[childIndex] = priorityQueue[parentIndex];
				priorityQueue[parentIndex] = temp;
				parentIndex = childIndex;
				leftChild = 2 * (parentIndex) + 1;
				rightChild = 2 * (parentIndex) + 2;
			} else {
				break;
			}
		}
	}
	
	/*
	 * function to check  if queue is empty
	 * @return true if queue is empty, false otherwise
	 */
	
	@Override
	public Boolean isEmpty() {
		if (rear==-1){
			return true;
		}
		return false;
	}

	/*
	 * function to check if queue is full
	 * @return true if queue is full, false otherwise
	 */
	
	@Override
	public Boolean isFull() {
		if (((front==0) && (rear==sizeOfQueue-1)) || front+rear == sizeOfQueue-1){
			return true;
		}
		return false;
	}
	
}