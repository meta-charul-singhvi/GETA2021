package linkedList;

import undirectedWeightedGraph.Edge;

public class LinkedList {
	private Node head;

	/**
	 * Default constructor
	 */
	public LinkedList() { }
	/**
	 * Function to insert a node at end of the linked list takes integer value
	 * as parameter
	 * @param value
	 */
	public void insertNode(Edge edge) {
		Node newNode = new Node(edge);
		if (head == null) {
			head = newNode;
			return;
		}
		Node last = head;
		while (last.getNext() != null) {
			last = last.getNext();
		}
		last.setNext(newNode);
	}

	/**
	 * Function to print the linked list on console
	 */
	public void display() {
		if (head == null) {
			System.out.println("null");
			return;
		}

		for (Node currentNode = head; currentNode != null; currentNode = currentNode
				.getNext()) {
			System.out.print(currentNode.getEdge().getSource().getVertex()+"->"+currentNode.getEdge().getDestination().getVertex()+":"+currentNode.getEdge().getWeight());
			if (currentNode.getNext() != null) {
				System.out.print(" ---");
			} else {
				System.out.println();
			}
		}
	}
	public Node getHead()
	{
		return this.head;
	}

}