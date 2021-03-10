package cricket;

import java.util.ArrayList;
import java.util.List;

public class Match {
	
	private BowlerQueueInterface bowler;
	private int ballsToBeFaced;
	private int totalDeliveries = 0;
	
	//constructor
	public Match(int numberOfBowlers, int ballsToBeFaced) throws Exception{
		
		if ((numberOfBowlers<=0) || (ballsToBeFaced<=0)){
			throw new Exception ("Invalid Number Of Bowlers or Balls To Be Faced!");
		}
		this.bowler = new BowlerQueue(numberOfBowlers);
		this.ballsToBeFaced = ballsToBeFaced;
	}
	
	//adding bowler and increasing total number of deliveries of batsman
	public void addBowler(Bowler newBowler) throws Exception{
		
		if (newBowler == null){
			throw new Exception ("Null bowler object");
		}
		bowler.enQueue(newBowler);
		totalDeliveries = totalDeliveries + newBowler.getNumberOfDeliveries();
	}
	
	//arranging the order of baller so as to give minimum runs to batsman
	public void orderBowlers() throws Exception{
		if (totalDeliveries < ballsToBeFaced){
			throw new Exception ("Inadequate bowlers");
		}
		List <String> listOfSelectedBowlers = new ArrayList<>();
		List <Integer> listOfBallsToBeBalled = new ArrayList<>();		
		while (!bowler.isEmpty() && ballsToBeFaced > 0) {
			Bowler currentBowler = bowler.deQueue();
			
			listOfSelectedBowlers.add(currentBowler.getNameOfBowler());
			if(currentBowler.getNumberOfDeliveries() > ballsToBeFaced )
				listOfBallsToBeBalled.add(ballsToBeFaced);
			else
				listOfBallsToBeBalled.add(currentBowler.getNumberOfDeliveries());
			ballsToBeFaced = ballsToBeFaced- currentBowler.getNumberOfDeliveries();
		}
		
		System.out.println("----- List of bowlers -----");
		System.out.println("Name of bowler\tBalls bowled by Bowler");
		for (int i=0;i<listOfSelectedBowlers.size();i++){
			System.out.println(listOfSelectedBowlers.get(i)+"\t\t"+listOfBallsToBeBalled.get(i));
		}
		
	}
}