package linkedList;

import undirectedWeightedGraph.Edge;

/**
 * Class to implement a node of a linked list
 *
 */
public class Node {
	private Edge edge;
	private Node next;
	
	/**
	 * Constructor takes integer value as parameter
	 * sets value of the node initially
	 * @param value
	 */
	public Node(Edge edge){
		this.edge = edge;
		this.next = null;
	}
	
	/**
	 * Function to get the value of the node
	 * @return value
	 */
	public Edge getEdge(){
		return this.edge;
	}
	
	/**
	 * Function to get the next node
	 * @return next node
	 */
	public Node getNext(){
		return this.next;
	} 
	
	/**
	 * Function to set next node
	 * @param next
	 */
	public void setNext(Node next){
		this.next = next;
	}
	
}