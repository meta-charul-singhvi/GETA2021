package sparseMatrix;

import java.util.Scanner;

/* @author : Charul Singhvi
 * @date 11-03-2021
 * Method to create an immutable class for representing two-dimensional sparse matrices. For space efficiency you 
 * should be storing only non zero elements of a matrix. It should support following methods: 
 * Method to return transpose of the matrix.
 * Method to check whether it is a symmetrical matrix.
 * Method to add two matrices.
 * Method to multiply two matrices.
*/

public final class SparseMatrix {
	private final int[][] sparseMatrixArray;
	private final int row;
	private final int column;
	
	static Scanner scan = new Scanner(System.in);
	
	private static int sumLoopCount =0;
	private static int productLoopCount =0;
	private static int transposeLoopCount =0;
	private static int symmetryLoopCount =0;
	
	public SparseMatrix(int[][] userArray) throws Exception{
		/* Constructor
		 * @param userArray is a two dimensional array representing sparse matrix given as input by the user.
		 * @throw exception when null value is entered.
		 */
		if (userArray==null){
			throw new Exception ("Null Value Array Passed");
		}
		
		if (userArray.length == 0){
			throw new Exception ("Array is empty.");
		}
		int countOfNonZeroElements = 0;
		for (int i = 0; i < userArray.length; i++) {
			for (int j = 0; j < userArray[0].length; j++) {
				if (userArray[i][j] != 0) {
					countOfNonZeroElements++;
				}
			}
		}

		sparseMatrixArray = new int[3][countOfNonZeroElements];
		int k = 0;
		for (int i = 0; i < userArray.length; i++) {
			for (int j = 0; j < userArray[0].length; j++) {
				if (userArray[i][j] != 0) {
					sparseMatrixArray[0][k] = i;
					sparseMatrixArray[1][k] = j;
					sparseMatrixArray[2][k] = userArray[i][j];
					k++;
				}
			}
		}

 		this.row = userArray.length;
 		this.column = userArray[0].length;
 	}


	public int[][] transposeOfMatrix(SparseMatrix sparseMatrixArray1) {
		/* Method to find the transpose of given matrix.
		 * @sparseMatrixArray1 is the input of class SparseMatrix given by the user.
		 * @return transposeMatrix is the matrix containing transpose of original matrix;
		 */
		
		int[][] transposeMatrix = new int[column][row];
		int rowIndex, columnIndex, value;
		for (int i = 0; i < sparseMatrixArray1.sparseMatrixArray[0].length; i++) {
			transposeLoopCount++;
			rowIndex = sparseMatrixArray[0][i];
			columnIndex = sparseMatrixArray[1][i];
			value = sparseMatrixArray[2][i];
			transposeMatrix[columnIndex][rowIndex] = value;
		}
		return transposeMatrix;
	}

