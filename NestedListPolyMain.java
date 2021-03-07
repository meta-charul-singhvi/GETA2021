/*
 * @author : Charul Singhvi
 * @date : 07-03-2021
 * @NestedListPolyMain class consists of the main function calling all the functionalities 
 */
package nestedLinkedList;

import java.util.Scanner;

public class NestedListPolyMain {

	public static void main(String[] args) {
		Polynomial polynomial = new Polynomial();
		NestedListPolyMain object = new NestedListPolyMain();
		try{
			object.polynomialInput(polynomial);
			polynomial.showPolynomial();
			System.out.println("\nDegree of Polynomial : " +polynomial.degreeOfPolynomial());
		}
		
		catch(Exception exception){
			System.out.println(exception.getMessage());
		}
	}
	
	private void polynomialInput(Polynomial polynomial) throws Exception{
		try{
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter number of terms in a polynomial : ");
			int termsCount = scan.nextInt();
			while(termsCount<=0){
				System.out.println("Enter valid number of terms in a polynomial : ");
				termsCount = scan.nextInt();
			}
			//taking input for first term
			for(int i=0; i<termsCount; i++){
				
				System.out.println("\nEnter coefficient for term "+(i+1)+" : ");
				int coefficient = scan.nextInt();
				MultivariatePolynomialStructure termTemp = new MultivariatePolynomialStructure(coefficient);
				System.out.println("Enter number of variables in the term: ");
				int variableTerm = scan.nextInt();
				for(int j=0; j<variableTerm; j++){
					System.out.print("Enter variable "+(j+1)+" : ");
					char variable = scan.next().charAt(0);
					System.out.print("Enter power of variable "+(j+1)+" : ");
					int power = scan.nextInt();
					termTemp.addVariableToTerm(new Variable(variable ,power));
				}
				//adding first term
				polynomial.addTermToPolynomial(termTemp);
				
			}
			scan.close();
		}
		catch(Exception e){
			System.out.println("Invalid Input!");
			System.exit(0);
		}
	}
}