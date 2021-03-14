package algorithm2EmployeeSorting;

/**
 * Class to represent a Linked List
 *
 */
public class LinkedList {
	private Node head;

	/**
	 * Function to insert node in the linked list
	 * 
	 * @param employee is a non-null Employee
	 * @throws Exception if employee is null
	 */
	public void insert(Employee employee) throws Exception {
		Node node = new Node(employee);
		if (this.head == null) {
			this.head = node;
			return;
		}
		Node currentNode = this.head;
		while(currentNode.getNext()!=null) {
			currentNode  = currentNode.getNext();
		}
		currentNode.setNext(node);
		node.setPrev(currentNode);
	}

	/**
	 * Function to sort employees based on salary in descending order and when salary is same sort according to age in ascending order
	 * 
	 * @throws Exception if any employee found null
	 */
	public void sort() throws Exception {
		this.quickSort(this.head, null);
	}

	/**
	 * Helper function to apply Quick Sort to the Linked List recursively
	 * @param left points to left Node
	 * @param right point to right Node
	 */
	private void quickSort(Node left, Node right) {
		
		//only one element is present
		if(left == right) {
			return;
		}
		
		Node pivot = left;
		Employee employee = pivot.getEmployee();
		for (Node current = left.getNext(); current != right; current = current.getNext()) {
			Employee currentEmployee = current.getEmployee();
			if (currentEmployee.getSalary() > employee.getSalary() || (currentEmployee.getSalary() == employee.getSalary() && currentEmployee.getAge() < employee.getAge())) {
				current.getPrev().setNext(current.getNext());
				if(current.getNext()!=null) {
					current.getNext().setPrev(current.getPrev());
				}
				current.setPrev(pivot.getPrev());
				current.setNext(pivot);
				if(pivot.getPrev()==null) {
					this.head = current;
				} else {
					pivot.getPrev().setNext(current);
				}
				pivot.setPrev(current);
				if(left == pivot) {
					left = current;
				}
			}
		}
		quickSort(left, pivot);
		quickSort(pivot.getNext(), right);
	}

	/**
	 * Function to print all the nodes in the linked list
	 */
	public void showList(){
		System.out.println("Employee list : ");
		System.out.println("----------------------------------------------\nEmployee Name\tSalary\t\tEmployee Age");
		for (Node currentNode = this.head; currentNode != null; currentNode = currentNode.getNext()) {
			System.out.println(currentNode.getEmployee().getName() + "\t\t"+currentNode.getEmployee().getSalary() +"\t\t"+currentNode.getEmployee().getAge());
		}
	}
}