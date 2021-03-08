package Stack_Queues;

public class Stack implements StackInterface{
	
	//size of stack
	private int sizeOfStack;
	private String[] stack;
	
	//pointing to the latest added element of stack
	private int top = -1;

	//constructor
	public Stack(int length) {
		this.sizeOfStack = length;
		this.stack = new String[sizeOfStack];
	}

	/*
	 * function to push element into stack
	 * @element is the data to be pushed to stack
	 */
	@Override
	public void push(String element) throws Exception {
		
		if (top==(sizeOfStack-1)){
			throw new Exception ("Stack is full");
		}
		top = top+1;
		stack[top] = element;
	}

	/*
	 * function to remove element from stack
	 * returns popped element
	 * throws exception if stack is empty
	 */
	@Override
	public String pop() throws Exception {
		
		if (top==-1){
			throw new Exception ("Stack is empty!");
		}
		String poppedElement = stack[top];
		top = top-1;
		return poppedElement;
	}
	
	/*
	 * function to check whether stack is empty
	 * returns true if stack is empty, false otherwise
	 */
	@Override
	public Boolean isEmpty(){
		if (top==-1){
			return true;
		}
		return false;
	}
	
	/*
	 * returns the topmost element of stack.
	 */
	@Override
	public String peek() throws Exception{
		if (top==-1){
			throw new Exception ("Stack is empty");
		}
		return stack[top];
	}

	/*
	 * returns true if stack is full, false otherwise
	 */
	@Override
	public Boolean isFull() {
		if (top==sizeOfStack){
			return true;
		}
		return false;
	}
}