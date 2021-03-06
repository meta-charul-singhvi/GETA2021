/*
 * @author - Charul Singhvi
 * @date - 06-03-2021
 * @createMatrix creates an empty matrix and prints the N-Queen matrix
 * @nQueen is calling itself and checking for a particular row  
 * @checkIfQueenCanBePlaced checks if a queen can be placed in a particular cell or not
 */
package nQueen;
import java.util.InputMismatchException;
import java.util.Scanner;
public class N_Queens {

	/*
	 * Creating initial matrix and printing final Results
	 */
	public static void createMatrix(int dimensionOfMatrix){
		int [][] userInputArray = new int[dimensionOfMatrix][dimensionOfMatrix];
		for (int i=0;i<dimensionOfMatrix;i++){
			for (int j=0;j<dimensionOfMatrix;j++){
				userInputArray[i][j] = 0;
			}
		}
		nQueen(userInputArray,0,dimensionOfMatrix);
		for (int i=0;i<dimensionOfMatrix;i++){
			for (int j=0;j<dimensionOfMatrix;j++){
				System.out.print(userInputArray[i][j]);
			}
			System.out.println();
		}
	}
	
	/*
	 * Recursive method to solve the N-Queens problem
	 * Row specific method
	 */
	public static Boolean nQueen(int[][] userInputArray, int row, int dimensionOfMatrix) {
		
		if (row >= dimensionOfMatrix) {
			return true;
		}
		for (int i = 0; i < dimensionOfMatrix; i++) {
			if (checkIfQueenCanBePlaced(userInputArray, row, i,
					dimensionOfMatrix)) {
				userInputArray[row][i] = 1;
				if (nQueen(userInputArray, row + 1, dimensionOfMatrix)) {
					return true;
				}
				userInputArray[row][i] = 0;
			}
		}
		return false;

	}

	/*
	 * Method to check if queen can be placed in the cell.
	 */
	public static Boolean checkIfQueenCanBePlaced(int[][] userInputArray, int row, int column, int matrixDimension) {
		
		for (int i = 0; i < row; i++) {
			if (userInputArray[i][column] == 1) {
				return false;
			}
		}

		for (int i = row, j = column; i >= 0 && j < matrixDimension; i--, j++) {
			if (userInputArray[i][j] == 1) {
				return false;
			}
		}

		for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
			if (userInputArray[i][j] == 1) {
				return false;
			}
		}
		return true;
	}

	public static void main(String args[]) throws InputMismatchException, Exception {
		try{
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter the dimensions of N-Queens matrix : ");
			int dim = scan.nextInt();
			while(dim<=3){
				System.out.print("Please enter valid dimensions (>3) : ");
				dim = scan.nextInt();
			}
			createMatrix(dim);
			scan.close();
		}
		catch(InputMismatchException e){
			System.out.print("Invalid input!");
		}
		catch(Exception e){
			System.out.print("Invalid input!");
		}
	}
}
