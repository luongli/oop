package li.com;

public class Department {
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
	
	/**
	 * Add new employee to the department
	 * return -1 if the department is full
	 * return 0 if the employee already exists
	 * return new size if success
	 */
	public int addEmployee(Employee e){
		if(currentSize == MAX_EMPLOYEES){
			return -1;
		}else{
			for(int i = 0; i < currentSize; i++){
				if(e.getSocialSecurityNumber().equals(employees[i].getSocialSecurityNumber()))
					return 0;
			}
			employees[currentSize] = e;
			currentSize++;
			return currentSize;
		}
	}
	
	/**
	 * Delete an employee from the department by index
	 * return -1 if no employee is found
	 * return new size if deletion is successful
	 */
	
	
}
