package algorithm1;

import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.json.JSONObject;
import org.json.JSONTokener;

public class BSTDictionaryMain {

	public static void main(String[] args) {
		BSTDictionaryMain mainObject = new BSTDictionaryMain();
		try {
			mainObject.userInput();
		} catch (Exception exception) {
			System.out.println(exception.getMessage());
		}
	}

	/*
	 * function to get input
	 */
	private void userInput() throws Exception {
		Scanner scan = new Scanner(System.in);
		FileReader file = new FileReader("C:/Users/charul.singhvi_metac/workspace/DSA Sessions/src/files/data.json");
		JSONTokener tokener = new JSONTokener(file);
		JSONObject object = new JSONObject(tokener);

		DictionaryInterface dictionary = new DictionaryUsingBST(object);
		dictionary.addElementToDictionary(new Element("Fine Arts", "1"));
		dictionary.addElementToDictionary(new Element("IT", "2"));
		dictionary.addElementToDictionary(new Element("PE", "3"));
		dictionary.addElementToDictionary(new Element("Entreprenuer", "4"));
		System.out.println("------------After insertion------------");
		dictionary.show();
		System.out.println("\n--------------After deletion------------"
				+ "\nList after deleting IT Entreprenuer PE from it\n");
		dictionary.deleteElement("IT");
		dictionary.deleteElement("Entreprenuer");
		dictionary.deleteElement("PE");
		
		List<Element> list = dictionary.sortKeyValuePairs();
		System.out.println("\nSize of list is : "+list.size()+"\n");
		showList(list);
		try{
			System.out.println("------------After sorting on condition------------");
			System.out.print("Enter String 1 :");
		
			String str1 = scan.next();
			System.out.print("Enter String 2 :");
			String str2 = scan.next();
		
			System.out.println("Condition being : "+str1+" - "+ str2+"\nList is :\n");
			List<Element> list1 = dictionary.sortKeyValuePairsOnCondition(str1,str2);
			if(list1.size()==0)
				System.out.println("List from '"+str1+" - "+str2+"' doesn't exist!");
			else{
				showList(list1);	
			}
		}
		catch(InputMismatchException e){
			System.out.print("Invalid input! Please enter a valid subject from above list.");
		}
		scan.close();
	}
	
	public void showList(List<Element> list){
		for (int i=0;i<list.size();i++){
			System.out.println("List Item "+list.get(i).getKey()+" "+list.get(i).getValue());
		}
		return;
	}

}