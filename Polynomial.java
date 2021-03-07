/*
 * @author - Charul Singhvi
 * @date - 07-03-2021
 * @Polynomial is a class which represent polynomials
 * which has parameters such as : Coefficient, exponent powers and degree
 * @inputPoly is a function which takes polynomial input from user and store in arrays
 * @displayPoly displays the polynomial in specific format
 * @getDegree returns the highest power of polynomial present
 * The operations to be performed on polynomials are : Add, Multiply, Evaluate
 */ 
import java.util.InputMismatchException;
import java.util.Scanner;

public class Polynomial {
	
	private int []coeff;
	private int []expo;
	private int degree;
	Scanner input = new Scanner(System.in);
	
	private void inputPoly(int id){
		int i;
		System.out.println("Enter highest power of polynomial "+id+" : ");
		degree = input.nextInt();
		coeff = new int[degree+1];
		expo = new int[degree+1];
		int inputCoeff =0;
		for(i=degree;i>=0;i--){
			expo[degree-i]=i;
			System.out.print("Enter coefficient for degree "+i+" : ");
			inputCoeff = input.nextInt();
			if (inputCoeff!=0)
				coeff[degree-i]=inputCoeff;
					
		}
		System.out.print("\n");
	}
	
	private void displayPoly(int n){
		int i;
		
		for(i=0;i<=degree;i++){
			if(coeff[i] != 0){
				if(i==degree){
					System.out.print(coeff[i]);
				}else{
					System.out.print(coeff[i]+"x^"+expo[i]+" +");
				}
			}
		}
		System.out.print("\n");
	}
	
	private int getDegree(){
		return degree;
	}
	
	/*
	 * Adds the 2 polynomial values provided acc to their exponents
	 */
	private void addPoly(Polynomial p1, Polynomial p2){
		int lenP1 = p1.expo.length;
		int lenP2 = p2.expo.length;
		int i; 
		
		degree = Math.max(lenP1-1, lenP2-1);
		coeff = new int[degree+1];
		expo = new int[degree+1];
		
		for(i=degree;i>=0;i--){
			expo[degree-i]=i;
		}
		
		if(lenP1>lenP2){
			
			for(i=degree;i>=lenP2;i--){
				coeff[degree-i]=p1.coeff[degree-i];
			}
			
			for(i=lenP2-1;i>=0;i--){
				coeff[degree-i]=p1.coeff[degree-i]+p2.coeff[degree-i-1];				
			}
		}else if(lenP1<lenP2){
			
			for(i=degree;i>=lenP1;i--){
				coeff[degree-i]=p2.coeff[degree-i];
			}
			
			for(i=lenP1-1;i>=0;i--){
				coeff[degree-i]=p2.coeff[degree-i]+p1.coeff[degree-i-1];				
			}
		}else{
			for(i=degree;i>=0;i--){
				coeff[degree-i]=p1.coeff[degree-i]+p2.coeff[degree-i];
			}
		}
	} 
	
	/*
	 * Evaluating polynomials
	 */
	private double evalPoly(){
		int n=coeff.length,i;
		double result = coeff[0]; 
		
		for (i=1;i<n;i++) 
			result = result*degree + coeff[i]; 
		return result; 
	} 
	
	/*
	 * Multipling polynomials
	 */
	private void mulPoly(Polynomial p1,Polynomial p2){
		int m=p1.coeff.length,n=p2.coeff.length;
		int []prod = new int[m+n-1];
		int i,j;
		
		for(i=0;i<m+n-1;i++){ 
			prod[i]=0; 
		} 
		 
		for(i=0;i<m;i++){
			for (j=0;j<n;j++){ 
				prod[i + j] += p1.coeff[i]*p2.coeff[j]; 
			} 
		}
		
		degree=prod.length-1;
		coeff = new int[degree+1];
		expo = new int[degree+1];
		for(i=degree;i>=0;i--){
			expo[degree-i]=i;
			coeff[degree-i]=prod[degree-i];
		}
	}

	public static void main(String[] args) throws Exception{
		try{
			Polynomial p1 = new Polynomial();
			Polynomial p2 = new Polynomial();
			//input polynomial
			p1.inputPoly(1);
			p2.inputPoly(2);
			System.out.println("Polynomial 1 :");
			p1.displayPoly(1);
			System.out.println("Degree: "+p1.getDegree());
			System.out.println("Evaluation: "+p1.evalPoly()+"\n");
			
			System.out.println("Polynomial 2 :");
			p2.displayPoly(2);
			System.out.println("Degree: "+p2.getDegree());
			System.out.println("Evaluation: "+p2.evalPoly()+"\n");
			
			
			System.out.println("Added Polynomial :");
			Polynomial p3 = new Polynomial();
			p3.addPoly(p1,p2);
			p3.displayPoly(3);
			System.out.println("Degree: "+p3.getDegree());
			System.out.println("Evaluation: "+p3.evalPoly()+"\n");
			
			System.out.println("Multiplied Polynomial :");
			Polynomial p4 = new Polynomial();
			p4.mulPoly(p1,p2);
			p4.displayPoly(4);
			System.out.println("Degree: "+p4.getDegree());
			System.out.println("Evaluation: "+p4.evalPoly()+"\n");
		}
		catch(InputMismatchException e){
			System.out.println("-----Your input should be a natural number!-----");
		}
		catch(Exception e){
			System.out.println("-----Your input should be a natural number!-----");
		}
	}
}