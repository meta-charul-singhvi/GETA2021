/*
 * @Polynomial class defines the Polynomial which is mixture of @MultivariatePolynomialStructure 
 * Eg : 3.x^2.y^3 + 4.x.y   is a polynomial 
 * 
 * The structure is defined such as it has starting node of MultivariatePolynomialStructure to 
 * traverse through the list (polynomial terms) 
 * 
 * @addTermToPolynomial : insert terms to polynomial
 * @showPolynomial : display polynomial
 * @degreeOfPolynomial : returns the degree of polynomial
 */

package nestedLinkedList;

public class Polynomial {

	//pointer to the first term
	private MultivariatePolynomialStructure head;
	
	/*
	 * function to add term to polynomial
	 * @term is the term to be added
	 */
	public void addTermToPolynomial(MultivariatePolynomialStructure term){
		//if polynomial is empty
		if (head==null){
			head = term;
		}
		else{
			MultivariatePolynomialStructure tempTerm = head;
			while (tempTerm.getNextTerm()!=null){
				tempTerm = tempTerm.getNextTerm();
			}
			tempTerm.setNextTerm(term);
		}
	}
	
	/*
	 * function to show polynomial
	 */
	public void showPolynomial() throws Exception{
		
		MultivariatePolynomialStructure tempTerm = head;
		
		//fetching each term of polynomial
		System.out.print("Polynomial : ");
		while (tempTerm!=null){
			System.out.print(tempTerm.getCoefficient());
			
			//fetching variables for each term
			if(tempTerm.getVariables() != null){
				
				tempTerm.showVariables();
			}
			tempTerm = tempTerm.getNextTerm();
			if(tempTerm != null){
				System.out.print(" + ");
			}
		}
	}
	
	/*
	 * function to return degree of polynomial
	 * @return degree of polynomial
	 */
	public int degreeOfPolynomial() throws Exception{		
		if (head==null){
			return 0;
		}

		MultivariatePolynomialStructure tempTerm = head;
		int degreeOfPolynomial = 0;
		
		//traversing through the polynomial
		while (tempTerm!=null){
			if (tempTerm.getDegreeOfTerm()>degreeOfPolynomial){
				degreeOfPolynomial = tempTerm.getDegreeOfTerm();
			}
			tempTerm = tempTerm.getNextTerm();
		}
		return degreeOfPolynomial;
	}
}
