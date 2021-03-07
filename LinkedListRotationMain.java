/*
 * @author - Charul Singhvi
 * @date - 04-03-2021
 */
package LinkedList;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LinkedListRotationMain {

	public static void main(String[] args){
		LinkedList linkedList = new LinkedList();
		LinkedListRotationMain object = new LinkedListRotationMain();
		try{
			object.userInput(linkedList);
		}
		catch (InputMismatchException exception){
			System.out.println("Invalid Input");
		}
		catch(Exception exception){
			System.out.println(exception.getMessage());
		}
	}
	
	/*
	 * Function to get user input
	 * @throws InputMismatchException if data type of input is different than expected.
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	private void userInput(LinkedList linkedList) throws InputMismatchException, Exception{
//		try{
			System.out.println("Enter number of nodes to be entered :");
			Scanner scan = new Scanner(System.in);
			int sizeOfList = scan.nextInt();
			
			if (sizeOfList<=0){
				throw new Exception ("Enter valid size");
			}
			
			//to get the values of nodes
			for (int iterator=0; iterator<sizeOfList;iterator++){
				System.out.println("Enter value of node "+iterator+": ");
				int valueOfNode = scan.nextInt();
				linkedList.insertNode(valueOfNode);
			}
		
			
			//getting starting index of sublist
			System.out.println("Enter start position (left) >= 0 :");
			int leftPointer = scan.nextInt();
	
			if (leftPointer<0 || leftPointer>sizeOfList-1){
				throw new Exception("Invalid start position.");
			}
			
			//getting ending index of sublist
			System.out.println("Enter end position (right) < "+ sizeOfList +":");
			int rightPointer = scan.nextInt();
			
			if (rightPointer<0 || rightPointer>sizeOfList-1){
				throw new Exception ("Invalid end position.");
			}
			
			if (leftPointer>rightPointer){
				throw new Exception ("Invalid positions.");
			}
			
			System.out.println("Enter number of times to be rotated : ");
			int numberOftimes = scan.nextInt();
			
			if (numberOftimes<0){
				throw new Exception("Invalid input for number of rotations");
			}
			else if (numberOftimes==0){
				linkedList.showNodes();
			}
			else{
				System.out.print("List before rotation : ");
				linkedList.showNodes();
				System.out.println("\nList after "+numberOftimes+" rotations from position ("+leftPointer+"-"+rightPointer+"): ");
				linkedList.rotateSubList(leftPointer, rightPointer, numberOftimes%(rightPointer-leftPointer+1));
			}
			scan.close();
//		}
//		catch(Exception e){
//			System.out.print("Invalid input!");
//		}
	}
}