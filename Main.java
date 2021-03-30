package college;

import java.io.FileNotFoundException;

public class Main {

	public static void main(String[] args) {
		College colObj = new College();
		try {
			colObj.addStudents("Student.csv");
			colObj.addPrograms("Program.csv");
			colObj.allocateBranch();
			colObj.show();
		} catch (FileNotFoundException e) {
			System.out.println("File not found: "+ e.getMessage());;
		}
	}
}