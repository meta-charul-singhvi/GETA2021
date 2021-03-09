/*
 * @author : Charul Singhvi
 * @date : 08-03-2021
 */
package Stack_Queues;

import java.util.Scanner;

public class QueueMain {

	public static void main(String[] args) {
		QueueMain mainObject = new QueueMain();
		mainObject.userInput ();	
	}
	
	private void userInput(){
		System.out.println("Enter size of queue : ");
		Scanner scan = new Scanner(System.in);
		try {
			
			int size = scan.nextInt();
			while(size<=0){
				System.out.println("Enter valid size of queue : ");
				size = scan.nextInt();
			}
			QueueInterface queueObject = new Queue(size);
		
			while (true){
				System.out.println("Enter 1 to enqueue \n	2 to dequeue");
				int choice = scan.nextInt();
				if (choice==1){
					System.out.println("Enter Element to be pushed");
					int element = scan.nextInt();
					queueObject.enQueue(element);
					System.out.println("Element added successfully!");
				}
				else if (choice==2){
					queueObject.deQueue();
					System.out.println("Element removed successfully!");
				}
				else if (choice==3){
					break;
				}
				else{
					throw new Exception ("Invalid choice");
				}
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}

	}

}
