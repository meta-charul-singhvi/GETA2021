/*
 * @author : Charul Singhvi
 * @date : 09-03-2021
 */

package priorityQueue;

import java.util.Scanner;

public class PriorityQueueMain {

	public static void main(String[] args) {

		PriorityQueueMain main = new PriorityQueueMain ();
		try{
		main.getUserInput();
		}
		catch (Exception e){
			System.out.println(e.getMessage()+" isn't a valid choice! Please enter natural number.");
		}
	}
	
	private void getUserInput() throws Exception{
		double sizeOfQueue;
		System.out.println("Enter size of queue : ");
		Scanner scan = new Scanner (System.in);
		sizeOfQueue = (int)scan.nextDouble();
		while(sizeOfQueue <= 0.0){
			System.out.println("Please enter valid size of queue : ");
			sizeOfQueue = scan.nextDouble();
		}
		System.out.println("Your queue size is considered as :"+(int)sizeOfQueue);
		PriorityQueueInterface priorityqueue = new PriorityQueue((int)sizeOfQueue);
		try {
			while (true){
				System.out.println("Enter 1 to enqueue\n\t2 to dequeue");
				int choice = scan.nextInt();
				if (choice==1){
					System.out.println("Enter Element to be pushed");
					int element = scan.nextInt();
					priorityqueue.enQueue(element);
				}
				else if (choice==2){
					priorityqueue.deQueue();
				}
				else{
					throw new Exception (choice+" is an invalid choice! Pleaes enter either 1 or 2!");
				}
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		scan.close();
	}

}