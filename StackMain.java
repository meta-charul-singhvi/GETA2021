/*
 * @author: Charul Singhvi
 * @date : 08-03-2021
 */

package Stack_Queues;

import java.util.Scanner;

public class StackMain {

	public static void main(String[] args) {
		try{
			StackMain mainObject = new StackMain();
			mainObject.userInput();
		}
		catch (Exception e){
			System.out.println("Invalid input string! " + e.getMessage());
		}
	}
	
	/*
	 * function to get user input
	 */
	private void userInput() throws Exception{
		System.out.println("Enter space seperated expression : ");
		Scanner scan = new Scanner(System.in);
		String expressionInput = scan.nextLine();
		SolveExpression expression = new SolveExpression(expressionInput.length());
		int result = (expression.evaluateExpression(expressionInput));
		
		System.out.println(result);	
		scan.close();
	}
}