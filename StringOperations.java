/* @author Charul Singhvi
 *@date 03-03-2021
 *The class StringOpeations is used to perfrom basic operations on strings such as:
 *	@stringCompare returns the output as 1 if the 2 strings are equal else 0.
 *	@reverseString returns the reversed string.
 *	@reverseCaseOfString returns the string with reversed cases such as lower to upper and vica versa.
 *	@largestWordInString returns the largest word available in the string.
*/

package ss;
import java.util.*;

public class StringOperations {
	/*
	 * Comparing the characters of 2 strings at a particular index.
	 */
	public static int stringCompare(String s1, String s2, int l1, int l2){
		int flag=0;
		if(l1==l2){ 
			for(int i=0;i<l1;i++){
		        if(s1.charAt(i)!=s2.charAt(i)){
		            flag=0;
		            break;
		        }
		    }
		}
		else
			flag=0; 
		return flag;
	}
	
	/*
	 * Storing original string from last to another string and returning it.
	 */
	public static String reverseString(String str,int len){
		String revStr = "";
		for(int i=len-1; i>=0; i--){
			revStr += str.charAt(i);
		}
		return revStr;
	}
	
	/*
	 * Checking the case of particular character and reversing it.
	 */
	public static String reverseCaseOfString(String str, int len){
		String revCaseStr = "";
		for(int i=0; i<len; i++){
			//reversing the case
			if (str.charAt(i)==' ')
				revCaseStr += ' ';
			else if(Character.isLowerCase(str.charAt(i)))
				revCaseStr += Character.toUpperCase(str.charAt(i));
			else if(Character.isUpperCase(str.charAt(i)))
				revCaseStr += Character.toLowerCase(str.charAt(i));
		}
		return revCaseStr;
	}
	
	/*
	 * Returning word with maximum length in the string
	 */
	public static String largestWordInString (String str, int len){
		 
		String[] wordsArray = str.split(" ");
		String largestWordInStr = wordsArray[0];
		for(int i=0; i<wordsArray.length; i++){
			if(wordsArray[i].length() >= largestWordInStr.length()){
				largestWordInStr = wordsArray[i];
			}
		}
		return largestWordInStr;
		}
	
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		
		int len1,len2;
		String s1 ,s2;
		 
		System.out.println("Enter the 1st string");
		s1=scan.nextLine();
		System.out.println("Enter the 2nd string");
		s2=scan.nextLine();
		 
		len1=s1.length();
		len2=s2.length();
		 
		/*
		 * Calling function to compare 2 Strings
		 */
		 int compareString = stringCompare(s1, s2, len1, len2);
		 if(compareString==1)
			 System.out.println("The two string are EQUAL!!!\n");
		 else
			 System.out.println("The two string are NOT EQUAL!!!\n");
		 
		 
		 /*
		  * Calling function to reverse a String
		  */
		 String revStr = reverseString(s1, len1);
		 System.out.println("The reversed String1 is : " +revStr+"\n");
		 
		 
		 /*
		  * Calling function to reverse the case of String
		  */
		 String revCaseString = reverseCaseOfString(s1, len1);
		 System.out.println("The reversed Case String1 is : " +revCaseString+"\n");
		 
		 
		 /*
		  * Calling function to find Largest word in String
		  */
		 String largestWordInString = largestWordInString(s1, len1);
		 System.out.println("The largest word in the String1 is : " +largestWordInString+"\n");
		 
		 scan.close();
		
	}
}
