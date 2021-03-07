/*
 * @Varible class defines the variable structure of a polynomial 
 * Eg: 3.x^2.y^3 + 4.x.y , So here x and y are the multiple variables in the polynomial 
 * 
 * The structure is defined such as it has char variable, power of variable, pointer pointing to the next variable 
 * since it is using nested list.
 * 
 * Contains getters and setters 
 */

package nestedLinkedList;

public class Variable {
	private char variable;
	private int power;
	private Variable nextVariable;

	//constructor
	Variable(char variable, int power) throws Exception{
		
		if (power<0){
			throw new Exception ("Degree cannot be less than zero");
		}
		
		this.variable = variable;
		this.power = power;
	}
	
	//getters and setters
	public char getVariable() {
		return variable;
	}
	
	public void setVariable(char variable) {
		this.variable = variable;
	}

	public int getPower() {
		return power;
	}

	public Variable getNextVariable() {
		return nextVariable;
	}

	public void setNextVariable(Variable nextVariable) {
		this.nextVariable = nextVariable;
	}
}
