package Stack;

public class StackImplementation implements Stack {
	private final int CAPACITY = 10000;
	private String[] storage;
	private int top;
	public StackImplementation() {
		this.storage = new String[CAPACITY];
		this.top = -1;
	}
	@Override
	public boolean isFull() {
		return (this.top + 1 == CAPACITY);
	}
	@Override
	public boolean isEmpty() {
		return (this.top == -1);
	}
	@Override
	public void push(String item) throws Exception {
		if (this.isFull()) {
			throw new Exception("Stack Overflow");
		}
		this.storage[++this.top] = item;
	}
	@Override
	public String pop() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("Stack Underflow");
		}
		return this.storage[this.top--];
	}
	@Override
	public String top() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("Stack Underflow");
		}
		return this.storage[this.top];
	}
	public boolean isContain(String item)
	{
		int itr=top;
		while(itr!=-1)
		{
			if(this.storage[itr].equals(item))
			{
				return true;
			}
			itr--;
		}
		return false;
	}

}