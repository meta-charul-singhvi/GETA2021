package set;

import java.util.*;

public final class IntSet {
	private final HashSet<Integer> set = new HashSet<Integer>();  // mutable
	int i;
	Scanner input = new Scanner(System.in);
	// constructor to initialize universal set
	private IntSet(){
		
		for(i=1; i<=1000 ;i++){
			set.add(i);
		}
	}
	
	
	// constructor to initialize variables when range is given
	private IntSet(int n){
		System.out.println("Enter elements of set: ");
		for(i=0; i<n ;i++){
			set.add(input.nextInt());
		}
	}
	
	private void getDisplay(){
		System.out.println("Elements of set: " + set);
	}
		
	// isMember
	private boolean isMember(int x){
		if(set.contains(x)){
			return true;
		}
		else{
			return false;
		}
	}
	//isSubset
	private boolean isSubSet(IntSet s){
		for( int ele : s.set){
			if(!set.contains(ele)){
				return false;
			}
		}
		return true;
	}
	
	private HashSet<Integer> getComplement(){
		HashSet<Integer> complementSet = new HashSet<Integer>();
		for(i=1; i<1000 ; i++){
			if(!isMember(i)){
				complementSet.add(i);
			}
		}
		return complementSet;
	}
	
	// union of two sets
	private HashSet<Integer> getUnion(IntSet s){
		HashSet<Integer> unionSet = new HashSet<Integer>();
		unionSet.addAll(set);
		unionSet.addAll(s.set);
		return unionSet;
	}

	
	public static void main(String[] args) {
		try{
			Scanner input = new Scanner(System.in);
			// enter first set
			System.out.print("Enter number of elements (range b/w 1-1000) for Main set :");
			int sixeOfMainSet = input.nextInt();
			while(sixeOfMainSet<=0){
				System.out.print("Please enter valid number of elements (range b/w 1-1000) for Main set :");
				sixeOfMainSet = input.nextInt();
			}
			IntSet set1 = new IntSet(sixeOfMainSet);
			
			//enter second set
			System.out.print("Enter number of elements (range b/w 1-1000) for Sub Set:");
			int sixeOfSubSet = input.nextInt();
			while(sixeOfSubSet<=0){
				System.out.print("Please enter valid number of elements (range b/w 1-1000) for sub set :");
				sixeOfSubSet = input.nextInt();
			}
			IntSet set2 = new IntSet(sixeOfSubSet);
			
			set1.getDisplay();
			set2.getDisplay();
			// calling various operations on set
			/*
			 * input for isMember method
			 */
			System.out.print("1. Enter a number to check if it is a member of the Main Set: ");
			int ele = input.nextInt();
			// check if element is part of set
			System.out.println("Result: "+set1.isMember(ele));
			
			/*
			 * isSubset(IntSet s)
			 */
			System.out.println("2. Check if second set is subset of first: ");
			System.out.println("Result: "+set1.isSubSet(set2));
			// get complement
			System.out.print("3. Get complement of a set ");
			System.out.println("Result: "+ set1.getComplement());
			// get complement
			System.out.print("4. Get union of two sets ");
			System.out.println("Result: "+ set1.getUnion(set2));
			
			input.close();
		
		}
		catch(InputMismatchException e){
			System.out.print("Input should be an integer value!");
			System.exit(0);
		}
		catch(NullPointerException e){
			System.out.print("Please enter some input! It should be an integer value!");
			System.exit(0);
		}
		catch(Exception e){
			System.out.print("Invalid Input! "+e.getMessage());
			System.exit(0);
		}
	}
}
