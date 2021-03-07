/*
 * @MultivariatePolynomialStructure is the polynomial structure consisting of multiple variable terms in it such 
 * as: 3.x^2.y^3 + 4.x.y , So here x and y are the multiple variables in the polynomial consisting of 2 terms
 * 
 * The structure is defined such as it has coeffiecient, variable list, degree of a term, pointer pointing to the 
 * next term.
 * 
 * Along with getting and setting the data members of class it has functions such as 
 * @addVariableToTerm
 * @showVariables
 * @getDegreeOfTerm
 */

package nestedLinkedList;

public class MultivariatePolynomialStructure {

	private int coefficient;
	
	//pointer to the first term of variable
	private Variable head;
		
	//degree of a term
	private int degree;
		
	//pointer to next term of polynomial
	private MultivariatePolynomialStructure nextTerm;
	
	//constructor
	public MultivariatePolynomialStructure(int coefficient){
		this.coefficient = coefficient;
	}
	
	// getters and setters
	public int getCoefficient() {
		return coefficient;
	}
	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}
	public Variable getVariables(){
		return this.head;
	}
	public MultivariatePolynomialStructure getNextTerm() {
		return nextTerm;
	}
	public void setNextTerm(MultivariatePolynomialStructure nextTerm) {
		this.nextTerm = nextTerm;
	}

	/*
	 * function to add variable to term of polynomial
	 * @variable is the Variable object 
	 */
	public void addVariableToTerm(Variable variable) {
		
		// if the term does not exist
		if (head == null){
			head = variable;
		}
		else{
			Variable tempVariable = head;
			while (tempVariable.getNextVariable()!=null){
				tempVariable = tempVariable.getNextVariable();
			}		
			tempVariable.setNextVariable(variable);
		}
	}
	
	/*
	 * function to display variables of a term
	 */
	public void showVariables() throws Exception{
		
		// Term is a constant
		if (head==null){
			return;
		}
		
		Variable tempVariable = head;
		
		//traversing through the variables
		while (tempVariable!=null){
			System.out.print("."+tempVariable.getVariable()+"^"+tempVariable.getPower());
			tempVariable = tempVariable.getNextVariable();
		}
	}
	
	/*
	 * function to get degree of a term
	 * @return degree of a term
	 */
	public int getDegreeOfTerm() throws Exception{
		
		if (head == null){
			return 0;
		}
		
		Variable tempVariable = head;
		degree = 0;
		
		//traversing through the variable
		while (tempVariable!=null){
			
			//adding degree of each variable of term
			degree += tempVariable.getPower();
			tempVariable = tempVariable.getNextVariable();
		}
		return degree;
	}
}