/**
 * 
 */
package li.com;

/**
 * @author li
 *
 */
public abstract class Employee implements Payable {
	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	private Date birthday;

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	// four-argument constructor
	public Employee(String first, String last, String ssn, Date bday) {
		firstName = first;
		lastName = last;
		socialSecurityNumber = ssn;
		birthday = bday;
	} // end three-argument Employee constructor
	
	// set first name
	public void setFirstName(String first) {
		firstName = first; // should validate
	} // end method setFirstName
	
	// return first name
	public String getFirstName() {
		return firstName;
	} // end method getFirstName
	
	// set last name
	public void setLastName(String last) {
		lastName = last; // should validate
	} // end method setLastName
	
	// return last name
	public String getLastName() {
		return lastName;
	} // end method getLastName
		
	// set social security number
	public void setSocialSecurityNumber(String ssn) {
		socialSecurityNumber = ssn; // should validate
	} // end method setSocialSecurityNumber
	
	
	// return social security number
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	} // end method getSocialSecurityNumber
	
	// return String representation of Employee object
	@Override
	public String toString() {
			return String.format("%s %s\nsocial security number: %s", getFirstName(), getLastName(),
					getSocialSecurityNumber());
	} // end method toString
	
	public abstract String getInfo();
}// end abstract class Employee
