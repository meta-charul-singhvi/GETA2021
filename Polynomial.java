package poly;

import java.util.*;

public final class Polynomial{
	private final LinkedHashMap<Double,Double> poly = new LinkedHashMap<Double,Double>();
	int i,j;
	Scanner input =new Scanner(System.in);
	
	/*
	 * Constructor to initialize polynomial
	 */
	public Polynomial(){
		System.out.println("Enter the exponent and coefficient of  polynomial (In Desc Order), To stop entering input enter exponent = zero.");
		double exp = -1;
		double coeff;
		while(exp !=0){
			System.out.print("Enter the exponent of  polynomial :");
			exp = input.nextDouble();
			System.out.print("Enter the coefficient of  polynomial :");
			coeff = input.nextDouble();
			System.out.println("____");
			if(coeff!=0){
				poly.put(exp,coeff);
			}
			
		}
	}
	
	/*
	 * Constructor to initialize polynomial using parameterized method
	 */
	public Polynomial(LinkedHashMap<Double,Double> p){
		for(Double i : p.keySet()){
			poly.put(i, p.get(i));
		}
	}
	
	/*
	 * @return polynomial as HashMap(exponent,coefficient)
	 */
	public LinkedHashMap<Double,Double> getPolynomial(){
		return poly;
	}
	
	/*
	 * display polynomial as a String
	 */
	public void displayPolynomial(){
		Double min = Collections.min(poly.keySet());
		System.out.print("Polynimal: ");
		for (Double i : poly.keySet()) {
				if( i == min){
					System.out.println(poly.get(i));
				}
				else{
					System.out.print(poly.get(i)+"x^"+i+" + ");
				}			  
		}
		System.out.println("\n---------------");
	}
}