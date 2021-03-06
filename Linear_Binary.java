package Search;
/*
 * @author - Charul Singhvi
 * @date - 06-03-2021
 * @linSearch is to search for an element in the list and return positive or negative reponse accordingly.
 * @binSearch is to search for an element in the array and return the index of the element if present in the array.
 */
import java.util.Scanner;

public class Linear_Binary {
	
	public static boolean linSearch(int[] arr, int linSearchElem, int index)throws Exception{
		boolean result = false;
		try{
			/*
			 * Checking if array is empty or not
			 */
			if (arr.length == 0) {
				throw new Exception("Array is empty!");
			}
			else if(index < arr.length){
				if(linSearchElem == arr[index])
					return true;
				else if(index >= arr.length)
					return false;
				else{
					index++;
					result = linSearch(arr, linSearchElem, index);
				}
			}
			else if( index>=arr.length ){
				return false;
//				throw new Exception ("Element not found!");
			}
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return result;
	}
	
	public static int binSearch(int[] arr, int binSearchElem, int midIndex)throws Exception{
		int index = -1;
		try{
			if (arr.length == 0) {
				throw new Exception("Array is empty.");
			}
			else if (binSearchElem == arr[arr.length - 1])
				return (arr.length-1);
			
			else if(binSearchElem == arr[midIndex])
				return midIndex;
			
			else if(binSearchElem < arr[midIndex]){
				index = binSearch(arr, binSearchElem, (midIndex-1)/2);
			}
			else if(binSearchElem > arr[midIndex+1]){
				index = binSearch(arr, binSearchElem, (midIndex+arr.length)/2);
			}
		}
		catch(StackOverflowError e){
			return index;
		}
		return index;
	}
	
	
	public static void main(String[] args) throws Exception{
		try{
			Scanner scan = new Scanner (System.in);
			System.out.print("Enter number of values : ");
			int n = scan.nextInt();
			
			int[] arr= new int[n];
			for(int i=0; i<n; i++){
				System.out.print("Value "+ i +" : ");
				arr[i]= scan.nextInt();
			}
			
			System.out.println("Enter element to search in array: ");
			int searchElem = scan.nextInt();
			/*
			 * @linSearch takes 3 parameters the array, the elemt to be searched and the index at which the search 
			 * operation will be held in current calling of function
			 */
			boolean result = linSearch(arr,searchElem, 0);
			System.out.println("**Using LINEAR SEARCH**\nDoes "+searchElem+" exists in array -> "+result);
			
			/*
			 * Assuming array is sorted
			 */
			System.out.println("**Using BINARY SEARCH**");
			/*
			 * If element doesn't exist in the array not unnecessarily calling the Binary Search function
			 */
			if (!result) {
				System.out.println("Element doesn't exist in the array!");
				System.exit(0);
			}
			/*
			 * If still it calls and doesn't finds the element i.e. The array isn't sorted. 
			 * @binSearch takes 3 parameters array, seraching element and the mid element of the selected subarray.
			 */
			int index = binSearch(arr, searchElem, (arr.length-1)/2);
			if (index == -1) {
				System.out.println("Please enter a sorted array!");
				System.exit(0);
			}
			/*
			 * Following zero indexing format
			 */
			System.out.print("Element "+searchElem+" exists in array at index -> "+index);
			
			scan.close();
		}
		catch(Exception e){
			System.out.println("Invalid Input!");
		}
	}

}
