/*
 * @author : Charul Singhvi
 * @date : 14-03-2021
 * Using Quick Sort algorithm to sort a linked-list of employees in descending order of salary
 */

package algorithm2EmployeeSorting;

public class EmployeeQuickSortMain {

	public static void main(String[] args) throws Exception {
		LinkedList linkedList = new LinkedList();
		linkedList.insert(new Employee("Hobi", 26, 13000));
		linkedList.insert(new Employee("Suga", 25, 16000));
		linkedList.insert(new Employee("Jin", 28, 14000));
		linkedList.insert(new Employee("Namjoon", 27, 15000));
		linkedList.insert(new Employee("Tae", 22, 19000));
		linkedList.insert(new Employee("Jimin", 22, 13000));
		linkedList.insert(new Employee("Kookie", 21, 12000));
		
		linkedList.showList();
		linkedList.sort();
		System.out.print("\n----------------------------------------------\nSorted ");
		linkedList.showList();
		
	}

}