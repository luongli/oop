package li.com;

import java.io.Serializable;

public class Department implements Serializable {
	public static int MAX_EMPLOYEES = 100;
	private Employee employees[] = new Employee[MAX_EMPLOYEES];
	private int currentSize = 0;
	private String name;
	
	/**
	 * Constructor
	 */
	public Department(String name) {
		this.name = name;
	}
	
	public int getCurrentSize() {
		return currentSize;
	}

	public void setCurrentSize(int currentSize) {
		this.currentSize = currentSize;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Employee[] getEmployees() {
		return employees;
	}

	/**
	 * Add new employee to the department
	 * 
	 * return new size if success
	 */
	public int addEmployee(Employee e){
		if(currentSize == MAX_EMPLOYEES){
			throw new IllegalArgumentException(
					"The department is already full" );
		}else{
			for(int i = 0; i < currentSize; i++){
				//  check if the employee already exists
				if(e.getSocialSecurityNumber().equals(employees[i].getSocialSecurityNumber()))
					throw new IllegalArgumentException(
							"The entered employee already exists" );
			}
			employees[currentSize] = e;
			currentSize++;
			return currentSize;
		}
	}
	
	/**
	 * Delete an employee from the department by index
	 * return -1 if index is invalid
	 * return -2 if current size is 
	 * return new size if deletion is successful
	 */
	public int delEmployee(int index) {
		if(index < 0 || index >= MAX_EMPLOYEES){
			throw new IllegalArgumentException(
					"Invalid index" );
		} else if(currentSize != 0){
			for(int i = index; i < currentSize-1; i++){
				employees[i] = employees[i+1];
			}
			employees[currentSize-1] = null;
			currentSize--;
			return currentSize;
		}else{
			throw new IllegalArgumentException(
					"The department is empty" );
		}
	}
	
	/**
	 * Delete an employee by his social security number
	 * 
	 * return new size
	 */
	public int delEmployee(String ssn) {
		for(int i = 0; i < currentSize; i++) {
			if(employees[i].getSocialSecurityNumber().equals(ssn)) {
				return delEmployee(i);
			}
		}
		
		throw new IllegalArgumentException(ssn + " not found");
	}
	
}
