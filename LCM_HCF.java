/*
 * @author - Charul Singhvi
 * @date - 06-03-2021
 * @lcmOfNumbers is to calculate lcm of 2 given numbers using recusrion
 * @hcfOfNumbers is to calculate hcf of 2 given numbers using recusrion
 */
package lcm_hcf;
import java.util.InputMismatchException;
import java.util.Scanner;
public class LCM_HCF {

	/*
	 * calculating lcm of numbers
	 */
	public static double lcmOfNumbers(double x, double y, int count) throws Exception{
	
		if(x==0 || y==0)
			return 0;
		
		double lcm = 0;
		
		/*
		 * checking for the multiples of bigger number perfectly divisible by smaller number
		 */
		if((x*count) % y == 0)
			return x*count;
		
		/*
		 * recursively calling the function
		 */
		else{
			count++;
			lcm = lcmOfNumbers(x, y, count);
		}
		return lcm;
		
	}
	
	/*
	 * calculating hcf of numbers
	 */
	public static double hcfOfNumbers(double x, double y) throws Exception{
	
		if(x==0)
			return y;
		
		else if(y==0)
			return x;
		
		double hcf=1;
		
		/*
		 * checking for perfect division of remainder and the divisor after first division of the 2 digits
		 */
		if(x%y == 0)
			return y;
		else
			hcf = hcfOfNumbers(y, x%y);
		
		return hcf;
		
	}
	
	public static void main(String[] args) throws NullPointerException, StackOverflowError, InputMismatchException, Exception{
		try{
			Scanner scan = new Scanner(System.in);
			
			while(true){
			
				System.out.print("Enter digit 1 :");
				int digit1 = scan.nextInt();
				while(digit1<=0){
					System.out.print("Please enter a natural number : ");
					digit1 = scan.nextInt();
				}
				System.out.print("Enter digit 2 :");
				int digit2 =scan.nextInt();
				while(digit2<=0){
					System.out.print("Please enter a natural number : ");
					digit1 = scan.nextInt();
				}
				
				double first = Math.max(digit1, digit2);
				double second = Math.min(digit1, digit2);
				
				double lcm = lcmOfNumbers(first, second, 1);
				System.out.println("LCM of the numbers are : "+lcm);
				
				double hcf = hcfOfNumbers(first,second);
				System.out.println("HCF of the numbers are : "+hcf);
				
				System.out.println("Do you want to continue (true/false)?");
				Boolean conti = scan.nextBoolean();
				
				if(conti){}
				else if(!conti){
					System.out.println("Thank you for connecting!");
					System.exit(0);
				}
				else{
					System.out.println("Invalid Input!");
					System.exit(0);
				}
			}
		}
		catch(InputMismatchException e){
			System.out.println("Please enter integer values!");
		}
		catch(StackOverflowError e){
			System.out.println("Not acceptable inputs!");
		}
		catch(Exception e){
			System.out.println("Invalid Input!");
		}
		
	}
}
