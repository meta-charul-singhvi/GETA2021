/*
 * LinkedList defines the structure of linkedlist consisting of starting node pointer and certain functions :
 * @insertNode : inserting new node 
 * @showNodes : display the nodes
 * @rotateSubList 
 * @nodeSwap
 * @loopDetection
 */

package LinkedList;
public class LinkedList {
	
	/*
	 * head pointing to first node of list
	 */
	Node head;

	/*
	 * Function to insert node in list
	 * @param data is the value of the node to be added.
	 */
	public void insertNode(int data){	
		Node newNode = new Node();
		newNode.setData(data);
		if (head == null){
			head = newNode;
		}
		else{
			Node tempNode = head;
			while (tempNode.getNext()!=null){
				tempNode = tempNode.getNext();
			}
			tempNode.setNext(newNode);
		}
	}
	
	/*
	 * Function to display the list
	 * @throw Exception if list is empty
	 */
	public void showNodes() throws Exception{
		Node tempNode = head;
		if (head==null){
			throw new Exception("List is empty");
		}
		
		/*
		 * traversing through list
		 */
		while (tempNode.getNext()!=null){
			System.out.print(tempNode.getData()+ "->");
			tempNode = tempNode.getNext();
		}
		System.out.print(tempNode.getData());
	}

	/*
	 * Function to rotate sublist of linked list
	 * @leftPointer is the start position of sublist
	 * @rightPointer is the end position of sublist
	 * @numberOftimes is the number of times the list is to be rotated.
	 */
	public void rotateSubList(int leftPointer, int rightPointer, int numberOftimes) throws Exception {
		if (leftPointer<0){
			throw new Exception("Invalid start position.");
		}
		
		if (rightPointer<0){
			throw new Exception ("Invalid end position.");
		}
		
		if (leftPointer>rightPointer){
			throw new Exception ("Invalid positions.");
		}
		
		if (numberOftimes<0){
			throw new Exception("Invalid input for number of rotations");
		}
		Node tempNode = head;
		Node previousNode = null;
		Node startNode = null;
		
		// to find the first node of sublist
		for (int i=0;i<leftPointer;i++){
			
			// if invalid position is specified for start of sublist 
			if (tempNode==null){
				throw new Exception("Invalid start position.");
			}
			previousNode = tempNode;
			tempNode = tempNode.getNext();
		}
		startNode = tempNode;
		
		// to find the last node of sublist
		for (int i=leftPointer;i<rightPointer;i++){
			
			// if invalid position is specified for end of sublist
			if (tempNode==null){
				throw new Exception("Invalid end position.");
			}			
			tempNode = tempNode.getNext();
		}
		
		Node endNode = tempNode;
		int subListSize = rightPointer-leftPointer+1;
		
		if (numberOftimes >= subListSize){
			numberOftimes = numberOftimes%subListSize;
		}
	
		if(numberOftimes==0){
			showNodes();
			return;
		}
		else{
			Node node = nodeSwap(subListSize-numberOftimes,startNode);
				
			//if sublist starts from first element of list
			if (previousNode==null){
				head = node.getNext();
			}
			else{
				previousNode.setNext(node.getNext());
			}
			node.setNext(endNode.getNext());
			endNode.setNext(startNode);
			showNodes();
			}
		}
			
	/*
	 * function to find the node from where the list is to be rotated
	 * @leftPoiter is the start position of subList
	 * @number is the position of the node to be returned
	 * @node is the start node of sublist
	 * @return previous node of the node to be returned
	 */
	private Node nodeSwap(int number, Node node){	
		for (int i=0;i<number-1;i++){
			node = node.getNext();
		}
		return node;
	}

	
	public Boolean loopDetection(LinkedList linkedList){
		
		/*
		 * pointer pointing to next node of current node
		 */
		Node firstPointer = head;
		
		/*
		 * pointer pointing to the next to next node of current node
		 */
		Node secondPointer = head;
		
		while ((firstPointer!=null) && (secondPointer!=null) && (secondPointer.getNext()!=null)){
			firstPointer = firstPointer.getNext();
			secondPointer = secondPointer.getNext().getNext();
			
			/*
			 * If loop exists
			 */
			if (firstPointer == secondPointer){
				return true;
			}
		}
		return false;
	}
}