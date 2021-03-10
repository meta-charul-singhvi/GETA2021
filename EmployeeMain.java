package employee;

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
		employeeCollection.addEmployee(new Employee(1, "Zyan", "Mudalpura"));
		employeeCollection.addEmployee(new Employee(3, "Kazi", "Jishangarh"));
		employeeCollection.addEmployee(new Employee(2, "Nina", "Kaziyabad"));
		employeeCollection.addEmployee(new Employee(5, "Jishu", "Sahilganj"));
		employeeCollection.addEmployee(new Employee(4, "Cyra", "Gidalvada"));
		employeeCollection.addEmployee(new Employee(6, "Cyria", "Chabalpura"));

		java.util.List<Employee> sortedOnId = employeeCollection.sortById();
		System.out.println("-----Sorted by Id-----");
		for (Employee employee : sortedOnId) {
			System.out.println(employee.getId()+" "+employee.getEmployeeName());
		}
		java.util.List<Employee> sortedOnName = employeeCollection.sortByName();
		System.out.println("\n-----Sorted by Name-----");
		for (Employee employee : sortedOnName) {
			System.out.println(employee.getId()+" "+employee.getEmployeeName());
		}
	}
}
