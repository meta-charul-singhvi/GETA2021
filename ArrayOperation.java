package testingJunit;

import java.util.InputMismatchException;
import java.util.Scanner;

/* @ author Charul Singhvi
 * @ date 12-03-2021
 * The class Array Operation supports the following methods :
 * Method to return the size of the largest mirror section found in the input array. Mirror section in an array is a group of contiguous elements such that somewhere in the array, the same group appears in reverse order.
 * Method to return the number of clumps in the input array. Clump in an array is a series of 2 or more adjacent elements of the same value.
 * Method to solve the fixXY problem. It returns an array that contains exactly the same numbers as the input array, 
   but rearranged so that every X is immediately followed by a Y. We Do not move X within array, but every other number may move.
 * Method to splitArray. Returns the index if there is a place to split the input array so that the sum of the numbers on one side is equal to the sum of the numbers on the other side else return -1.
*/


public class ArrayOperation {
	
	//Question 1
	public static int largestMirrorSection(int[] userInputArray) throws Exception, AssertionError{
		/*Method to find and return the length of the largest group of consecutive numbers which are present in the reverse order.
		 * @param userInputArray is the input array of numbers.
		 * @return sizeOfLargestMirrorSection
		 * @throw AssertionError when the array is empty.  
		 */
		
		int arraySize = userInputArray.length;
		if (arraySize == 0){
			throw new AssertionError("Array is empty.");
		}
		
		int sizeOfLargestMirrorSection = 0;
		for (int i = 0; i < userInputArray.length ; i++){
			for (int j = userInputArray.length - 1; j > i; j--){
				if(userInputArray[i] == userInputArray[j]){
					int startPoint = i, endPoint = j, countOfElements = 0;
					while (startPoint <= j && userInputArray[startPoint] == userInputArray[endPoint]){
						countOfElements++;
						startPoint++;
						endPoint--;
					}
					if(countOfElements > 1 && sizeOfLargestMirrorSection < countOfElements){
						sizeOfLargestMirrorSection = countOfElements;
						countOfElements = 0;
					}
				}
			}
		}
		return sizeOfLargestMirrorSection;
	}
	
//	Question 2
	public static int numberOfClumps(int[] userInputArray) throws Exception, AssertionError{
		/* Method to count the series of two or more adjacent elements of same value.
		 * @param userInputArray is the array given as input by the user.
		 * @return the count of number of clumps.
		 * @throw AssertionError if array is empty.
		 */
		int arraySize = userInputArray.length;
		if (arraySize == 0){
			throw new AssertionError ("Array is empty.");
		}
		int countOfElementInAClump = 1;
		int finalNumberOfClumps = 0;
		for(int i = 0; i < arraySize - 1; i++){
			if(userInputArray[i] == userInputArray[i + 1]){
				countOfElementInAClump++;
			}
			else{
				if (countOfElementInAClump >= 2){
					finalNumberOfClumps++;
					countOfElementInAClump = 1;
				}
			}
		}
		if (countOfElementInAClump >= 2){
			finalNumberOfClumps++;
		}
		return finalNumberOfClumps;
	}
	
//	Question 3
	public static int[] solveFixXYProblem(int[] userInputArray,int X,int Y) throws Exception, AssertionError {
		/* Method to place the elements in such a way that every X is succeeded by a Y. The position of X can not be changed. The rest of elements may move.
		 * @param userInputArray is the array given as input by the user.
		 * @param X is the value that will be fixed.
		 * @param Y is the value that will be placed right next to X.
		 * @return newly arranged array.
		 * @throw AssertionError if the array is empty
		 * @throw AssertionError if the number of X and Y are unequal.
		 * @throw AssertionError if two X are present adjacent to each other.
		 * @throw AssertionError if X is at the last position.
		 */
		
		int flag = 0;
		int arraySize = userInputArray.length;
		int countOfX = 0;
		int countOfY = 0;
		if (arraySize == 0)
		{
			throw new AssertionError ("Array is empty.");
		}
		for (int i = 0; i < arraySize; i++){
			if (userInputArray[i] == X){
				countOfX++;
				flag = 1;
			}
		}
		if (flag == 0){
			throw new Exception ("Given value of X is not present in the array.");
		}
		
		flag=0;
		for (int i = 0; i < arraySize; i++){
			if (userInputArray[i] == Y){
				countOfY++;
				flag = 1;
			}
		}
		if (flag == 0){
			throw new Exception ("Given value of Y is not present in the array.");
		}
		if (countOfX != countOfY){
			throw new AssertionError ("X and Y are unequal in number.");
		}
		for (int i = 0; i < arraySize - 1; i++){
			if ( (userInputArray[i] == X) && userInputArray[i] == userInputArray[i + 1] ){
				throw new AssertionError ("Two adjacent X are present.");
			}
		}
		if (userInputArray[arraySize - 1] == X){
			throw new AssertionError ("X is present at the last position.");
		}
	
		int index = 0; 
		int j = 0;
		for (int i = 0; i < arraySize; i++){
			if ((userInputArray[i] == X) && (userInputArray[i + 1] != Y)){
				index = i + 1;
				for (j = 0; j < arraySize; j++){
					if (userInputArray[j] == Y && (j == 0 || userInputArray[j - 1] != X)){
						int temp = userInputArray[j];
						userInputArray[j] = userInputArray[index];
						userInputArray[index] = temp;
						break;
					}
				}
		    }
		}
		return userInputArray;
	}
	
//	Question 4
	public static int splitArray(int [] userInputArray) throws Exception, AssertionError{
		/* Method to split an array such that the sum of numbers on one side is equal to the sum of numbers on the other side.
		 * @param userInputArray is the array given as input by the user.
		 * @return the index at which the array is split.
		 * @throw AssertionError if the array is empty.
		 */
		int arraySize = userInputArray.length;
		if (arraySize == 0){
			throw new AssertionError ("Array is empty.");
		} 
		int splitIndex = 0, startPoint = 0, endPoint = arraySize - 1, sumFromLeft = userInputArray[0];
		int sumFromRight = userInputArray[endPoint];
		if (arraySize == 1){
			return 0;
		}
		while ((startPoint + 1) != endPoint){
			if( sumFromLeft >= sumFromRight){
				endPoint--;
				sumFromRight += userInputArray[endPoint];
			}
			else{
				startPoint++;
				sumFromLeft += userInputArray[startPoint];
			}
		}
		if (sumFromLeft == sumFromRight){
			splitIndex = endPoint;
		}
		else{
			splitIndex = -1;
		}
		return splitIndex;
	}
	
	public static void displayArray(int[] array, int X, int Y) throws AssertionError, Exception{
		int[] solvedArray = solveFixXYProblem(array, X, Y);
		for(int index=0; index<array.length; index++){
			System.out.print(solvedArray[index] + " ");
		}
	}
	
	
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		try{
			ArrayOperation object = new ArrayOperation();
			System.out.print("Enter number of elements to enter in array :");
			int elements = scan.nextInt();
			int[] array = new int[elements];
			for(int i=0; i<elements; i++){
				System.out.print("Enter value ["+i+"] :");
				array[i] = scan.nextInt();
			}
			
			System.out.println("The largest mirror section count in the array is : "+largestMirrorSection(array));
			System.out.println("Number of clumps in the array are : "+numberOfClumps(array));
			System.out.print("Enter X :");
			int X = scan.nextInt();
			System.out.print("Enter Y :");
			int Y = scan.nextInt();
			System.out.println("The solution of FixXY in array is : "); 
			displayArray(array, X, Y);
			System.out.println("\nThe sum spliting index in the array is : "+splitArray(array));
			
		}
		catch(AssertionError e){
			System.out.println(e.getMessage());
		}
		catch(InputMismatchException e){
			System.out.println("The input you entered is invalid!");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		scan.close();
	}
}