	public Boolean symmetricMatrix(SparseMatrix userArray) {
		/* Method to find if a matrix is symmetric or not.
		 * @userArray is  the input of class SparseMatrix given by the user.
		 * @return true if matrix is symmetric and false otherwise.
		 */
		
		int[][] transposeMatrix = transposeOfMatrix(userArray);

		for (int i = 0; i < transposeMatrix.length; i++) {
			for (int j = 0; j < transposeMatrix[0].length; j++) {
				symmetryLoopCount++;
				if (transposeMatrix[i][j] != userArray.sparseMatrixArray[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	public int[][] addTwoMatrices(SparseMatrix firstUserArray,
			SparseMatrix secondUserArray) throws Exception {
		/* Method to add two sparse matrices.
		 * @firstUserArray is the first input of class SparseMatrix given by the user.
		 * @secondUserArray is the second input of class SparseMatrix given by the user.
		 * @return matrix containing the sum of two matrices.
		 * @throw exception if the order of matrices is not equal.
		 */
		if ((firstUserArray.sparseMatrixArray.length != secondUserArray.sparseMatrixArray.length)
				|| (firstUserArray.row != secondUserArray.row || firstUserArray.column != secondUserArray.column)) {
			throw new Exception("Addition cannot be performed due to different dimensions.");
		}
		int[][] sparseSumMatrix = new int[firstUserArray.sparseMatrixArray.length][firstUserArray.sparseMatrixArray[0].length];

		int[][] sumMatrix = new int[firstUserArray.row][firstUserArray.column];
		for (int i = 0; i < firstUserArray.sparseMatrixArray[0].length; i++) {
			sumLoopCount++;
			sumMatrix[firstUserArray.sparseMatrixArray[0][i]][firstUserArray.sparseMatrixArray[1][i]] += firstUserArray.sparseMatrixArray[2][i];
		}
		
		int loopCount=0;
		for (int i = 0; i < secondUserArray.sparseMatrixArray[0].length; i++) {
			loopCount++;
			sumMatrix[secondUserArray.sparseMatrixArray[0][i]][secondUserArray.sparseMatrixArray[1][i]] += secondUserArray.sparseMatrixArray[2][i];
		}
		if(sumLoopCount<loopCount)
			sumLoopCount=loopCount;
			loopCount=0;
		
		int sumMatrixNonZerocount = 0;
		for (int i = 0; i < sumMatrix.length; i++) {
			for (int j = 0; j < sumMatrix[i].length; j++) {
				loopCount++;
				if (sumMatrix[i][j] != 0) {
					sumMatrixNonZerocount++;
				}
			}
		}
		if(sumLoopCount<loopCount)
			sumLoopCount = loopCount;
			loopCount=0;
			
		
		sparseSumMatrix = new int[3][sumMatrixNonZerocount];
		for (int i = 0, index = 0; i < sumMatrix.length; i++) {
			for (int j = 0; j < sumMatrix[i].length; j++) {
				loopCount++;
				if (sumMatrix[i][j] != 0) {
					sparseSumMatrix[0][index] = i;
					sparseSumMatrix[1][index] = j;
					sparseSumMatrix[2][index] = sumMatrix[i][j];
					index++;
				}
			}
		}
		if(sumLoopCount<loopCount)
			sumLoopCount = loopCount;
			loopCount=0;
		
		
 		return sumMatrix;
	}

	public int[][] multiplyTwoMatrix(SparseMatrix firstUserArray,
			SparseMatrix secondUserArray) throws Exception {
		/* Method to add two sparse matrices.
		 * @firstUserArray is the first input of class SparseMatrix given by the user.
		 * @secondUserArray is the second input of class SparseMatrix given by the user.
		 * @return matrix containing the product of two matrices.
		 * @throw exception if the order of matrices does not allow multiplication to be performed.
		 */

		if (firstUserArray.column != secondUserArray.row) {
			throw new Exception("Multiplication cannot be performed.");
		}

		int[][] sparseProductMatrix = new int[firstUserArray.row][secondUserArray.column];

		for (int i = 0; i < firstUserArray.sparseMatrixArray[0].length; i++) {
			for (int j = 0; j < secondUserArray.sparseMatrixArray[0].length; j++) {
				productLoopCount++;
				if (firstUserArray.sparseMatrixArray[1][i] == secondUserArray.sparseMatrixArray[0][j]) {
					int r = firstUserArray.sparseMatrixArray[0][i];
					int c = secondUserArray.sparseMatrixArray[1][j];
					int product = firstUserArray.sparseMatrixArray[2][i]
							* secondUserArray.sparseMatrixArray[2][j];
					sparseProductMatrix[r][c] += product;
				}
			}
		}
		return sparseProductMatrix;
	}

	public static void show(int[][] matrix){
		
		for (int i = 0; i < matrix.length; i++) {
			System.out.print("\t");
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}

	}
	
	public static String checkComplexity(int row1, int column1, int loopCount){
		if(1 == loopCount)
			return "O(1)";
		if(row1 == loopCount)
			return "O(n) where n is the row dimension of the matrix";
		if(column1 == loopCount)
			return "O(n) where n is the column dimension of the matrix";
		if(row1+column1 == loopCount)
			return "O(m+n) where m is row dimension, n is column dimension of the matrix";
		if(row1*column1 == loopCount)
			return "O(mn) where m is row dimension, n is column dimension of the matrix";
		if(2*row1*column1 == loopCount)
			return "O(2mn) where m is row dimension, n is column dimension of the matrix";
		if((row1+column1)*2 == loopCount)
			return "O(2(m+n)) where m is row dimension, n is column dimension of the matrix";
		if(row1*row1 == loopCount || column1*column1==loopCount)
			return "O(n^2) where n is the dimension of matrix";
		if(row1/2 == loopCount)
			return "O(log n) where n is the row dimension of matrix";
		if(column1/2 == loopCount)
			return "O(log n) where n is the column dimension of matrix";
		if(row1*(column1/2) == loopCount)
			return "O(m log n) where m is the row dimension & n is the column dimension of matrix";
		return "";
	}
	
	public static void calculateComplexity(int row1, int column1)
	{
		System.out.println("The complexity of transpose is : "+checkComplexity(row1, column1, transposeLoopCount) + "->" + transposeLoopCount);
		System.out.println("The complexity of symmetricity is : "+checkComplexity(row1, column1, symmetryLoopCount)+ "->" +symmetryLoopCount);
		System.out.println("The complexity of addition is : "+checkComplexity(row1, column1, sumLoopCount)+ "->" +sumLoopCount);
		System.out.println("The complexity of multiplication is : "+checkComplexity(row1, column1, productLoopCount)+ "->" +productLoopCount);
		return;
		
	}
	
	public static int[][] input(int row, int column)throws NullPointerException, ArrayIndexOutOfBoundsException{
		int[][] array = new int[row][column];
		for(int i=0; i<row; i++){
			for(int j=0; j<column; j++){
				System.out.print("Please enter value in matrix at ["+i +"]["+ j + "] : ");
				array[i][j] = scan.nextInt();
			}
		}
		return array;
	}
	
	
	public static void main(String args[]) throws Exception {
		try{
 
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Enter the dimension of matrix 1 ->");
			System.out.print("Enter the number of row of matrix 1 :");
			int row1 = scan.nextInt();
			System.out.print("Enter the number of column of matrix 1 :");
			int column1 = scan.nextInt();
			int[][] array1 = input(row1, column1);
			
			
			System.out.println("Enter the dimension of matrix 2 ->");
			System.out.print("Enter the number of row of matrix 2 :");
			int row2 = scan.nextInt();
			System.out.print("Enter the number of column of matrix 2 :");
			int column2 = scan.nextInt();
			int[][] array2 = input(row2, column2);
			
			SparseMatrix matrix1 = new SparseMatrix(array1);
			SparseMatrix matrix2 = new SparseMatrix(array2);
			
			System.out.println("The transpose of the sparse matrix is : ");
			int[][] transposeMatrix = matrix1.transposeOfMatrix(matrix1);
			show(transposeMatrix);
			
			Boolean symmetricMatrix = matrix1.symmetricMatrix(matrix1);
			System.out.println("Checking if the matrix is symmetric : "+symmetricMatrix);
			
			System.out.println("The product of the sparse matrices will be : ");
			try{
				int[][] multiplyMatrix = matrix1.multiplyTwoMatrix(matrix1, matrix2);
				show(multiplyMatrix);
			}catch(Exception e){
				System.out.print(e.getMessage());
			}
			
			System.out.println("The sum of the sparse matrices will be : ");
			try{
				int[][] sumMatrix = matrix1.addTwoMatrices(matrix1, matrix2);
				show(sumMatrix);
			}catch(Exception e){
				System.out.print(e.getMessage());
			}
			
			System.out.println("The complexity of each method is ->");
			calculateComplexity(matrix1.row, matrix1.column);
			
			scan.close();
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage()+" - Please enter valid integer values!");
		}
	}
}