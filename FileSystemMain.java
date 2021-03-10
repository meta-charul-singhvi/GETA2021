/*
 * @author : Charul Singhvi
 * @date : 09-03-2021
 */

package vcp;

import java.util.Scanner;

public class FileSystemMain {

	/**
	 * Main function to implement command line
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String args[]) throws Exception{
		try{
			
			System.out.println("Commands are:\nmkdir <Directory Name>\ncd <Directory Name>\nbk\nls\n"
					+ "find <Folder Name>\ntree\nexit");
			
			FileSystemMain mainObject = new FileSystemMain();
			mainObject.userInput();
		} catch (NullPointerException e) {
			System.out.println("Empty space is not a valid input. Please do enter some command stated above!");
		}
		catch (Exception e) {
			System.out.println(e.getMessage()+" is not a valid input. Please do enter some command stated above!");
		}
	}
	
	//getting user input 
	
	private void userInput() throws Exception{
		Scanner scan = new Scanner(System.in);
		FileSystem fileSystem = new FileSystem();
		boolean flag = true;
		
		while(flag) {
			fileSystem.displayPresentWorkingDirectory();
			String command = scan.nextLine();
			String[] tokens = command.split(" ");
			
			switch(tokens[0]) {
			case "mkdir":
				if(tokens.length != 2 || tokens[1].length() == 0){
					printInvalidSyntax();
				} else {
					fileSystem.addFolder(tokens[1]);
				}
				break;
			case "cd":
				if(tokens.length != 2 || tokens[1].length() == 0){
					printInvalidSyntax();
				} else {
					fileSystem.changeDirectory(tokens[1]);
				}
				break;
			case "bk":
				if(tokens.length != 1){
					printInvalidSyntax();
				} else {
					fileSystem.moveToParent();
				}
				break;
			case "ls":
				if(tokens.length > 2 || (tokens.length ==2 && tokens[1].length() == 0)){
					printInvalidSyntax();
				} else if(tokens.length == 1) {
					fileSystem.listSubDirectories(null);
				} else {
					fileSystem.listSubDirectories(tokens[1]);
				}
				break;
			case "exit":
				flag = false;
				break;
			case "find":
				if(tokens.length != 2 || tokens[1].length() == 0){
					printInvalidSyntax();
				} else {
					fileSystem.findFolder(tokens[1]);
					System.out.println();
				}
				break;
			case "tree":
				if(tokens.length != 1){
					printInvalidSyntax();
				} else {
					fileSystem.printTree();
				}
				break;
			default:
				System.out.println(tokens[0] + " is not recognised as a command!\n");
			}
		}
		
		scan.close();
	}
	
	/**
	 * Function to print invalid syntax message
	 */
	private void printInvalidSyntax(){
		System.out.println("The syntax of the command is incorrent!\n");
	}
	
}