package cricket;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CricketMain {

	public static void main(String[] args) throws InputMismatchException{
		CricketMain object = new CricketMain();
		try{
			object.userInput();
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
	
	//function to get user input about bowler and deliveries
	private void userInput() throws Exception{
		try{
			System.out.println("Enter number of bowlers : ");
			Scanner scan = new Scanner(System.in);
			int numberOfBowlers = scan.nextInt();
			/*
			 * Validating no of bowlers, considering range as 1000
			 */
			while(numberOfBowlers<=0 || numberOfBowlers>11){
				System.out.println("Enter valid number of bowlers (1-11): ");
				numberOfBowlers = scan.nextInt();
			}
			System.out.println("Number of bowlers will be considered as : "+numberOfBowlers);
			
			/*
			 * Validating no of balls to be faced
			 */
			System.out.println("Enter balls to be faced : ");
			int ballsToBeFaced = scan.nextInt();
			while(ballsToBeFaced<=0 || ballsToBeFaced>1000){
				System.out.println("Enter valid balls to be faced (1-1000): ");
				ballsToBeFaced = scan.nextInt();
			}
			System.out.println("Number of balls to be faced will be considered as : "+ballsToBeFaced);
			
			
			/*
			 * Match details
			 */
			Match match = new Match(numberOfBowlers,ballsToBeFaced);
			
			System.out.println("\n----- Enter bowler details ----- ");
			//loop to get bowler details
			int quota;
			for (int iterator =0; iterator<numberOfBowlers;iterator++){
				System.out.println("Enter name of bowler "+iterator+": ");
				String name = scan.next();
				System.out.println("Enter quota for bowler "+iterator+": ");
				quota = scan.nextInt();
				//validating number of deliveriews of bowler
				while(quota<=0){
					System.out.println("Please enter valid quota : ");
					quota = scan.nextInt();
				}
				//adding bowler to queue
				match.addBowler(new Bowler(name,(int)quota));
			}
			
			match.orderBowlers();
			scan.close();
		}
		catch (InputMismatchException e){
			System.out.println("Please enter a natural integer input for bowlers and balls!\nNot even decimals accepted!");
		}
	}
}
