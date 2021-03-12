/*
 * @author : Charul Singhvi
 * @date : 11-03-2021
 */
package algorithm1EmployeeSorting;

public class EmployeeSortingMain {

	public static void main(String[] args) {

		EmployeeSortingMain mainObject = new EmployeeSortingMain();
		try {
			mainObject.userInput();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/*
	 * function to get input
	 */
	private void userInput() throws Exception{
		SortEmployees employeeSort = new SortEmployees();
		employeeSort.addEmployee(new Employee("Ada",100000,21));
		employeeSort.addEmployee(new Employee("Bila",500000,22));
		employeeSort.addEmployee(new Employee("Carol",905000,23));
		employeeSort.addEmployee(new Employee("Damon",120600,19));
		employeeSort.addEmployee(new Employee("Elena",110000,21));
		System.out.println("-----------Before sort-----------");
		System.out.println("\nEmployee Name\tEmployee Salary\t\tEmployee Age\n");
		employeeSort.showEmployeeList();
		employeeSort.sort();
		System.out.println("\n-----------After sort on basis of Salary & age-----------");
		System.out.println("\nEmployee Name\tEmployee Salary\t\tEmployee Age\n");
		employeeSort.showEmployeeList();
	}

}