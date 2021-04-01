package employee;
import java.util.ArrayList;
import java.util.List;

//employee collection class
public class EmployeeCollection {

	// list of employee objects
	private List<Employee> employeeList;

	// constructor
	public EmployeeCollection() {
		employeeList = new ArrayList<>();
	}

	/*
	 * function to add employee to list
	 * @employee is the employee object
	 * throws Exception if employee object is null
	 */
	
	public void addEmployee(Employee employee) throws Exception {
		if (employee == null) {
			throw new Exception("Null object can't be added.");
		}

		// function to check for uniqueness of employee id
		if (isUniqueId(employee.getId())) {
			employeeList.add(employee);
			System.out.print("Employee added successfully!");
		} else {
			throw new Exception("ID is not unique");
		}
	}

	/*
	 * function to check whether employee id is unique
	 * @id is the employee id
	 * returns true if id is unique, false otherwise
	 */
	private Boolean isUniqueId(int id) {
		for (Employee iterator : employeeList) {
			if (iterator.getId() == id) {
				return false;
			}
		}
		return true;
	}
	
	
	/*
	 * function to sort employees based on id
	 * @return sorted list of employees
	 */
	public List<Employee> sortById() {
		List<Employee> sortedList = employeeList;

		for (int i = 0; i < sortedList.size(); i++) {
	
		    for (int j = sortedList.size() - 1; j > i; j--) {
		        if (sortedList.get(i).getId() > sortedList.get(j).getId()) {
	
		        	sortedList = sort(sortedList.get(i), sortedList.get(j), sortedList, i, j);
		        }
		    }
		}
		return sortedList;
	}
	
	/*
	 * function to sort employees based on name
	 * @return sorted list of employees
	 */
	public List<Employee> sortByName() throws Exception{
		List<Employee> sortedList = this.employeeList;
		
		for (int i = 0; i < sortedList.size(); i++) {
			
		    for (int j = sortedList.size() - 1; j > i; j--) {
		    	if (sortedList.get(i).getEmployeeName().toUpperCase().charAt(0) > sortedList.get(j).getEmployeeName().toUpperCase().charAt(0)) {
		        	
		    		sortedList = sort(sortedList.get(i), sortedList.get(j), sortedList, i, j);
        			
		        }
		    	
		    	else if (sortedList.get(i).getEmployeeName().charAt(0) == sortedList.get(j).getEmployeeName().charAt(0)) {
			    	for(int k=1; k< Math.min(sortedList.get(i).getEmployeeName().length(),sortedList.get(j).getEmployeeName().length()) ;k++){
				        if (sortedList.get(i).getEmployeeName().charAt(k) > sortedList.get(j).getEmployeeName().charAt(k)) {
				        	
				        	sortedList = sort(sortedList.get(i), sortedList.get(j), sortedList, i, j);
				        	break;
				        }
			    	}
		    	}
		    }
		}
		
		return sortedList;
	}
	public List<Employee> sort(Employee employee1, Employee employee2, List<Employee> sortedList, int i, int j){
		int tempId=-1;
    	String tempName="";
    	String tempAddress = "";
    	tempId = employee1.getId();
    	tempName = employee1.getEmployeeName();
		tempAddress = employee1.getEmployeeAddress();
		
		sortedList.get(i).setId(sortedList.get(j).getId());
		sortedList.get(i).setEmployeeName(sortedList.get(j).getEmployeeName());
		sortedList.get(i).setEmployeeAddress(sortedList.get(j).getEmployeeAddress());
		
		sortedList.get(j).setId(tempId);
		sortedList.get(j).setEmployeeName(tempName);
		sortedList.get(j).setEmployeeAddress(tempAddress);
		return sortedList;
	}
	
	public boolean checkIfEmpIdExistsAlready(int empId){
		for(Employee employee : employeeList){
			if(employee.getId() == empId)
				return false;
		}
		return true;
	}
	
	public void displayUnsortedEmployeeList(){
		System.out.println("--------Unsorted Employee List--------\n");
		System.out.println("\tId\tName");
		for (Employee employee : employeeList) 
			System.out.println("\t"+employee.getId()+"\t"+employee.getEmployeeName());
	}


}