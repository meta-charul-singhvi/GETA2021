package Stack_Queues;

public class Queue implements QueueInterface{

	private int[] queue;
	private int front;
	private int rear;
	private int capacity;
	private int sizeOfQueue;

	//constructor
	public Queue(int capacity){
		this.capacity = capacity; 
		this.front = this.sizeOfQueue =0;
		this.rear = capacity -1;
		this.queue = new int[capacity];
	}
	
	/*
	 * function to add element to queue
	 * @param element to be added
	 * @throw Exception when queue is full
	 */
	
	@Override
	public void enQueue(int element) throws Exception {
		
		if (isFull(this)) {
            System.out.print("Queue is full!");
            System.exit(0);
		}
		
        this.rear = (this.rear + 1) % this.capacity; 
        this.queue[this.rear] = element; 
        this.sizeOfQueue = this.sizeOfQueue + 1; 
        System.out.println(element + " enqueued to queue"); 
	}

	/*
	 * function to remove element from queue
	 * @throw Exception when queue is empty
	 */
	
	@Override
	public int deQueue() throws Exception { 
        if (isEmpty(this)) {
            System.out.print("Queue is empty!");
            System.exit(0);
		}
  
        int item = this.queue[this.front]; 
        this.front = (this.front + 1) 
                     % this.capacity; 
        this.sizeOfQueue = this.sizeOfQueue - 1; 
        return item; 
    } 

	/*
	 * function to check if queue is empty 
	 * @return true if queue is empty , false otherwise
	 */
	
	@Override
	public Boolean isEmpty(Queue queue) {
		return (queue.sizeOfQueue == 0);
	}

	/*
	 * function to check if queue is full
	 * @return true if queue is full, false otherwise
	 */
	
	@Override
	public Boolean isFull(Queue queue) {
		return (queue.sizeOfQueue == queue.capacity);
	}	
	
	 // Method to get front of queue 
    int front() 
    { 
        if (isEmpty(this)) 
            return Integer.MIN_VALUE; 
  
        return this.queue[this.front]; 
    } 
  
    // Method to get rear of queue 
    int rear() 
    { 
        if (isEmpty(this)) 
            return Integer.MIN_VALUE; 
  
        return this.queue[this.rear]; 
    } 
}
