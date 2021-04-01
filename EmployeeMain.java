package employee;

import java.util.Scanner;

public class EmployeeMain {

	public static void main(String[] args) {
		EmployeeMain mainObject = new EmployeeMain();
		try {
			mainObject.userInput();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/*
	 * function to get user input
	 * 
	 * @throws exception
	 */
	private void userInput() throws Exception {
		EmployeeCollection employeeCollection = new EmployeeCollection();
		System.out.print("Example!");
		employeeCollection.addEmployee(new Employee(1, "Zyan", "Mudalpura"));
		employeeCollection.addEmployee(new Employee(3, "Kazi", "Jishangarh"));
		employeeCollection.addEmployee(new Employee(2, "Nina", "Kaziyabad"));
		employeeCollection.addEmployee(new Employee(5, "Jishu", "Sahilganj"));
		employeeCollection.addEmployee(new Employee(4, "Cyra", "Gidalvada"));
		employeeCollection.addEmployee(new Employee(6, "Cyria", "Chabalpura"));

		employeeCollection.displayUnsortedEmployeeList();
		
		java.util.List<Employee> sortedOnId = employeeCollection.sortById();
		System.out.println("\n--------Sorted by Id--------\n");
		System.out.println("\tId\tName");
		for (Employee employee : sortedOnId) {
			System.out.println("\t"+employee.getId()+"\t"+employee.getEmployeeName());
		}
		java.util.List<Employee> sortedOnName = employeeCollection.sortByName();
		System.out.println("\n--------Sorted by Name--------\n");
		System.out.println("\tId\tName");
		for (Employee employee : sortedOnName) {
			System.out.println("\t"+employee.getId()+"\t"+employee.getEmployeeName());
		}
		
		Scanner scan = new Scanner(System.in);
		while(true){
			System.out.print("\nDo you want to continue by entering more employee data(y/n): ");
			String choice = scan.next();
			switch(choice.toLowerCase()){
				case "y":
					System.out.print("Enter employee id :");
					int empId=scan.nextInt();
					while(empId<=0){
						System.out.print("Please enter valid employee id :");
						empId=scan.nextInt();
					}
					System.out.print("Enter employee name :");
					String empName = scan.next();
					System.out.print("Enter employee address :");
					String empAddress = scan.next();
					employeeCollection.addEmployee(new Employee(empId, empName, empAddress));
					break;
					
				case "n":
					
					employeeCollection.displayUnsortedEmployeeList();
					sortedOnId = employeeCollection.sortById();
					System.out.println("\n--------Sorted by Id--------\n");
					System.out.println("\tId\tName");
					for (Employee employee : sortedOnId) {
						System.out.println("\t"+employee.getId()+"\t"+employee.getEmployeeName());
					}
					sortedOnName = employeeCollection.sortByName();
					System.out.println("\n--------Sorted by Name--------\n");
					System.out.println("\tId\tName");
					for (Employee employee : sortedOnName) {
						System.out.println("\t"+employee.getId()+"\t"+employee.getEmployeeName());
					}
					System.out.print("Ok Thank You!");
					System.exit(0);
					
				default:
					System.out.print("Please enter valid choice");
			}
			
		}
	}
}
