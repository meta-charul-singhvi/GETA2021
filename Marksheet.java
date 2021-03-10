/* @author Charul Singhvi
 *@date 03-03-2021
 *The class Marksheet stores the total number of students in the calss and their grades.
 *@getGrades gets the grades from user.
 *@getAverageGrade returns the average grade of class.
 *@getMinGrade returns the minimum grade of class.
 *@getMaxGrade returns the maximum grade of class.
 *@getpassPercentOfStudents returns the percent of students who cleared the exam.
 *@showGrades returns the grade card.
 *@performFunctions the parent non-static function calling all the functions.
*/

package ss;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Marksheet {
	Scanner scan = new Scanner(System.in);
	public int noOfStudents = 0;
	public double[] grades = new double[100];
	
	public Marksheet(){}
	/*
	 * reading grades from user
	 */
	public double getGrades(int id)
	{
		double grade;
		System.out.print("Enter grade for student "+id+" (0-100):");
		grade = scan.nextDouble();
		/*
		 * Validating grades to be between 0-100.
		 */
		while(grade<0 || grade>100){
			System.out.print("Please enter valid grades for student "+id+": ");
			grade = scan.nextDouble();
		}
		return grade;
	}
	
	/*
	 * Calculates average grade of class
	 */
	public float getAverageGrade ()throws ArithmeticException{
		float sum=0;
		for(int i=0; i< noOfStudents ; i++){
			sum += grades[i];
		}
		/*
		 * The formula will be : (sum*noOfStudents)/(noOfStudents*100) 
		 * Therefore avoiding unnecessary calculation the final answer will be : sum/100
		 */
		return (sum/100);
	}
	
	/*
	 * gets the minimum grade of class
	 */
	public double getMinGrade()throws Exception{
		double minGrade =101;
		for(int i=0; i<noOfStudents; i++){
			if(minGrade>grades[i])
				minGrade = grades[i];
		}
		if (minGrade>100 || minGrade<0)
			throw new Exception("Invalid Data!");
		return minGrade;
	}
	
	/*
	 * gets the maximum grade of the class
	 */
	public double getMaxGrade()throws Exception{
		double maxGrade =0;
		for(int i=0; i<noOfStudents; i++){
			if(maxGrade<grades[i])
				maxGrade = grades[i];
		}
		if (maxGrade<0 || maxGrade>100)
			throw new Exception("Invalid Data!");
		return maxGrade;
	}
	
	/*
	 * Gets the percent of students passed.
	 * Passing criteria : grade>=40
	 */
	public double getpassPercentOfStudents()throws ArithmeticException{
		float passingStudents =0;
		for(int i=0; i<noOfStudents; i++){
			if(grades[i] >= 40)
				passingStudents++;
		}
		return (passingStudents/noOfStudents) *100;
	}
	
	
	/*
	 * Display grade card
	 */
	public void showGrades(){
		System.out.print("\nThe grades of Students are : ");
		for(int i=0; i<noOfStudents; i++)
			System.out.print(grades[i]+"  ");
	}
	
	/*
	 * Helper function to call non-static functions to be performed. 
	 */
	public void performFunctions() throws InputMismatchException, Exception{
		try{
			System.out.print("Enter number of students in class : ");
			noOfStudents = scan.nextInt();
			/*
			 * Assuming capacity of class = 100
			 */
			while(noOfStudents <= 0 || noOfStudents>100)
			{
				System.out.print("Enter valid number of students in class (less than 101): ");
				noOfStudents = scan.nextInt();
			}
			for(int i=0; i<noOfStudents; i++){
				grades[i] = getGrades(i);
			}
			
			showGrades();
			
			float avgGrade = getAverageGrade();
			System.out.println("\nThe Average Grade of class is : "+avgGrade);
			
			double minGrade = getMinGrade();
			System.out.println("The Minimum Grade of class is : "+minGrade);
			
			double maxGrade = getMaxGrade();
			System.out.println("The Minimum Grade of class is : "+maxGrade);
			
			double passingPercentageOfStudents = getpassPercentOfStudents();
			System.out.println("The passing Percentage of Students in the class is : "+passingPercentageOfStudents);
		}
		catch(Exception e){
			System.out.print("Invalid Input!");
		}
	}
	
	/*
	 * Main class
	 */
	public static void main(String[] args) throws Exception{
		Marksheet m = new Marksheet();
		m.performFunctions();
	}
}
