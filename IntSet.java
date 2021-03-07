/*
 * @author - Charul Singhvi
 * @date - 07-03-2021
 * @IntSet is a class which represents a set made up using array. It perfroms functions such as:
 * @isMember checks if an element is a member of particular set
 * @getComplement gets the complement set of the set. Considering universal set as {1-1000}
 * @isSubSet checks if the other set provided is subset of the main set or not.
 * @union results the union of 2 sets
 */
import java.util.Scanner;
import java.util.Arrays;

public class IntSet {

	private int[] set;
	private int size;
	
	Scanner scan = new Scanner (System.in);
	/*
	 * Constructor taking input values of set whenever a new object is created
	 */
	private IntSet() throws Exception{
		try{
			System.out.print("Enter number of values to be entered in set:");
			int n = scan.nextInt();
			while(n<=0){
				System.out.print("Enter a natural number as total elements in set:");
				n = scan.nextInt();
			}
			int[] arr = new int[n];
			System.out.println("Enter values in set!");
			for(int i=0; i<n; i++){
				System.out.print("Value"+ i +":");
				arr[i] = scan.nextInt();
			}
			arrToSet(arr, n);
		}
		catch(Exception e){
			System.out.print("Invalid Input!");
			System.exit(0);
		}
	}
	/*
	 * Constructor taking array as input
	 */
	private IntSet(int[] arr){
		
		int n = arr.length;
		arrToSet(arr, n);
		
	}
	
	/*
	 * Converting an array's functionality to set
	 * Such as : no values repeating in set
	 */
	public void arrToSet(int[] arr, int n){
		Arrays.sort(arr);
		int j=0;
		set=new int[n];
		for (int i=0; i<n-1; i++){
			if(arr[i]!= arr[i+1]){
				set[j++] = arr[i];
			}
		}
		set[j++]=arr[n-1];
		size=j;
	}
	/*
	 * show the elements in the set
	 */
	public void displaySet(){
		
		System.out.print("{ ");
		for(int i=0; i<size; i++){
			System.out.print(set[i]+ " ");
		}
		System.out.print("}");
		
	}
	
	/*
	 * Checking for an element in set
	 */
	public boolean isMember (int x){
		boolean isMem = false;
		for(int i=0; i<size; i++){
			if(x == set[i]){
				isMem= true; break;
			}
		}
		return isMem;
	}
	
	/*
	 * returning the size of the set
	 */
	public int size(){
		return size;
	}
	
	/*
	 * checking if set provided is subset of the main set
	 */
	public boolean isSubSet(int[] s){		
		if(s.length > set.length){
			return false;
		}
		
		if(s[s.length-1] > set[set.length-1]){
			return false;
		}
		
		int subsetIndex=0;
		for(int i=0; i<set.length; i++){
			if(subsetIndex <= set.length){
				if(set[i] == s[subsetIndex]){
					subsetIndex++;
				}
				else if(s[subsetIndex] > set[i]){}
				else{
					return false;
				}
			}
		}
		
		return true;
	}
	
	/*
	 * returning the complement of main set
	 * Considering universal set {0-1000}
	 */
	public IntSet getComplement(){
		final int upperLimit = 1000;
		int[] compSet= new int[upperLimit-set.length+1];
		
		int compSetIndex=0, setIndexCount=0;
		for(int i=1; i<=upperLimit; i++){
			if(setIndexCount < set.length){
				if(isMember(i)){
					setIndexCount++;
				}
				else{
					compSet[compSetIndex]=i;
					compSetIndex++;
				}
			}
			else{
				compSet[compSetIndex]=i;
				compSetIndex++;
			}
		}
		
		IntSet complSet = new IntSet(compSet);
		return complSet;
	}
	
	/*
	 * Returning the union of 2 sets provided
	 */
	public IntSet union(int[] set1 ,int[] set2){
		int[] set3 = new int[set1.length + set2.length];
		int i=0;
		for(i=0; i<set1.length;i++){
			set3[i] = set1[i];
		}
		for(int j=0; j<set2.length; j++)
			set3[j+i] = set2[j];
		IntSet setUn = new IntSet(set3);
		return setUn;
	}
	
	public static void main(String[] args) throws Exception{
		try{
			Scanner in = new Scanner(System.in);
			IntSet s1 = new IntSet();
			s1.displaySet();
			
			/*
			 * IsMember check
			 */
			System.out.print("\nEnter number to check if it's member of Set :");
			int x = in.nextInt();
			boolean checkMem = s1.isMember(x);
			System.out.println("1. Is '" +x +"' a member of set : "+checkMem);
			
			/*
			 * Printing size of set
			 */
			System.out.println("\n2. Size of the Set is :"+s1.size()+"\n");
			
			/*
			 * Printing complement of set
			 */
			System.out.print("3. Complement of ");
			s1.displaySet();
			System.out.print(" is :\n");
			IntSet s4 = s1.getComplement();
			s4.displaySet();
			System.out.println();
			
			/*
			 * Subset check
			 */
			System.out.println("\nEnter set to check if it's the Subset of Main set->");
			IntSet s2 = new IntSet();
			System.out.print("4. ");
			s2.displaySet();
			System.out.print(" is subset of ");
			s1.displaySet();
			if(s2.size() > s1.size()){
				System.out.println(": false\n");
			}
			System.out.println(": " + s1.isSubSet(s2.set)+"\n");
			
			/*
			 * Printing union of sets provided
			 */
			System.out.println("Enter a set for union ->");
			IntSet s3 = new IntSet();
			System.out.print("\nSet1 is :");
			s1.displaySet();
			System.out.print("\nSet2 is :");
			s3.displaySet();
			IntSet unionSet = s1.union(s1.set, s3.set);
			System.out.print("\n5. Union Set is :");
			unionSet.displaySet();
			
			in.close();
		}
		catch(Exception e){
			System.out.print("Invalid Input!");
			System.exit(0);
		}
	}

}
