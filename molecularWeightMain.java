/*
 * @author : Charul Singhvi
 * @date : 10-03-2021
 */
package molecularWeight;

import java.util.InputMismatchException;

public class molecularWeightMain {

	public static void main(String[] args) throws InputMismatchException{
		molecularWeightMain main = new molecularWeightMain();
		try {
			main.userInput();
		} catch (Exception exception) {
			System.out.println(exception.getMessage()+" isn't a valid input!");
		}
	}

	// function to get user input
	private void userInput() throws Exception{
	
		MolecularWeight weight = new MolecularWeight("C2H(OH2)2OH");
		System.out.println("Molecular weight of 'C2H(OH2)2OH' is :"+weight.getMolecularWeight());
		
		weight = new MolecularWeight("O2(S4)3");
		if (weight.getMolecularWeight() == -1)
		System.out.println("for Molecular equation 'O2(S4)3'");
		
		weight = new MolecularWeight("CHOC(CH3)3");
		System.out.println("\nMolecular weight of 'CHOC(CH3)3' is :"+weight.getMolecularWeight());
		weight = new MolecularWeight("K(CH2)5");
		if (weight.getMolecularWeight() == -1)
		System.out.println("for Molecular equation 'K(CH2)5'");
		System.out.println("\n-----------------The End!-----------------");
	
	}

}