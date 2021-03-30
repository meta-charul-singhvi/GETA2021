package college;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import myqueue.ListQueue;

/**
 * @author Charul Singhvi
 *
 */
public class College {

	private ListQueue<Student> studentQueue;
	private List<Program> programList;
	private Map<Student, String> allocRecord;
	/**
	 * Creates a list of students to process
	 * @param string file path of student excel sheet
	 * @throws FileNotFoundException 
	 */
	public void addStudents(String string) throws FileNotFoundException {
		studentQueue = new ListQueue<Student>();
		Scanner sc = new Scanner(new File(string));  
		sc.useDelimiter(","); 
		while (sc.hasNextLine()){  
			String name = sc.next();
			int rank = sc.nextInt();
			String[] choices = sc.nextLine().substring(1).split(",");
			Student s = new Student(name, rank, choices);
			studentQueue.enqueue(s);
		}   
		sc.close();

	}

	/**
	 * Creates a list of programs offered by college
	 * @param string file path of college programs excel sheet
	 * @throws FileNotFoundException 
	 */
	public void addPrograms(String string) throws FileNotFoundException {
		programList = new ArrayList<Program>();
		Scanner sc = new Scanner(new File(string));
		while (sc.hasNextLine()){  
			String token[] = sc.nextLine().split(",");
			String pname = token[0];
			int seat = Integer.parseInt(token[1]);
			//System.out.println(pname+"  "+ seat);
			Program prog = new Program(pname, seat);
			programList.add(prog);
		}   
		sc.close();

	}

	/**
	 * Allocates branch to students on the basis of Rank and arrival
	 */
	public void allocateBranch() {
		allocRecord = new HashMap<Student, String>();
		//Loop thorough each student in student queue
		for (int i = 0; i < studentQueue.size(); i++) {
			Student currStudent = studentQueue.dequeue();
			String choices[] = currStudent.getChoices();
			
			//loop and check if preferred choice is available
			for (int j = 0; j < choices.length; j++) {
				String choice = choices[j];
				boolean allocated = false;	//intialised with false
				
				//loop to programs list offered by college 
				for (int k = 0; k < programList.size(); k++) {
					Program currProgram = programList.get(k);
					if(choice.equalsIgnoreCase(currProgram.getProgram()) && currProgram.getSeat()>0){
						allocRecord.put(currStudent, choice);
						programList.get(k).decrSeat();
						System.out.println(choice+" allocated to "+ currStudent.getName());
						allocated = true;	//assign true if choice is allocated
						break;
					}
				}
				if(allocated){
					break;
				}
			}
		}
	}
	
	/**
	 * Shows allocated students and branch
	 */
	public void show(){
		for (Student st : allocRecord.keySet()) {
			System.out.println(st.getName()+"\t"+ st.getRank()+"\t"+allocRecord.get(st));
		}
	}
}