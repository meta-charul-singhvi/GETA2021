/*
 * @author : Charul Singhvi
 * @date : 04-03-2021
 */

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HexCalculator {
	private String n1,n2;
	/*
	 * We can change the base for generic conversion
	 */
	private static int base=16;
	public static HashMap<Character, Integer> value = new HashMap<Character,Integer>();

    /*
     *  Add keys and values like (A, 10) and so on for the hexadecimal values
     */
    public void initValue(){
    	value.put('0', 0);
    	value.put('1', 1);
    	value.put('2', 2);
    	value.put('3', 3);
    	value.put('4', 4);
    	value.put('5', 5);
    	value.put('6', 6);
    	value.put('7', 7);
    	value.put('8', 8);
    	value.put('9', 9);
    	value.put('A', 10);
    	value.put('B', 11);
    	value.put('C', 12);
    	value.put('D', 13);
    	value.put('E', 14);
    	value.put('F', 15);
    }
	
	HexCalculator(String n1,String n2){
		this.n1=n1;
		this.n2=n2;
	}
	/*
	 * output hex and decimal of it
	 */
	private void getNumber(){
		System.out.println("Input Hex Numbers: "+n1+" "+n2);
		System.out.println("Decimal Values: "+HexCalculator.toDecimal(n1)+" "+HexCalculator.toDecimal(n2));
	}
	/*
	 * To convert hex to decimal
	 */
	public static int toDecimal(String s){
		int num = 0,i,len=s.length();
		for(i=0;i<len;i++){
			num+=value.get(s.charAt(i))*Math.pow(base, len-i-1);
		}
		return num;
	}
	/*
	 * To convert decimal to hex
	 */
	private static String toHex(int n){
		return Integer.toHexString(n).toUpperCase();
	}
	/*
	 * arithmetic operations
	 */
	private String addNum(){
		return toHex(HexCalculator.toDecimal(n1)+HexCalculator.toDecimal(n2))+ "\t\t\tDecimal Value : "+ (HexCalculator.toDecimal(n1)+HexCalculator.toDecimal(n2));
	}
	private String subNum(){
		return toHex(HexCalculator.toDecimal(n1)-HexCalculator.toDecimal(n2))+ "\t\t\tDecimal Value : "+ (HexCalculator.toDecimal(n1)-HexCalculator.toDecimal(n2));
	}
 	private String mulNum(){
		return toHex(HexCalculator.toDecimal(n1)*HexCalculator.toDecimal(n2))+ "\t\t\tDecimal Value : "+ (HexCalculator.toDecimal(n1)*HexCalculator.toDecimal(n2));
	}
	private String divNum(){
		return toHex(HexCalculator.toDecimal(n1)/HexCalculator.toDecimal(n2))+" with reaminder " + toHex(HexCalculator.toDecimal(n1)%HexCalculator.toDecimal(n2))+
				"\tDecimal Value : " + (HexCalculator.toDecimal(n1)/HexCalculator.toDecimal(n2)+" with reaminder " + HexCalculator.toDecimal(n1)%HexCalculator.toDecimal(n2));
	}
	
	/*
	 * conditional operations
	 */
	private boolean checkEquals(){
		if(HexCalculator.toDecimal(n1)==HexCalculator.toDecimal(n2)){
			return true;
		}else{
			return false;
		}	
	}
	private boolean checkGreater(){
		if(HexCalculator.toDecimal(n1)>HexCalculator.toDecimal(n2)){
			return true;
		}else{
			return false;
		}
	}
	private boolean checkSmaller(){
		if(HexCalculator.toDecimal(n1)<HexCalculator.toDecimal(n2)){
			return true;
		}else{
			return false;
		}
	}
	

	public static int validInputCheck(String hexNum){
		/*Method to check if user has entered an invalid hexadecimal number as an input.
		 * @param HexNum
		 * @return 
		 */
		for (int i=0 ; i < hexNum.length() ; i++){
			if (Character.isLetter(hexNum.charAt(i))){
				if (!(hexNum.charAt(i) >= 'A' && hexNum.charAt(i) <= 'F')){
					return 1;
				}
			}
		} 
		return 0;
	}

	public static void main(String[] args) throws NullPointerException, InputMismatchException, Exception{
		try{
			Scanner scan = new Scanner(System.in);
			
			/*
			 * Takking input hexadecimal numbers and checking if they are valid or not
			 */
			System.out.println("Enter first Hexadecimal number:");
			String hexString1 = scan.next();
			int resultOfCheck = validInputCheck(hexString1.toUpperCase());
			if (resultOfCheck == 0){
				System.out.println("Enter second Hexadecimal number:");
				String hexString2 = scan.next();
				resultOfCheck = validInputCheck(hexString2.toUpperCase());
				if (resultOfCheck == 0){
				
					HexCalculator obj = new HexCalculator(hexString1.toUpperCase(),hexString2.toUpperCase());
					obj.initValue();
					//get number
					obj.getNumber();
					//add
					System.out.println("\nSum is: \t"+obj.addNum());
					//subtract
					System.out.println("Subtraction is: "+obj.subNum());
					//multiply
					System.out.println("Multiply is: \t"+obj.mulNum());
					//delete
					System.out.println("Division is: \t"+obj.divNum());
					//check equals
					System.out.println("\n"+hexString1.toUpperCase()+"==" +hexString2.toUpperCase()+ " : " +obj.checkEquals());
					//check greater
					System.out.println(hexString1.toUpperCase()+">" +hexString2.toUpperCase()+ " : " +obj.checkGreater());
					//check smaller
					System.out.println(hexString1.toUpperCase()+"<" +hexString2.toUpperCase()+ " : " +obj.checkSmaller());
					
				}
				else{
					System.out.println("Invalid HexaDecimal String. Please enter a valid string.");
				}
			}
			else{
				System.out.println("Invalid HexaDecimal String. Please enter a valid string.");
			}
			scan.close();
		}
		catch(NullPointerException e){
			System.out.println("Invalid HexaDecimal String. Please enter a valid string.");
		}
		catch(InputMismatchException e){
			System.out.println("Invalid HexaDecimal String. Please enter a valid string.");
		}
		catch(Exception e){
			System.out.println("Invalid HexaDecimal String. Please enter a valid string.");
		}
		
	}
}