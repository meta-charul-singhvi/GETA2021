/*
 * @author - Charul Singhvi
 * @date - 07-03-2021
 * @LoopInLinkedList Detects loop in a linked list if  present
 */
package LinkedList;

public class LoopInLinkedList {
	static LinkedList linkedList = new LinkedList();
	public static void main(String[] args) throws Exception{
		try{
			LoopInLinkedList object = new LoopInLinkedList();
			object.inputData();
			/*
			 * calling loop detection function
			 * @linkedList is the object of class LinkedList
			 */
			if (linkedList.loopDetection(linkedList)){
				System.out.println("Loop exists");
			}
			else{
				System.out.println("Loop not found");
			}	
		}
		catch(Exception e){
			System.out.print(e.getMessage());
		}
	}
	
	/*
	 * function to add input for creation of linked list
	 */
	private void inputData() throws Exception{
			
		Node node = new Node(1);	
		insertNode(new Node(2));
		insertNode(node);
		insertNode(new Node(3));
		insertNode(new Node(4));
		insertNode(new Node(5));
		insertNode(node);
	}
	
	/*
	 * Function to insert node in list
	 * @newNode is the node to be added.
	 */
	public void insertNode(Node newNode){	
		if (linkedList.head == null){
			linkedList.head = newNode;
		}
		else{
			Node tempNode = linkedList.head;
			while (tempNode.getNext()!=null){
				tempNode = tempNode.getNext();
			}
			tempNode.setNext(newNode);
		}
	}
	
}