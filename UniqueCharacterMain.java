/*
 * @author : Charul Singhvi
 * @date : 10-03-2021
 * @UniqueCharacter finds the unique characters count form the user's input
 */

package uniqueCharacter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UniqueCharacterMain {

	public static void main(String[] args){
		UniqueCharacterMain mainObject = new UniqueCharacterMain();
		try{
			mainObject.userInput();
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Oops! Something was wrong with the input. Please restart the program.");
		}
		catch(NullPointerException e){
			System.out.println(e.getMessage()+" is not a valid input!");
		}
		catch(InputMismatchException e){
			System.out.println(e.getMessage()+" isn't a valid input!");
		}
		catch (Exception e){
			System.out.println("Invalid input!");
		}
	}

	//function to get user input
	private void userInput() throws ArrayIndexOutOfBoundsException, InputMismatchException, Exception, NullPointerException{ 
		try{
			Scanner scan = new Scanner(System.in);
			
			System.out.print("Enter number of terms: ");
			int n = scan.nextInt();
			while(n<=0){
				System.out.print("Enter valid number of terms >0: ");
				n = scan.nextInt();
			}
			for(int i=0; i<n;i++ ){
				System.out.print("Enter a string : ");
				String inputStr = scan.next();
				UniqueCharacter character = new UniqueCharacter(inputStr);
				System.out.println("Unique number of characters in "+inputStr+" are : "+character.countUniqueCharacters());
			}
			System.out.println("------The End!------");
			scan.close();
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Oops! Something was wrong with the input. Please restart the program.");
		}
		catch(NullPointerException e){
			System.out.println(e.getMessage()+" is not a valid input!");
		}
		catch(InputMismatchException e){
			System.out.println(e.getMessage()+" is not a valid input!");
		}catch (Exception e) {
			System.out.println("Can't take it as a valid input!");
		}
	}
}